package scripts.bbuu20_miner.util.worldhopping;

import org.tribot.api2007.Skills;

public class Stats {
    public static int getTotalLevel() {
        return
            Skills.SKILLS.ATTACK.getActualLevel() +
            Skills.SKILLS.HITPOINTS.getActualLevel() +
            Skills.SKILLS.MINING.getActualLevel() +
            Skills.SKILLS.STRENGTH.getActualLevel() +
            Skills.SKILLS.AGILITY.getActualLevel() +
            Skills.SKILLS.SMITHING.getActualLevel() +
            Skills.SKILLS.DEFENCE.getActualLevel() +
            Skills.SKILLS.HERBLORE.getActualLevel() +
            Skills.SKILLS.FISHING.getActualLevel() +
            Skills.SKILLS.RANGED.getActualLevel() +
            Skills.SKILLS.THIEVING.getActualLevel() +
            Skills.SKILLS.COOKING.getActualLevel() +
            Skills.SKILLS.PRAYER.getActualLevel() +
            Skills.SKILLS.CRAFTING.getActualLevel() +
            Skills.SKILLS.FIREMAKING.getActualLevel() +
            Skills.SKILLS.MAGIC.getActualLevel() +
            Skills.SKILLS.FLETCHING.getActualLevel() +
            Skills.SKILLS.WOODCUTTING.getActualLevel() +
            Skills.SKILLS.RUNECRAFTING.getActualLevel() +
            Skills.SKILLS.SLAYER.getActualLevel() +
            Skills.SKILLS.FARMING.getActualLevel() +
            Skills.SKILLS.CONSTRUCTION.getActualLevel() +
            Skills.SKILLS.HUNTER.getActualLevel();
    }
}
