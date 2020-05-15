package scripts.bbuu20_miner.main_tasks

import org.tribot.api.DynamicClicking
import org.tribot.api.General
import org.tribot.api2007.*
import scripts.bbuu20_api.Framework
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.bbuu20_api.enums.Rock
import scripts.bbuu20_miner.util.AntiBan
import scripts.dax_api.shared.helpers.BankHelper
import scripts.wastedbro.api.rsitem_services.GrandExchange

class Mine : Framework {
    override fun shouldProceed(): Boolean {
        return !Inventory.isFull()
                && !PlayerInfo.shouldUpgradePick()
                && PlayerInfo.currentRSRock != null
                && PlayerInfo.currentRSRock!!.isOnScreen
                && PlayerInfo.currentRSRock!!.isClickable
                && !BankHelper.isInBank()
    }

    override fun proceed() {
        val localCurrentRock = PlayerInfo.currentRSRock

        if (localCurrentRock != null) {
            if (ChooseOption.isOpen()) {
                ChooseOption.select("Mine")
            }
            else {
                val objsAtTile = Objects.getAt(localCurrentRock)
                if (objsAtTile.isNotEmpty()) {
                    DynamicClicking.clickRSObject(objsAtTile[0], "")
                }
            }

            val startingTime = System.currentTimeMillis() + General.randomLong(2500, 7500)

            AntiBan.get().hoverTargetActions()

            if (PlayerInfo.shouldPaint) {
                Objects.getAt(PlayerInfo.currentRSRock).forEach eachObj@{ rsObject ->
                    PlayerInfo.selectedRockTypes.forEach { rockType ->
                        rockType.ids.forEach { rockId ->
                            if (rsObject.id == rockId) {
                                var itemId = 0
                                when (rockType) {
                                    Rock.CLAY -> itemId = 434
                                    Rock.COPPER -> itemId = 436
                                    Rock.TIN -> itemId = 438
                                    Rock.LIMESTONE -> itemId = 3211
                                    Rock.IRON -> itemId = 440
                                    Rock.SILVER -> itemId = 442
                                    Rock.COAL -> itemId = 453
                                    Rock.PURE_ESSENCE -> itemId = 7936
                                    Rock.SANDSTONE -> itemId = 6971
                                    Rock.GOLD -> itemId = 444
                                    Rock.GEM -> itemId = 1625 //needs work, multiple gem rocks
                                    Rock.GRANITE -> itemId = 6979
                                    Rock.MITHRIL -> itemId = 447
                                    Rock.ADAMANTITE -> itemId = 449
                                    Rock.RUNITE -> itemId = 451
                                    Rock.AMETHYST -> itemId = 21347
                                    Rock.RUNE_ESSENCE -> TODO()
                                    Rock.BLURITE -> TODO()
                                    Rock.LOVAKITE -> TODO()
                                    Rock.EMPTY -> TODO()
                                    Rock.NULL -> TODO()
                                }
                                PlayerInfo.currentOrePrice = GrandExchange.getPrice(itemId)
                                return@eachObj
                            }
                        }
                    }
                }
            }

            while (((Player.isMoving() || Player.getAnimation() == -1) && localCurrentRock == PlayerInfo.currentRSRock) && startingTime > System.currentTimeMillis()) {
                PlayerInfo.updateAllRocks()
                General.sleep(10)
            }

            val startXp = Skills.getXP(Skills.SKILLS.MINING)
            val startedMining: Long = System.currentTimeMillis()
            while (localCurrentRock == PlayerInfo.currentRSRock && Player.getAnimation() != -1) {
                if (!PlayerInfo.isHoveringNextRock) {
                    AntiBan.get().idleTimedActions()
                }
                PlayerInfo.updateAllRocks()
                General.sleep(1)
            }
            if (startXp != Skills.getXP(Skills.SKILLS.MINING)) {
                PlayerInfo.gpMade += PlayerInfo.currentOrePrice
            }
            AntiBan.get().updateMiningStatistics(startedMining)
            AntiBan.get().generateAndSleep(startedMining)
        }
    }
}