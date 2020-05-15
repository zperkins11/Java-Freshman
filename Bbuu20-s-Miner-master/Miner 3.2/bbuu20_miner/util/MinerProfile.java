package scripts.bbuu20_miner.util;

import org.apache.commons.io.FileUtils;
import org.tribot.api2007.types.RSTile;
import scripts.bbuu20_miner.data.Finals;
import scripts.bbuu20_api.enums.Pick;
import scripts.bbuu20_api.enums.Rock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MinerProfile {
    //Profile Settings
    private String profileName;

    //traditional mining
    private boolean shouldEndFullInv;
    private boolean isMembers;
    private boolean shouldBank;
    private boolean shouldHopDepleted;
    private int miningRadius;
    private Pick selectedPick;
    private RSTile startingTile;
    private int levelToStartAt;
    private int levelToEndAt;
    private List<Rock> selectedRockTypes;

    //progressive mining
    private List<ProgressiveTask> progressiveTasks;

    //universal settings
    private boolean shouldHopHighCompetition;
    private boolean shouldHopOnChat;
    private boolean shouldUseAntiPK;
    private boolean shouldPaint;
    private boolean shouldDrawDebug;
    private double reactionTime;
    private double fatigueRate;

    //getters
    public String getProfileName() {
        return this.profileName;
    }

    public boolean isShouldEndFullInv() {
        return shouldEndFullInv;
    }

    public boolean isMembers() {
        return isMembers;
    }

    public boolean isShouldBank() {
        return shouldBank;
    }

    public boolean isShouldHopDepleted() {
        return shouldHopDepleted;
    }

    public int getMiningRadius() {
        return miningRadius;
    }

    public Pick getSelectedPick() {
        return selectedPick;
    }

    public RSTile getStartingTile() {
        return startingTile;
    }

    public int getLevelToStartAt() {
        return levelToStartAt;
    }

    public int getLevelToEndAt() {
        return levelToEndAt;
    }

    public List<Rock> getSelectedRockTypes() {
        return selectedRockTypes;
    }

    public List<ProgressiveTask> getProgressiveTasks() {
        return progressiveTasks;
    }

    public boolean isShouldHopHighCompetition() {
        return shouldHopHighCompetition;
    }

    public boolean isShouldHopOnChat() {
        return shouldHopOnChat;
    }

    public boolean isShouldUseAntiPK() {
        return shouldUseAntiPK;
    }

    public boolean isShouldPaint() {
        return shouldPaint;
    }

    public boolean isShouldDrawDebug() {
        return shouldDrawDebug;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public double getFatigueRate() {
        return fatigueRate;
    }

    //override methods
    @Override
    public String toString() {
        return profileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinerProfile that = (MinerProfile) o;
        return profileName.equals(that.profileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileName);
    }

    //constructors
    public MinerProfile() {
        this.profileName = "";
        this.shouldEndFullInv = false;
        this.isMembers = false;
        this.shouldBank = false;
        this.shouldHopDepleted = false;
        this.miningRadius = 1;
        this.selectedPick = Pick.ANY_PICK;
        this.selectedRockTypes = new ArrayList<>();
        this.startingTile = new RSTile(0, 0);
        this.levelToStartAt = 1;
        this.levelToEndAt = 100;
        this.progressiveTasks = new ArrayList<>();
        this.shouldHopHighCompetition = false;
        this.shouldHopOnChat = false;
        this.shouldUseAntiPK = false;
        this.shouldPaint = false;
        this.shouldDrawDebug = false;
        this.reactionTime = 25;
        this.fatigueRate = 0;
    }
    public MinerProfile(String profileName, boolean shouldEndFullInv, boolean isMembers, boolean shouldBank, boolean shouldHopDepleted, int miningRadius, Pick selectedPick, List<Rock> selectedRockTypes, RSTile startingTile, int levelToStartAt, int levelToEndAt, List<ProgressiveTask> progressiveTasks, boolean shouldHopHighCompetition, boolean shouldHopOnChat, boolean shouldUseAntiPK, boolean shouldPaint, boolean shouldDrawDebug, double reactionTime, double fatigueRate) {
        this.profileName = profileName;
        this.shouldEndFullInv = shouldEndFullInv;
        this.isMembers = isMembers;
        this.shouldBank = shouldBank;
        this.shouldHopDepleted = shouldHopDepleted;
        this.miningRadius = miningRadius;
        this.selectedPick = selectedPick;
        this.selectedRockTypes = selectedRockTypes;
        this.startingTile = startingTile;
        this.levelToStartAt = levelToStartAt;
        this.levelToEndAt = levelToEndAt;
        this.progressiveTasks = progressiveTasks;
        this.shouldHopHighCompetition = shouldHopHighCompetition;
        this.shouldHopOnChat = shouldHopOnChat;
        this.shouldUseAntiPK = shouldUseAntiPK;
        this.shouldPaint = shouldPaint;
        this.shouldDrawDebug = shouldDrawDebug;
        this.reactionTime = reactionTime;
        this.fatigueRate = fatigueRate;
    }

    //file methods
    public void deleteMinerProfile(File minerProfile) throws IOException {
        FileUtils.forceDelete(minerProfile);
    }

    public boolean saveMinerProfile() throws IOException {
        File profileDirectory = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName);
        File traditionalMiningDirectory = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/traditionalMining");
        File progressiveMiningDirectory = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/progressiveMining");

        File profileSettings = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/profileSettings.txt");
        File universalSettings = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/universalSettings.txt");

        if (profileDirectory.exists()) {
            deleteMinerProfile(profileDirectory);
        }

        if (!profileDirectory.mkdirs()) {
            return false;
        }
        if (!profileSettings.exists()) {
            if (!profileSettings.createNewFile()) {
                return false;
            }
            FileWriter localWriter = new FileWriter(profileSettings);
            localWriter.write(profileName);
            localWriter.close();
        }
        if (!traditionalMiningDirectory.exists()) {
            File traditionalMining = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/traditionalMining/traditionalMining.txt");
            File selectedRocks = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/traditionalMining/selectedRocks.txt");

            if (!traditionalMiningDirectory.mkdirs()) {
                return false;
            }
            if (!traditionalMining.exists()) {
                if (!traditionalMining.createNewFile()) {
                    return false;
                }
                FileWriter localWriter = new FileWriter(traditionalMining);

                if (shouldEndFullInv) {
                    localWriter.write("1\n");
                }
                else {
                    localWriter.write("0\n");
                }
                if (isMembers) {
                    localWriter.write("1\n");
                }
                else {
                    localWriter.write("0\n");
                }
                if (shouldBank) {
                    localWriter.write("1\n");
                }
                else {
                    localWriter.write("0\n");
                }
                if (shouldHopDepleted) {
                    localWriter.write("1\n");
                }
                else {
                    localWriter.write("0\n");
                }
                localWriter.write(miningRadius + "\n");
                localWriter.write(startingTile.getX() + "\n");
                localWriter.write(startingTile.getY() + "\n");
                localWriter.write(levelToStartAt + "\n");
                localWriter.write(levelToEndAt + "\n");
                localWriter.write(selectedPick.toString() + "\n");

                localWriter.close();
            }
            if (!selectedRocks.exists()) {
                if (!selectedRocks.createNewFile()) {
                    return false;
                }
                FileWriter localWriter = new FileWriter(selectedRocks);

                for (Rock rock : selectedRockTypes) {
                    localWriter.write(rock.toString() + "\n");
                }
                localWriter.close();
            }
        }
        if (!progressiveMiningDirectory.exists()) {
            if (!progressiveMiningDirectory.mkdirs()) {
                return false;
            }

            for (ProgressiveTask progressiveTask : progressiveTasks) {
                File currentTaskDirectory = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/progressiveMining/" + progressiveTask.getTaskName());
                File currentTaskFile = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/progressiveMining/" + progressiveTask.getTaskName() + "/" + progressiveTask.getTaskName() + ".txt");
                File selectedRocks = new File(Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName + "/progressiveMining/" + progressiveTask.getTaskName() + "/selectedRocks.txt");

                if (!currentTaskDirectory.exists()) {
                    if (!currentTaskDirectory.mkdirs()) {
                        return false;
                    }
                    if (!currentTaskFile.exists()) {
                        if (!currentTaskFile.createNewFile()) {
                            return false;
                        }
                        FileWriter localWriter = new FileWriter(currentTaskFile);

                        if (progressiveTask.isShouldEndFullInv()) {
                            localWriter.write("1\n");
                        }
                        else {
                            localWriter.write("0\n");
                        }
                        if (progressiveTask.isShouldBank()) {
                            localWriter.write("1\n");
                        }
                        else {
                            localWriter.write("0\n");
                        }
                        if (progressiveTask.isShouldHop()) {
                            localWriter.write("1\n");
                        }
                        else {
                            localWriter.write("0\n");
                        }
                        if (progressiveTask.isMembers()) {
                            localWriter.write("1\n");
                        }
                        else {
                            localWriter.write("0\n");
                        }
                        if (progressiveTask.isShouldWalkOnStart()) {
                            localWriter.write("1\n");
                        }
                        else {
                            localWriter.write("0\n");
                        }
                        localWriter.write(progressiveTask.getRadius() + "\n");
                        localWriter.write(progressiveTask.getLevelToStartAt() + "\n");
                        localWriter.write(progressiveTask.getLevelToEndAt() + "\n");
                        localWriter.write(progressiveTask.getTileToTraverse().getX() + "\n");
                        localWriter.write(progressiveTask.getTileToTraverse().getY() + "\n");
                        localWriter.write(progressiveTask.getSelectedPick().toString() + "\n");

                        localWriter.close();
                    }
                    if (!selectedRocks.exists()) {
                        if (!selectedRocks.createNewFile()) {
                            return false;
                        }
                        FileWriter localWriter = new FileWriter(selectedRocks);

                        for (Rock rock : progressiveTask.getSelectedRocks()) {
                            localWriter.write(rock.toString() + "\n");
                        }
                        localWriter.close();
                    }
                }
            }
        }
        if (!universalSettings.exists()) {
            if (!universalSettings.createNewFile()) {
                return false;
            }

            FileWriter localWriter = new FileWriter(universalSettings);

            if (shouldHopHighCompetition) {
                localWriter.write("1\n");
            }
            else {
                localWriter.write("0\n");
            }
            if (shouldHopOnChat) {
                localWriter.write("1\n");
            }
            else {
                localWriter.write("0\n");
            }
            if (shouldUseAntiPK) {
                localWriter.write("1\n");
            }
            else {
                localWriter.write("0\n");
            }
            if (shouldPaint) {
                localWriter.write("1\n");
            }
            else {
                localWriter.write("0\n");
            }
            if (shouldDrawDebug) {
                localWriter.write("1\n");
            }
            else {
                localWriter.write("0\n");
            }
            localWriter.write(reactionTime + "\n");
            localWriter.write(fatigueRate + "\n");

            localWriter.close();
        }
        return true;
    }

    public boolean loadProfile(String profileName) throws FileNotFoundException {
        this.profileName = profileName;
        Scanner localReader;
        String PATH_TO_PROFILE_FOLDER = Finals.PATH_TO_BBUU20_FOLDER + "/miner/" + profileName;

        File profileDirectory = new File(PATH_TO_PROFILE_FOLDER);
        File progressiveMiningDirectory = new File(PATH_TO_PROFILE_FOLDER + "/progressiveMining");

        File traditionalMiningFile = new File(PATH_TO_PROFILE_FOLDER + "/traditionalMining/traditionalMining.txt");
        File traditionalMiningRocks = new File(PATH_TO_PROFILE_FOLDER + "/traditionalMining/selectedRocks.txt");
        File universalSettings = new File(PATH_TO_PROFILE_FOLDER + "/universalSettings.txt");

        if (!profileDirectory.exists() || !traditionalMiningFile.exists() || !traditionalMiningRocks.exists() || !universalSettings.exists() || !progressiveMiningDirectory.exists()) {
            return false;
        }

        /**
         * Local Loading
         */

        localReader = new Scanner(traditionalMiningFile);

        this.shouldEndFullInv = Integer.parseInt(localReader.nextLine()) == 1;
        this.isMembers = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldBank = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldHopDepleted = Integer.parseInt(localReader.nextLine()) == 1;
        this.miningRadius = Integer.parseInt(localReader.nextLine());
        this.startingTile = new RSTile(Integer.parseInt(localReader.nextLine()), Integer.parseInt(localReader.nextLine()));
        this.levelToStartAt = Integer.parseInt(localReader.nextLine());
        this.levelToEndAt = Integer.parseInt(localReader.nextLine());
        switch (localReader.nextLine()) {
            case "ANY_PICK":
                this.selectedPick = Pick.ANY_PICK;
                break;
            case "BRONZE_PICK":
                this.selectedPick = Pick.BRONZE_PICK;
                break;
            case "IRON_PICK":
                this.selectedPick = Pick.IRON_PICK;
                break;
            case "STEEL_PICK":
                this.selectedPick = Pick.STEEL_PICK;
                break;
            case "BLACK_PICK":
                this.selectedPick = Pick.BLACK_PICK;
                break;
            case "MITHRIL_PICK":
                this.selectedPick = Pick.MITHRIL_PICK;
                break;
            case "ADAMANT_PICK":
                this.selectedPick = Pick.ADAMANT_PICK;
                break;
            case "RUNE_PICK":
                this.selectedPick = Pick.RUNE_PICK;
                break;
            case "DRAGON_PICK":
                this.selectedPick = Pick.DRAGON_PICK;
                break;
            case "DECORATED_DRAGON_PICK":
                this.selectedPick = Pick.DECORATED_DRAGON_PICK;
                break;
            case "INFERNAL_PICK":
                this.selectedPick = Pick.INFERNAL_PICK;
                break;
        }
        localReader.close();

        localReader = new Scanner(traditionalMiningRocks);

        while (localReader.hasNextLine()) {
            switch (localReader.nextLine()) {
                case "CLAY":
                    this.selectedRockTypes.add(Rock.CLAY);
                    break;
                case "COPPER":
                    this.selectedRockTypes.add(Rock.COPPER);
                    break;
                case "TIN":
                    this.selectedRockTypes.add(Rock.TIN);
                    break;
                case "LIMESTONE":
                    this.selectedRockTypes.add(Rock.LIMESTONE);
                    break;
                case "IRON":
                    this.selectedRockTypes.add(Rock.IRON);
                    break;
                case "SILVER":
                    this.selectedRockTypes.add(Rock.SILVER);
                    break;
                case "COAL":
                    this.selectedRockTypes.add(Rock.COAL);
                    break;
                case "PURE_ESSENCE":
                    this.selectedRockTypes.add(Rock.PURE_ESSENCE);
                    break;
                case "SANDSTONE":
                    this.selectedRockTypes.add(Rock.SANDSTONE);
                    break;
                case "GOLD":
                    this.selectedRockTypes.add(Rock.GOLD);
                    break;
                case "GEM":
                    this.selectedRockTypes.add(Rock.GEM);
                    break;
                case "GRANITE":
                    this.selectedRockTypes.add(Rock.GRANITE);
                    break;
                case "MITHRIL":
                    this.selectedRockTypes.add(Rock.MITHRIL);
                    break;
                case "ADAMANTITE":
                    this.selectedRockTypes.add(Rock.ADAMANTITE);
                    break;
                case "RUNITE":
                    this.selectedRockTypes.add(Rock.RUNITE);
                    break;
                case "AMETHYST":
                    this.selectedRockTypes.add(Rock.AMETHYST);
                    break;
            }
        }
        localReader.close();

        /**
         * Progressive Loading
         */

        for (File taskFile : Objects.requireNonNull(progressiveMiningDirectory.listFiles())) {
            File progressiveFile = new File(taskFile.getAbsolutePath() + "/" + taskFile.getName() + ".txt");
            File rocksFile = new File(taskFile.getAbsolutePath() + "/selectedRocks.txt");

            if (!progressiveFile.exists() || !rocksFile.exists()) {
                return false;
            }

            ProgressiveTask progressiveTask = new ProgressiveTask();

            localReader = new Scanner(progressiveFile);

            progressiveTask.setTaskName(taskFile.getName());
            progressiveTask.setShouldEndFullInv(Integer.parseInt(localReader.nextLine()) == 1);
            progressiveTask.setShouldBank(Integer.parseInt(localReader.nextLine()) == 1);
            progressiveTask.setShouldHop(Integer.parseInt(localReader.nextLine()) == 1);
            progressiveTask.setMembers(Integer.parseInt(localReader.nextLine()) == 1);
            progressiveTask.setShouldWalkOnStart(Integer.parseInt(localReader.nextLine()) ==1);
            progressiveTask.setRadius(Integer.parseInt(localReader.nextLine()));
            progressiveTask.setLevelToStartAt(Integer.parseInt(localReader.nextLine()));
            progressiveTask.setLevelToEndAt(Integer.parseInt(localReader.nextLine()));
            progressiveTask.setTileToTraverse(new RSTile(Integer.parseInt(localReader.nextLine()), Integer.parseInt(localReader.nextLine())));

            switch (localReader.nextLine()) {
                case "ANY_PICK":
                    progressiveTask.setSelectedPick(Pick.ANY_PICK);
                    break;
                case "BRONZE_PICK":
                    progressiveTask.setSelectedPick(Pick.BRONZE_PICK);
                    break;
                case "IRON_PICK":
                    progressiveTask.setSelectedPick(Pick.IRON_PICK);
                    break;
                case "STEEL_PICK":
                    progressiveTask.setSelectedPick(Pick.STEEL_PICK);
                    break;
                case "BLACK_PICK":
                    progressiveTask.setSelectedPick(Pick.BLACK_PICK);
                    break;
                case "MITHRIL_PICK":
                    progressiveTask.setSelectedPick(Pick.MITHRIL_PICK);
                    break;
                case "ADAMANT_PICK":
                    progressiveTask.setSelectedPick(Pick.ADAMANT_PICK);
                    break;
                case "RUNE_PICK":
                    progressiveTask.setSelectedPick(Pick.RUNE_PICK);
                    break;
                case "DRAGON_PICK":
                    progressiveTask.setSelectedPick(Pick.DRAGON_PICK);
                    break;
                case "DECORATED_DRAGON_PICK":
                    progressiveTask.setSelectedPick(Pick.DECORATED_DRAGON_PICK);
                    break;
                case "INFERNAL_PICK":
                    progressiveTask.setSelectedPick(Pick.INFERNAL_PICK);
                    break;
            }
            localReader.close();

            localReader = new Scanner(rocksFile);
            List<Rock> localRocks = new ArrayList<>();

            while (localReader.hasNextLine()) {
                switch (localReader.nextLine()) {
                    case "CLAY":
                        localRocks.add(Rock.CLAY);
                        break;
                    case "COPPER":
                        localRocks.add(Rock.COPPER);
                        break;
                    case "TIN":
                        localRocks.add(Rock.TIN);
                        break;
                    case "LIMESTONE":
                        localRocks.add(Rock.LIMESTONE);
                        break;
                    case "IRON":
                        localRocks.add(Rock.IRON);
                        break;
                    case "SILVER":
                        localRocks.add(Rock.SILVER);
                        break;
                    case "COAL":
                        localRocks.add(Rock.COAL);
                        break;
                    case "PURE_ESSENCE":
                        localRocks.add(Rock.PURE_ESSENCE);
                        break;
                    case "SANDSTONE":
                        localRocks.add(Rock.SANDSTONE);
                        break;
                    case "GOLD":
                        localRocks.add(Rock.GOLD);
                        break;
                    case "GEM":
                        localRocks.add(Rock.GEM);
                        break;
                    case "GRANITE":
                        localRocks.add(Rock.GRANITE);
                        break;
                    case "MITHRIL":
                        localRocks.add(Rock.MITHRIL);
                        break;
                    case "ADAMANTITE":
                        localRocks.add(Rock.ADAMANTITE);
                        break;
                    case "RUNITE":
                        localRocks.add(Rock.RUNITE);
                        break;
                    case "AMETHYST":
                        localRocks.add(Rock.AMETHYST);
                        break;
                }
            }
            progressiveTask.setSelectedRocks(localRocks);
            localReader.close();
            this.progressiveTasks.add(progressiveTask);
        }

        /**
         * Universal Settings Loading
         */
        localReader = new Scanner(universalSettings);

        this.shouldHopHighCompetition = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldHopOnChat = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldUseAntiPK = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldPaint = Integer.parseInt(localReader.nextLine()) == 1;
        this.shouldDrawDebug = Integer.parseInt(localReader.nextLine()) == 1;
        this.reactionTime = Double.parseDouble(localReader.nextLine());
        this.fatigueRate = Double.parseDouble(localReader.nextLine());

        localReader.close();

        return true;
    }
}