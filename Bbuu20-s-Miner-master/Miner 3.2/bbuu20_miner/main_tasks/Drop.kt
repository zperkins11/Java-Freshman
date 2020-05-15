package scripts.bbuu20_miner.main_tasks

import org.tribot.api2007.Inventory
import scripts.bbuu20_api.Framework
import scripts.bbuu20_miner.data.Finals
import scripts.bbuu20_miner.data.PlayerInfo
import scripts.bbuu20_api.enums.MainTask

class Drop : Framework {
    override fun shouldProceed(): Boolean {
        return Inventory.isFull()
                && !PlayerInfo.shouldBank
                && PlayerInfo.selectedTask != MainTask.TICK_MINING
                && !PlayerInfo.shouldEndFullInv
    }

    override fun proceed() {
        while (Inventory.getCount(*Finals.ORE_IDS) > 0) {
            Inventory.dropAllExcept(*Finals.PICK_IDS)
        }
    }
}