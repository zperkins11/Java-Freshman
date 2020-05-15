package scripts.bbuu20_miner.data;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.util.Util;

public class Finals {
    public static final String PATH_TO_BBUU20_FOLDER = Util.getWorkingDirectory().getAbsolutePath() + "/bbuu20";
    public static final int SWAMP_TAR_ID = 1939;
    public static final int GRINDING_ID = 5249;
    public static final int[] HERB_IDS = {249, 251, 253, 255};
    public static final int[] ORE_IDS = {434, 436, 438, 440, 442, 444, 447, 449, 451, 453, 1617, 1619, 1621, 1623, 1625, 1627, 1629, 1761, 3211, 6971, 6973, 6975, 6977, 6979, 6981, 6983, 21347};
    public static final int[] PICK_IDS =
            {
                    1265,   //bronze pick
                    1267,   //iron pick
                    1269,   //steel pick
                    12297,  //black pick
                    1273,   //mithril pick
                    1271,   //adamant pick
                    1275,   //rune pick
                    11920   //dragon pick
            };
    public static final RSTile PORT_SARIM_DEPOSIT_BOX = new RSTile(3045, 3234);
    public static final RSTile PORT_SARIM_DEPOSIT_TILE = new RSTile(3045, 3235);
    public static final RSTile[][] TICK_ROCK_TILES =
            {
                    { //East Ardougne iron mine
                            new RSTile(2714, 3330) /* Rock 1 */,
                            new RSTile(2715, 3331) /* Rock 2 */,
                            new RSTile(2712, 3329) /* Rock 3 */,
                            new RSTile(2713, 3332) /* Rock 4 */,
                    },

                    { //Sandstone/Granite
                            new RSTile(3167, 2915) /* Rock 1 */,
                            new RSTile(3167, 2913) /* Rock 2 */,
                            new RSTile(3166, 2915) /* Rock 3 */,
                            new RSTile(3166, 2913) /* Rock 4 */,
                    },

                    { //Granite
                            new RSTile(3165, 2910) /* Rock 1 */,
                            new RSTile(3167, 2911) /* Rock 2 */,
                            new RSTile(3165, 2908) /* Rock 3 */,
                            new RSTile(3165, 2909) /* Rock 4 */,
                    }
            };
    public static final RSArea PORT_SARIM_DEPOSIT_AREA = new RSArea(
                            new RSTile(3052, 3237, 0),
                            new RSTile(3040, 3234, 0)
                    );
    public static final RSArea MINING_GUILD_P2P = new RSArea(
                            new RSTile(3060, 9729, 0),
                            new RSTile(3008, 9697, 0)
                    );
}