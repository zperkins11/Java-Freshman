package scripts.bbuu20_miner.main_tasks

import org.tribot.api.General
import org.tribot.api.Timing
import org.tribot.api2007.Banking
import org.tribot.api2007.Inventory
import org.tribot.api2007.Player
import org.tribot.api2007.Walking
import org.tribot.api2007.types.RSArea
import org.tribot.api2007.types.RSTile
import scripts.bbuu20_api.Framework
import scripts.bbuu20_miner.data.Finals
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.dax_api.api_lib.DaxWalker
import scripts.dax_api.shared.helpers.BankHelper

class UpgradePick : Framework {
    override fun shouldProceed(): Boolean {
        return PlayerInfo.shouldUpgradePick()
    }

    override fun proceed() {
        if (!BankHelper.isInBank()) {
            if (Finals.MINING_GUILD_P2P.contains(Player.getPosition())) { //temporary fix until daxwalker supports mining guild
                Walking.blindWalkTo(
                    RSArea(
                        RSTile(3014, 9719, 0),
                        RSTile(3013, 9718, 0)
                    ).randomTile)
                Timing.waitCondition({ Player.isMoving()}, General.randomLong(500, 2500)) //wait for player to start moving
                Timing.waitCondition({!Player.isMoving()}, General.randomLong(500, 15000))
            }
            else {
                DaxWalker.walkToBank()
            }
        }
        else if (!Banking.isBankScreenOpen()) {
            Banking.openBank()
        }
        else if (Inventory.getCount(*Finals.PICK_IDS) > 0) {
            Banking.depositByIds(1, Finals.PICK_IDS.asList())
        }
        else {
            Banking.withdraw(1, PlayerInfo.selectedPick.id)
            if (Timing.waitCondition({Inventory.getCount(PlayerInfo.selectedPick.id) > 0}, General.randomLong(1500, 3500))) {
                Banking.close()
            }
        }
    }
}