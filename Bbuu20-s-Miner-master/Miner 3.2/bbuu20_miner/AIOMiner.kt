package scripts.bbuu20_miner

import org.tribot.api.General
import org.tribot.api.Timing
import org.tribot.api2007.*
import org.tribot.api2007.ext.Filters
import org.tribot.api2007.types.RSTile
import org.tribot.script.Script
import org.tribot.script.ScriptManifest
import org.tribot.script.interfaces.Arguments
import org.tribot.script.interfaces.MessageListening07
import org.tribot.script.interfaces.Painting
import org.tribot.util.Util
import scripts.bbuu20_api.Framework
import scripts.bbuu20_api.Paint
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.bbuu20_api.enums.MainTask
import scripts.bbuu20_miner.gui.GUIController
import scripts.bbuu20_miner.main_tasks.*
import scripts.bbuu20_miner.util.AntiBan
import scripts.dax_api.api_lib.DaxWalker
import scripts.dax_api.api_lib.models.DaxCredentials
import scripts.dax_api.api_lib.models.DaxCredentialsProvider
import scripts.fluffeepaint.FluffeesPaint
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.io.File
import java.text.DecimalFormat
import java.util.HashMap

@ScriptManifest(
    name = "Bbuu20's Miner",
    description = "Bbuu20's Miner. Join my discord, or leave a comment on the forum post for help/feedback.",
    category = "Mining",
    authors = ["bbuu20"],
    version = 3.2
)

class AIOMiner : Script(), Painting, MessageListening07, Arguments {
    private var tasks = ArrayList<Framework>()

    private var df: DecimalFormat? = DecimalFormat("#.##")
    private var font = Font("Helvetica Plain", Font.PLAIN, 14)

    private var startTime: Long = System.currentTimeMillis()
    private var startLvl = Skills.getActualLevel(Skills.SKILLS.MINING)
    private var startXP = Skills.getXP(Skills.SKILLS.MINING)

    override fun run() {
        initialize()
        while (shouldProceed()) {
            onLoop()
            General.sleep(5)
        }
    }

    override fun onPaint(graphics: Graphics?) {
        if (PlayerInfo.shouldDrawDebug) {
            if (PlayerInfo.startingTile.isOnScreen) {
                graphics?.drawPolygon(Projection.getTileBoundsPoly(PlayerInfo.startingTile, 0))
            }
            graphics?.color = Color(220, 240, 255)
            PlayerInfo.nonEmptyRocks.forEach { tile ->
                val objs = Objects.getAt(tile)
                if (objs.isNotEmpty()) {
                    objs[0].model.triangles.forEach { triangle ->
                        graphics?.drawPolygon(triangle)
                    }
                }
            }
            graphics?.color = Color(20, 200, 100)
            var objs = Objects.getAt(PlayerInfo.currentRSRock)
            if (objs.isNotEmpty()) {
                objs[0].model.triangles.forEach { triangle ->
                    graphics?.drawPolygon(triangle)
                }
            }
            graphics?.color = Color(240, 225, 70)
            objs = Objects.getAt(PlayerInfo.nextRSRock)
            if (objs.isNotEmpty()) {
                objs[0].model.triangles.forEach { triangle ->
                    graphics?.drawPolygon(triangle)
                }
            }
        }
        if (PlayerInfo.shouldPaint) {
            val timeRan: Long = System.currentTimeMillis() - startTime
            val currentLvl = Skills.getActualLevel(Skills.SKILLS.MINING)
            val gainedLvl: Int = currentLvl - startLvl
            val gainedXP: Double = Skills.getXP(Skills.SKILLS.MINING) - startXP.toDouble()
            val xpToLevel = Skills.getXPToNextLevel(Skills.SKILLS.MINING)
            val xpPerHour: Double = gainedXP * 3600 / timeRan
            val gpPerHour: Double = (PlayerInfo.gpMade * 3600 / timeRan).toDouble()

            graphics!!.color = Color.BLACK
            graphics.drawRect(10, 20, 230, 120)

            graphics.color = FluffeesPaint.makeTransparentColor(Color.GRAY, 50)
            graphics.fillRect(10, 20, 230, 120)

            graphics.font = font
            graphics.color = Color.WHITE

            graphics.drawString("Runtime: " + Timing.msToString(timeRan), 20, 35)
            graphics.drawString("Current lvl: $currentLvl (+$gainedLvl)", 20, 55)
            graphics.drawString("XP Gained: $gainedXP", 20, 75)
            graphics.drawString("GP Made: ${PlayerInfo.gpMade}", 20, 95)
            graphics.drawString("XP/H: " + df?.format(xpPerHour) + "k", 20, 115)
            graphics.drawString("GP/H: " + df?.format(gpPerHour) + "k", 20, 135)
            graphics.drawString("XP to next level: $xpToLevel", 55, 167)
            graphics.drawImage(Paint.getProgressBar(Skills.SKILLS.MINING, 230, 25, false), 10, 150, null)
        }
    }

    private fun addTasks() {
        tasks.add(UpgradePick())
        tasks.add(Drop())
        tasks.add(Bank())
        tasks.add(Mine())
        tasks.add(WalkToRocks())
    }

    private fun handleTasks() {
        for (task in tasks) {
            if (task.shouldProceed()) {
                task.proceed()
                break
            }
        }
    }

    private fun initialize() {
        DaxWalker.setCredentials(object : DaxCredentialsProvider() {
            override fun getDaxCredentials(): DaxCredentials {
                return DaxCredentials("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY")
            }
        })
        addTasks()
        if (PlayerInfo.shouldShowGui) {
            PlayerInfo.gui.show()
            while (PlayerInfo.gui.isOpen) {
                General.sleep(50)
            }
        }
        else {
            when (PlayerInfo.taskKey) {
                0 -> PlayerInfo.selectedTask = MainTask.TRADITIONAL_MINING
                1 -> PlayerInfo.selectedTask = MainTask.PROGRESSIVE_MINING
            }
            GUIController.argsStart()
        }
        if (PlayerInfo.startingTile == RSTile(-1, -1, 0) || PlayerInfo.startingTile == RSTile(0, 0, 0)) {
            PlayerInfo.startingTile = Player.getPosition()
        }
        if (PlayerInfo.selectedTask == MainTask.PROGRESSIVE_MINING) {
            PlayerInfo.levelToEndAt = 0
        }
    }

    private fun onLoop() {
        PlayerInfo.updateCurrentPick()
        PlayerInfo.updateAllRocks()
        handleTasks()
        handleWorldHopping()
    }

    private fun shouldHopAntiPK(): Boolean {
        if (Login.getLoginState() == Login.STATE.INGAME) {
            val lowCombat = Player.getRSPlayer().combatLevel - Combat.getWildernessLevel()
            val highCombat = Player.getRSPlayer().combatLevel + Combat.getWildernessLevel()
            val players =
                Players.getAll(Filters.Players.nameNotEquals(Player.getRSPlayer().name))
            for (player in players) {
                if (player.combatLevel in lowCombat..highCombat) {
                    while (Login.getLoginState() == Login.STATE.INGAME) {
                        Login.logout()
                        General.sleep(5)
                    }
                    return true
                }
            }
        }
        else {
            return true
        }
        return false
    }

    private fun handleWorldHopping() {
        val players = Players.getAll()
        var playersOnTile = -1 //set to -1 to account for our player
        players.forEach { player ->
            if (player.position == Player.getPosition()) {
                playersOnTile++
            }
        }
        if ((PlayerInfo.shouldHopDepleted && PlayerInfo.nonEmptyRocks.isEmpty() && !Inventory.isFull() && Player.getPosition().distanceTo(
                PlayerInfo.startingTile) <= PlayerInfo.miningRadius)
            || (PlayerInfo.shouldHopHighCompetition && AntiBan.get().shouldHopPlayerCount(playersOnTile))
            || (PlayerInfo.shouldUseAntiPK && shouldHopAntiPK())) {
            AntiBan.get().hopWorlds()
            Login.login() //check if we're logged out
            General.sleep(100, 500) //wait for new rocks to render
        }
    }

    private fun shouldProceed(): Boolean {
        if (PlayerInfo.shouldEndFullInv) {
            if (Inventory.isFull()) {
                println("Inventory is full")
                return false
            }
        }
        if (PlayerInfo.selectedTask == MainTask.TRADITIONAL_MINING) {
            if (Skills.SKILLS.MINING.actualLevel !in PlayerInfo.levelToStartAt until PlayerInfo.levelToEndAt) {
                println("Player is not in the specified mining level bracket.")
                Login.logout()
                return false
            }
        }
        else if (PlayerInfo.selectedTask == MainTask.PROGRESSIVE_MINING) {
            if (Skills.SKILLS.MINING.actualLevel !in PlayerInfo.levelToStartAt until PlayerInfo.levelToEndAt) {
                println(Skills.SKILLS.MINING.actualLevel)
                println(PlayerInfo.levelToStartAt)
                println(PlayerInfo.levelToEndAt)
                PlayerInfo.progressiveTasks.forEach { progressiveTask ->
                    if (Skills.SKILLS.MINING.actualLevel in progressiveTask.levelToStartAt until progressiveTask.levelToEndAt) {
                        PlayerInfo.levelToStartAt = progressiveTask.levelToStartAt
                        PlayerInfo.levelToEndAt = progressiveTask.levelToEndAt
                        PlayerInfo.shouldEndFullInv = progressiveTask.isShouldEndFullInv
                        PlayerInfo.isMembers = progressiveTask.isMembers
                        PlayerInfo.shouldBank = progressiveTask.isShouldBank
                        PlayerInfo.shouldHopDepleted = progressiveTask.isShouldHop
                        PlayerInfo.miningRadius = progressiveTask.radius
                        PlayerInfo.selectedPick = progressiveTask.selectedPick
                        PlayerInfo.selectedRockTypes = progressiveTask.selectedRocks
                        if (progressiveTask.tileToTraverse != RSTile(0, 0) && progressiveTask.tileToTraverse != RSTile(-1, -1)) {
                            PlayerInfo.startingTile = progressiveTask.tileToTraverse
                        }
                        return true
                    }
                }
                return false
            }
            return true
        }
        return true
    }

    override fun playerMessageReceived(name: String?, message: String?) {
        if (PlayerInfo.shouldHopOnChat) {
            AntiBan.get().hopWorlds()
        }
    }

    override fun passArguments(profileMap: HashMap<String, String>?) {
        if (profileMap?.get("custom_input")?.isNotEmpty()!!) {
            val fullText = profileMap["custom_input"]
            val strArr = fullText?.split(":")
            val profileName = strArr?.get(0)
            val taskKey = strArr?.get(1)

            PlayerInfo.profile = File(Util.getWorkingDirectory().absolutePath + "/bbuu20/miner/" + profileName)
            PlayerInfo.taskKey = Integer.parseInt(taskKey)
            PlayerInfo.shouldShowGui = false
        }
    }
}