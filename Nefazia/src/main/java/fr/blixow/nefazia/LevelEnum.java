package fr.blixow.nefazia;

public enum LevelEnum {
    LEVEL0(0, "Niveau 0"),
    LEVEL1(100, "Niveau 1"),
    LEVEL2(200, "Niveau 2"),
    LEVEL3(300, "Niveau 3"),
    LEVEL4(400, "Niveau 4"),
    LEVEL5(500, "Niveau 5"),
    LEVEL6(600, "Niveau 6"),
    LEVEL7(700, "Niveau 7"),
    LEVEL8(800, "Niveau 8"),
    LEVEL9(900, "Niveau 9"),
    LEVEL10(1000, "Niveau 10");
    private final int xpNeeded;
    private final String levelAmount;

    LevelEnum(int xpNeeded, String levelAmount) {
        this.xpNeeded = xpNeeded;
        this.levelAmount = levelAmount;
    }

    public int getXpNeeded() {
        return xpNeeded;
    }

    public String getLevelAmount() {
        return levelAmount;
    }

    public LevelEnum getNextValue() {
        LevelEnum[] levelEnums = LevelEnum.values();
        int i = 0;
        for (; levelEnums[i] != this; i++);
        i++;
        return levelEnums[i];
    }

    public int getLevelLimit() {
        return 10;
    }
}
