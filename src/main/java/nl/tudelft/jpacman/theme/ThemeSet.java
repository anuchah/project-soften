package nl.tudelft.jpacman.theme;

public enum ThemeSet {

    DEFAULT("Default", "/Theme/Original.png",
            "/sprite/wall.png", "/sprite/pellet.png", "/sprite/pacman.png",
            "/sprite/ghost_red.png", "/sprite/ghost_pink.png", "/sprite/ghost_cyan.png", "/sprite/ghost_orange.png",
            "/Theme/Original.png", "/Theme/Original.png", "/Theme/Original.png"),

    Temple1("Temple1", "/Theme/temp1.png", "/sprite/wall1.png", "/sprite/sushi.png", "/sprite/mspacman.png",
            "/sprite/ghost_red.png", "/sprite/ghost_pink.png", "/sprite/ghost_cyan.png", "/sprite/ghost_orange.png",
            "/Theme/temp1.png", "/Theme/temp1.png", "/Theme/temp1.png"),

    Temple2("Temple2", "/Theme/temp2.png", "/sprite/wall1.png", "/sprite/strawberry.png", "/sprite/pacman.png",
            "/sprite/ghost_red.png", "/sprite/ghost_pink.png", "/sprite/ghost_cyan.png", "/sprite/ghost_orange.png",
            "/Theme/temp2.png", "/Theme/temp2.png", "/Theme/temp2.png"),

    Temple3("Temple3", "/Theme/temp3.png", "/sprite/wall3.png", "/sprite/orange.png", "/sprite/mspacman.png",
            "/sprite/ghost_red.png", "/sprite/ghost_pink.png", "/sprite/ghost_cyan.png", "/sprite/ghost_orange.png",
            "/Theme/temp3.png", "/Theme/temp3.png", "/Theme/temp3.png"),

    Temple4("Temple4", "/Theme/temp4.png", "/sprite/wall4.png", "/sprite/melon.png", "/sprite/mspacman.png",
            "/sprite/ghost_red.png", "/sprite/ghost_pink.png", "/sprite/ghost_cyan.png", "/sprite/ghost_orange.png",
            "/Theme/temp4.png", "/Theme/temp3.png", "/Theme/temp3.png");

    private final String themeName;
    private final String pathSkinPacman;
    private final String pathWall;
    private final String pathBackgroundHome;
    private final String pathBackgroundGamplay;
    private final String pathBackgroundWin;
    private final String pathBackgroundLost;
    private final String pathPallet;
    private final String pathGhostBlinky;
    private final String pathGhostPinky;
    private final String pathGhostInky;
    private final String pathGhostClyde;

    ThemeSet(String themeName, String pathBackgroundHome,
            String pathWall, String pathPallet,
            String pathSkinPacman, String pathGhostBlinky, String pathGhostPinky, String pathGhostInky,
            String pathGhostClyde,
            String pathBackgroundGamplay, String pathBackgroundWin, String pathBackgroundLost) {
        this.themeName = themeName;
        this.pathSkinPacman = pathSkinPacman;
        this.pathWall = pathWall;
        this.pathPallet = pathPallet;
        this.pathBackgroundHome = pathBackgroundHome;
        this.pathBackgroundGamplay = pathBackgroundGamplay;
        this.pathBackgroundWin = pathBackgroundWin;
        this.pathBackgroundLost = pathBackgroundLost;
        this.pathGhostBlinky = pathGhostBlinky;
        this.pathGhostPinky = pathGhostPinky;
        this.pathGhostInky = pathGhostInky;
        this.pathGhostClyde = pathGhostClyde;
    }

    public String getThemeName() {
        return themeName;
    }

    public String getPathSkinPacman() {
        return pathSkinPacman;
    }

    public String getPathGhostBlinky() {
        return pathGhostBlinky;
    }

    public String getPathGhostPinky() {
        return pathGhostPinky;
    }

    public String getPathGhostInky() {
        return pathGhostInky;
    }

    public String getPathGhostClyde() {
        return pathGhostClyde;
    }

    public String getPathWall() {
        return pathWall;
    }

    public String getPathBackgroundHome() {
        return pathBackgroundHome;
    }

    public String getPathBackgroundGamplay() {
        return pathBackgroundGamplay;
    }

    public String getPathBackgroundWin() {
        return pathBackgroundWin;
    }

    public String getPathBackgroundLost() {
        return pathBackgroundLost;
    }

    public String getPathPallet() {
        return pathPallet;
    }
}
