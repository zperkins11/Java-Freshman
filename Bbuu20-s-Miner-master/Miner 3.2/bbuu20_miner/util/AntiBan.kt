package scripts.bbuu20_miner.util

import org.tribot.api.DynamicClicking
import org.tribot.api.General
import org.tribot.api.input.Mouse
import org.tribot.api.util.abc.ABCUtil
import org.tribot.api2007.ChooseOption
import org.tribot.api2007.WorldHopper
import org.tribot.api2007.types.RSTile
import scripts.bbuu20_miner.util.worldhopping.Worlds
import scripts.bbuu20_miner.data.PlayerInfo

class AntiBan private constructor() {
    private val abcInstance = ABCUtil()
    private var averageMiningWaitTime: Long = 0
    private var totalMiningWaitTime: Long = 0
    private var totalMiningInstances: Long = 0
    /*
     ***TIMED ACTIONS*** (25 pts)
     *
     * Checks timers based on our profile, performs timed action and prints action if bool returns true
     *
     * Our player is idling when we call this method
     */
    fun idleTimedActions() {
        if (abcInstance.shouldCheckTabs()) {
            println("Checking tabs.")
            abcInstance.checkTabs()
        }
        if (abcInstance.shouldCheckXP()) {
            println("Checking xp.")
            General.sleep(General.randomSD(1336, 542).toLong()) //sleep after checking xp
            abcInstance.checkXP()
        }
        if (abcInstance.shouldExamineEntity()) {
            println("Examining entity.")
            abcInstance.examineEntity()
        }
        if (abcInstance.shouldMoveMouse()) {
            println("Moving mouse.")
            abcInstance.moveMouse()
        }
        if (abcInstance.shouldPickupMouse()) {
            println("Picking up mouse.")
            abcInstance.pickupMouse()
        }
        if (abcInstance.shouldRightClick()) {
            println("Right clicking.")
            abcInstance.rightClick()
        }
        if (abcInstance.shouldRotateCamera()) {
            println("Rotating camera.")
            abcInstance.rotateCamera()
        }
        if (abcInstance.shouldLeaveGame()) {
            println("Leaving game.")
            abcInstance.leaveGame()
        }
    }

    /*
     ***Preferences*** (10 pts)
     *
     * Preferred ways of doing things based on our profile.
     *
     * Preferences implemented in this script:
     *      * Next target preference
     *
     * Preferences already handled by default in this script:
     *      * Walking preference
     *      * Open Bank Preference handled by default
     *      * Tab Switching Preference handled by default
     */

    fun getNextTarget(tiles: HashSet<RSTile>?): RSTile? {
        if (tiles.isNullOrEmpty()) {
            return null
        }
        return abcInstance.selectNextTarget(tiles.toTypedArray()) as RSTile
    }

    /*
     ***Action Conditions*** (26 pts)
     *
     * Generates when something should be done based on our profile.
     *
     * Preferences implemented in this script:
     *      * Energy to activate run at
     *      * Resource switching upon high competition (in the form of optional world hopping)
     *      * Hovering over next target
     *
     * Action Conditions already handled by default in this script:
     *      * HP to eat at not applicable is not applicable to mining
     *      * Moving to anticipated is not applicable to mining
     */
    fun getRunEnergyToActivate(): Int {
        return abcInstance.generateRunActivation()
    }
    fun shouldHopPlayerCount(competitionCount: Int): Boolean {
        if (abcInstance.shouldSwitchResources(competitionCount)) {
            return hopWorlds()
        }
        return false
    }
    fun hopWorlds(): Boolean {
        PlayerInfo.nextWorld = Worlds.getRandomWorld(PlayerInfo.isMembers)
        var canHop = Worlds.canHopToWorld(PlayerInfo.nextWorld)
        while (!canHop) {
            PlayerInfo.nextWorld = Worlds.getRandomWorld(PlayerInfo.isMembers)
            canHop = Worlds.canHopToWorld(PlayerInfo.nextWorld)
            General.sleep(1)
        }
        println("Hopping to world ${PlayerInfo.nextWorld}")
        PlayerInfo.currentRSRock = null
        PlayerInfo.nextRSRock = null
        return WorldHopper.changeWorld(PlayerInfo.nextWorld)
    }
    fun hoverTargetActions() {
        if (PlayerInfo.nextRSRock != null) {
            if (abcInstance.shouldHover() && Mouse.isInBounds()) {
                PlayerInfo.nextRSRock!!.hover()
                PlayerInfo.isHoveringNextRock = true
                if (abcInstance.shouldOpenMenu()) {
                    General.sleep(
                        General.randomSD(
                            71,
                            542
                        ).toLong()
                    ) //generate time between hovering and opening menu
                    if (!ChooseOption.isOpen()) {
                        DynamicClicking.clickRSTile(PlayerInfo.nextRSRock, 3)
                    }
                }
            }
        }
    }

    /*
     ***Reaction Times*** (40 pts)
     *
     * Generates reaction times using abc instead of using random sleeps
     *
     * Additional Reaction Time implemented in this script:
     *      * Generate current fatigue
     */
    fun updateMiningStatistics(startedMining: Long) {
        val lastMiningWaitTime = System.currentTimeMillis() - startedMining
        totalMiningInstances++
        totalMiningWaitTime += lastMiningWaitTime
        averageMiningWaitTime = totalMiningWaitTime / totalMiningInstances
    }

    private fun generateCurrentFatigue(): Long {
        val currentTime = System.currentTimeMillis() - PlayerInfo.startedRunTime
        return (PlayerInfo.fatigueRate * currentTime).toLong()
    }

    private fun generateSupportingTrackerInfo() { //Called right after clicking a rock
        abcInstance.generateTrackers(averageMiningWaitTime)
    }

    private fun generateReactionTime(waitingTime: Int): Int {
        return abcInstance.generateReactionTime(abcInstance.generateBitFlags(waitingTime)) //return reaction time in ms
    } //Called right after finishing mining a rock

    fun generateAndSleep(startTime: Long) { //sleeps for the generated amount of time. Called after reaction time is generated
        try {
            generateSupportingTrackerInfo()
            val time = generateReactionTime((System.currentTimeMillis() - startTime).toInt())
            val adjustedTime: Long = ((time.toLong() / PlayerInfo.reactionTime) + generateCurrentFatigue()).toLong()
            println("Sleeping for: $adjustedTime milliseconds.")
            abcInstance.sleep(adjustedTime)
        } catch (e: InterruptedException) {
            println("The background thread interrupted the abc sleep.")
        }
    }

    companion object {
        private val antiban = AntiBan()
        fun get(): AntiBan {
            return antiban
        }
    }
}