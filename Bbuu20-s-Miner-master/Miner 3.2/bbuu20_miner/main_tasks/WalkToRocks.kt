package scripts.bbuu20_miner.main_tasks

import org.tribot.api.General
import org.tribot.api.Timing
import org.tribot.api2007.*
import scripts.bbuu20_api.Framework
import scripts.bbuu20_miner.data.Finals
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.dax_api.api_lib.DaxWalker
import scripts.dax_api.shared.helpers.BankHelper

class WalkToRocks : Framework {
    override fun shouldProceed(): Boolean {
        return !Inventory.isFull()
                && !PlayerInfo.shouldUpgradePick()
                && (
                        PlayerInfo.currentRSRock == null
                        || !PlayerInfo.currentRSRock!!.isOnScreen
                        || !PlayerInfo.currentRSRock!!.isClickable
                        || BankHelper.isInBank()
                )
    }

    override fun proceed() {
        if (BankHelper.isInBank()) {
            if (Finals.MINING_GUILD_P2P.contains(Player.getPosition())) { //temporary fix until daxwalker supports mining guild
                Walking.blindWalkTo(PlayerInfo.startingTile)
                Timing.waitCondition({ Player.isMoving()}, General.randomLong(500, 2500)) //wait for player to start moving
                Timing.waitCondition({!Player.isMoving()}, General.randomLong(500, 15000))
            }
            else {
                if (!PlayerInfo.startingTile.isOnScreen || !PlayerInfo.startingTile.isClickable) {
                    DaxWalker.walkTo(PlayerInfo.startingTile)
                }
                else {
                    Walking.blindWalkTo(PlayerInfo.startingTile)
                }
            }
        }
        else if (PlayerInfo.currentRSRock != null) {
            if (Finals.MINING_GUILD_P2P.contains(Player.getPosition())) { //temporary fix until daxwalker supports mining guild
                Walking.blindWalkTo(PlayerInfo.currentRSRock)
                Timing.waitCondition({ Player.isMoving()}, General.randomLong(500, 2500)) //wait for player to start moving
                Timing.waitCondition({!Player.isMoving()}, General.randomLong(500, 15000))
            }
            else if (Player.getPosition().distanceTo(PlayerInfo.currentRSRock) > General.random(1, 15)) {
                DaxWalker.walkTo(PlayerInfo.currentRSRock)
            }
            else {
                Camera.turnToTile(PlayerInfo.currentRSRock)
                if (!PlayerInfo.currentRSRock!!.isOnScreen || !PlayerInfo.currentRSRock!!.isClickable) {
                    DaxWalker.walkTo(PlayerInfo.startingTile)
                }
            }
        }
        else {
            if (Player.getPosition().distanceTo(PlayerInfo.startingTile) > General.random(8, 12)) {
                if (Player.getPosition().distanceTo(PlayerInfo.startingTile) > General.random(4, 15)) {
                    DaxWalker.walkTo(PlayerInfo.startingTile)
                }
                else {
                    Walking.blindWalkTo(PlayerInfo.startingTile)
                }
            }
        }
    }
}