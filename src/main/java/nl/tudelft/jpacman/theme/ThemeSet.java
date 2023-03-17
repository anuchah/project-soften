package nl.tudelft.jpacman.theme;

public enum ThemeSet {

    ORIGINAL("Original"),
    WAT2("Wat2"),
    WAT3("Wat3"),
    WAT4("Wat4"),
    WAT5("Wat5");

    private final String ThemeName;

    ThemeSet(String themeName) {
        this.ThemeName = themeName;
    }
    public String getThemeName(){
        return ThemeName;
    }
}
