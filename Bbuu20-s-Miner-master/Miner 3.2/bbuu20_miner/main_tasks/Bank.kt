package scripts.bbuu20_miner.main_tasks

import org.tribot.api.DynamicClicking
import org.tribot.api.General
import org.tribot.api.Timing
import org.tribot.api2007.*
import org.tribot.api2007.types.RSArea
import org.tribot.api2007.types.RSTile
import scripts.bbuu20_api.Framework
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.bbuu20_miner.data.Finals
import scripts.bbuu20_api.enums.MainTask
import scripts.dax_api.api_lib.DaxWalker
import scripts.dax_api.api_lib.WebWalkerServerApi
import scripts.dax_api.api_lib.models.PlayerDetails
import scripts.dax_api.api_lib.models.Point3D
import scripts.dax_api.shared.helpers.BankHelper


class Bank : Framework {
    override fun shouldProceed(): Boolean {
        return Inventory.isFull()
                && PlayerInfo.shouldBank
                && PlayerInfo.selectedTask != MainTask.TICK_MINING
                && !PlayerInfo.shouldEndFullInv
    }

    override fun proceed() {
        val pathResult = WebWalkerServerApi.getInstance().getBankPath(Point3D.fromPositionable(Player.getPosition()), null, PlayerDetails.generate())
        if (!BankHelper.isInBank() && !Finals.PORT_SARIM_DEPOSIT_AREA.contains(Player.getPosition())) {
            when {
                Finals.MINING_GUILD_P2P.contains(Player.getPosition()) -> { //temporary fix until daxwalker supports mining guild
                    Walking.blindWalkTo(
                        RSArea(
                            RSTile(3014, 9719, 0),
                            RSTile(3013, 9718, 0)
                        ).randomTile)
                    Timing.waitCondition({Player.isMoving()}, General.randomLong(500, 2500)) //wait for player to start moving
                    Timing.waitCondition({!Player.isMoving()}, General.randomLong(500, 15000))
                }
                Player.getPosition().distanceTo(Finals.PORT_SARIM_DEPOSIT_TILE) < pathResult.toRSTilePath()[pathResult.toRSTilePath().size - 1].distanceTo(Player.getPosition()) -> {
                    DaxWalker.walkTo(Finals.PORT_SARIM_DEPOSIT_TILE)
                }
                else -> {
                    DaxWalker.walkToBank()
                }
            }
        }
        else if (!Banking.isBankScreenOpen() && BankHelper.isInBank()) {
            Banking.openBank()
        }
        else if (!Banking.isDepositBoxOpen() && Finals.PORT_SARIM_DEPOSIT_AREA.contains(Player.getPosition())) {
            if (!Finals.PORT_SARIM_DEPOSIT_BOX.isOnScreen || !Finals.PORT_SARIM_DEPOSIT_BOX.isClickable) {
                Camera.turnToTile(Finals.PORT_SARIM_DEPOSIT_BOX)
            }
            DynamicClicking.clickRSTile(Finals.PORT_SARIM_DEPOSIT_BOX, "")
            Timing.waitCondition({Banking.isDepositBoxOpen()}, General.randomLong(1500, 5500))
        }
        else if (Inventory.isFull()) {
            Banking.depositAllExcept(*Finals.PICK_IDS)
            if (Timing.waitCondition({!Inventory.isFull()}, General.randomLong(1500, 3500))) {
                Banking.close()
            }
        }
    }
}