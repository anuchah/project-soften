package nl.tudelft.jpacman.theme;

public enum ThemeSet {

    DEFAULT("Default"),
    JAPAN("Japan"),
    HALLOWEEN("Halloween"),
    CITY("City");

    private final String ThemeName;

    ThemeSet(String themeName) {
        this.ThemeName = themeName;
    }
    public String getThemeName(){
        return ThemeName;
    }
}
