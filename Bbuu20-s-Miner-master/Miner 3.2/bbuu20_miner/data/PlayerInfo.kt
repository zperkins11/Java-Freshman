package scripts.bbuu20_miner.data

import org.tribot.api2007.Equipment
import org.tribot.api2007.Inventory
import org.tribot.api2007.Objects
import org.tribot.api2007.Player
import org.tribot.api2007.types.RSTile
import scripts.bbuu20_api.enums.MainTask
import scripts.bbuu20_api.enums.Rock
import scripts.bbuu20_api.extensions.findNearest
import scripts.bbuu20_api.enums.Pick
import scripts.bbuu20_miner.gui.GUI
import scripts.bbuu20_miner.gui.MainGUIFXML
import scripts.bbuu20_miner.util.AntiBan
import scripts.bbuu20_miner.util.ProgressiveTask
import java.io.File

object PlayerInfo {
    val gui = GUI(MainGUIFXML.get)

    var profile = File("")
    var taskKey = -1
    var shouldShowGui = true

    var shouldEndFullInv = false
    var isMembers = false
    var shouldBank = false
    var isHoveringNextRock = false
    var shouldHopHighCompetition = false
    var shouldHopOnChat = false
    var shouldHopDepleted = false
    var shouldUseAntiPK = false
    var shouldCheckGuideOnOccasion = false
    var shouldOpenMapOnTraverse = false
    var shouldPaint = false
    var shouldDrawDebug = false

    var reactionTime = 25.0
    var fatigueRate = 0.0
    val startedRunTime = System.currentTimeMillis()
    var nextWorld = -1
    var miningRadius = 0
    var levelToStartAt = 0
    var levelToEndAt = 100
    var currentOrePrice = 0
    var gpMade = 0

    var startingTile = RSTile(-1, -1)

    var progressiveTasks = HashSet<ProgressiveTask>()
    var availableRocks = HashSet<RSTile>()
    var possibleNextRocks = HashSet<RSTile>()
    var selectedRockTypes: List<Rock> = listOf()
    var nonEmptyRocks = HashSet<RSTile>()
    var selectedPick = Pick.ANY_PICK
    var currentPick = Pick.ANY_PICK

    var currentRSRock: RSTile ?= null
    var nextRSRock: RSTile ?= null

    lateinit var selectedTask: MainTask

    private fun updateRocks() {
        val nearbyRocks = if (currentRSRock != null) {
            Objects().findNearest(
                miningRadius + Player.getPosition().distanceTo(
                    currentRSRock
                ), selectedRockTypes.toList())
        } else {
            Objects().findNearest(25, selectedRockTypes.toList())
        }
        val nearbyRockTiles = HashSet<RSTile>(10)

        nearbyRocks.forEach { rock ->
            nearbyRockTiles.add(rock.position)
            if (rock.position.distanceToDouble(startingTile) <= miningRadius) {
                availableRocks.add(rock.position)
                nonEmptyRocks.add(rock.position)
                possibleNextRocks.add(rock.position)
            }
        }
        nonEmptyRocks = nonEmptyRocks.intersect(nearbyRockTiles).toHashSet()
        possibleNextRocks = nonEmptyRocks.intersect(nearbyRockTiles).toHashSet()
    }
    private fun updateCurrentRock() {
        if (!nonEmptyRocks.contains(currentRSRock)) {
            if (nextRSRock == null) {
                currentRSRock = AntiBan.get().getNextTarget(
                    nonEmptyRocks
                )
            }
            else {
                currentRSRock =
                    nextRSRock; nextRSRock = null
            }
        }
        possibleNextRocks.remove(currentRSRock)
    }
    private fun updateNextRock() {
        if (nextRSRock == null || !possibleNextRocks.contains(
                nextRSRock!!)) {
            nextRSRock = AntiBan.get().getNextTarget(
                possibleNextRocks
            )
        }
    }
    fun shouldUpgradePick(): Boolean {
        return (selectedPick != currentPick && selectedPick != Pick.ANY_PICK) || currentPick == Pick.NO_PICK
    }
    fun updateAllRocks() {
        updateRocks()
        updateCurrentRock()
        updateNextRock()
    }
    fun updateCurrentPick() {
        if (Inventory.getCount(Pick.INFERNAL_PICK.id) > 0 || Equipment.isEquipped(Pick.INFERNAL_PICK.id)) {
            currentPick = Pick.INFERNAL_PICK
        }
        else if (Inventory.getCount(Pick.DECORATED_DRAGON_PICK.id) > 0 || Equipment.isEquipped(Pick.DECORATED_DRAGON_PICK.id)) {
            currentPick = Pick.DECORATED_DRAGON_PICK
        }
        else if (Inventory.getCount(Pick.DRAGON_PICK.id) > 0 || Equipment.isEquipped(Pick.DRAGON_PICK.id)) {
            currentPick = Pick.DRAGON_PICK
        }
        else if (Inventory.getCount(Pick.RUNE_PICK.id) > 0 || Equipment.isEquipped(Pick.RUNE_PICK.id)) {
            currentPick = Pick.RUNE_PICK
        }
        else if (Inventory.getCount(Pick.ADAMANT_PICK.id) > 0 || Equipment.isEquipped(Pick.ADAMANT_PICK.id)) {
            currentPick = Pick.ADAMANT_PICK
        }
        else if (Inventory.getCount(Pick.MITHRIL_PICK.id) > 0 || Equipment.isEquipped(Pick.MITHRIL_PICK.id)) {
            currentPick = Pick.MITHRIL_PICK
        }
        else if (Inventory.getCount(Pick.BLACK_PICK.id) > 0 || Equipment.isEquipped(Pick.BLACK_PICK.id)) {
            currentPick = Pick.BLACK_PICK
        }
        else if (Inventory.getCount(Pick.STEEL_PICK.id) > 0 || Equipment.isEquipped(Pick.STEEL_PICK.id)) {
            currentPick = Pick.STEEL_PICK
        }
        else if (Inventory.getCount(Pick.IRON_PICK.id) > 0 || Equipment.isEquipped(Pick.IRON_PICK.id)) {
            currentPick = Pick.IRON_PICK
        }
        else if (Inventory.getCount(Pick.BRONZE_PICK.id) > 0 || Equipment.isEquipped(Pick.BRONZE_PICK.id)) {
            currentPick = Pick.BRONZE_PICK
        }
        else {
            currentPick = Pick.NO_PICK
        }
    }
}