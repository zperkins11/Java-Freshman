package scripts.bbuu20_miner.util;

import org.tribot.api2007.types.RSTile;
import scripts.bbuu20_api.enums.Pick;
import scripts.bbuu20_api.enums.Rock;

import java.util.ArrayList;
import java.util.List;

public class ProgressiveTask {
    private String taskName; //The name entered by the user, and displayed in the Progressive Mining tab
    private boolean shouldEndFullInv;
    private boolean shouldBank;
    private boolean shouldHop;
    private boolean isMembers;
    private boolean shouldWalkOnStart; //whether we should walk to tileToTraverse
    private int radius;
    private int levelToStartAt;
    private int levelToEndAt;
    private RSTile tileToTraverse;
    private Pick selectedPick;
    private List<Rock> selectedRocks; //The rock(s) selected by the user

    public ProgressiveTask() {

    }
    public ProgressiveTask(String taskName, List<Rock> selectedRocks, Pick selectedPick, int radius, int levelToStartAt, int levelToEndAt, boolean shouldEndFullInv, boolean shouldBank, boolean shouldHop, boolean isMembers, boolean shouldWalkOnStart, RSTile tileToTraverse) {
        this.taskName = taskName;
        this.selectedPick = selectedPick;
        this.radius = radius;
        this.levelToStartAt = levelToStartAt;
        this.levelToEndAt = levelToEndAt;
        this.shouldEndFullInv = shouldEndFullInv;
        this.shouldBank = shouldBank;
        this.shouldHop = shouldHop;
        this.isMembers = isMembers;
        this.shouldWalkOnStart = shouldWalkOnStart;
        this.tileToTraverse = tileToTraverse;
        List<Rock> clonedRocks = new ArrayList<>(selectedRocks);
        this.selectedRocks = clonedRocks;
    }

    public String getTaskName() {
        return taskName;
    }

    public List<Rock> getSelectedRocks() {
        return selectedRocks;
    }

    public Pick getSelectedPick() {
        return selectedPick;
    }

    public int getRadius() {
        return radius;
    }

    public int getLevelToStartAt() {
        return levelToStartAt;
    }

    public int getLevelToEndAt() {
        return levelToEndAt;
    }

    public boolean isShouldEndFullInv() {
        return shouldEndFullInv;
    }

    public boolean isShouldBank() {
        return shouldBank;
    }

    public boolean isShouldHop() {
        return shouldHop;
    }

    public boolean isMembers() {
        return isMembers;
    }

    public boolean isShouldWalkOnStart() {
        return shouldWalkOnStart;
    }

    public RSTile getTileToTraverse() {
        return tileToTraverse;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setShouldEndFullInv(boolean shouldEndFullInv) {
        this.shouldEndFullInv = shouldEndFullInv;
    }

    public void setShouldBank(boolean shouldBank) {
        this.shouldBank = shouldBank;
    }

    public void setShouldHop(boolean shouldHop) {
        this.shouldHop = shouldHop;
    }

    public void setMembers(boolean members) {
        isMembers = members;
    }

    public void setShouldWalkOnStart(boolean shouldWalkOnStart) {
        this.shouldWalkOnStart = shouldWalkOnStart;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setLevelToStartAt(int levelToStartAt) {
        this.levelToStartAt = levelToStartAt;
    }

    public void setLevelToEndAt(int levelToEndAt) {
        this.levelToEndAt = levelToEndAt;
    }

    public void setTileToTraverse(RSTile tileToTraverse) {
        this.tileToTraverse = tileToTraverse;
    }

    public void setSelectedPick(Pick selectedPick) {
        this.selectedPick = selectedPick;
    }

    public void setSelectedRocks(List<Rock> selectedRocks) {
        this.selectedRocks = selectedRocks;
    }

    @Override
    public String toString() {
        return taskName + " with " + selectedPick + " (From Levels " + levelToStartAt + " -> " + levelToEndAt + ")";
    }
}
