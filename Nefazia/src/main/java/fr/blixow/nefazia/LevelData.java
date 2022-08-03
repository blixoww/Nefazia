package fr.blixow.nefazia;

public class LevelData {
    private LevelEnum level;
    private int xp;

    public LevelData(int xp) {
        this.xp = xp;
    }
    public LevelData(LevelEnum level, int xp) {
        this.level = level;
        this.xp = xp;
    }
    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
