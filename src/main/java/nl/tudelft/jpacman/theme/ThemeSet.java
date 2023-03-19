package nl.tudelft.jpacman.theme;

public enum ThemeSet {


    DEFAULT("Default",
        "src\\main\\resources\\Theme\\original.png",
        "/sprite/wall.png",
        "/sprite/pellet.png",
        "/sprite/pacman.png",
        "/sprite/ghost_red.png",
        "/sprite/ghost_pink.png",
        "/sprite/ghost_cyan.png",
        "/sprite/ghost_orange.png",
        "src\\main\\resources\\Theme\\black.jpg",
        "src/main/resources/Theme/lostwin/win.png",
        "src/main/resources/Theme/lostwin/lost.png"),
    Temple1("Temple1",
        "src\\main\\resources\\Theme\\temp2.png",
        "/sprite/pixil-frame-1.png",
        "/sprite/sushi.png",
        "/sprite/mspacman.png",
        "/sprite/ghost2/taneered.png",
        "/sprite/ghost2/taneepink.png",
        "/sprite/ghost2/taneecyan.png",
        "/sprite/ghost2/taneeor.png",
        "src\\main\\resources\\Theme\\gamewat2.png",
        "src/main/resources/Theme/lostwin/win2.png",
        "src/main/resources/Theme/lostwin/lost2.png"),

    Temple2("Temple2",
        "src\\main\\resources\\Theme\\temp3.png",
        "/sprite/pixil-frame-2.png",
        "/sprite/strawberry.png",
        "/sprite/pacman.png",
        "/sprite/ghost3/babyred.png",
        "/sprite/ghost3/babypink.png",
        "/sprite/ghost3/babycyan.png",
        "/sprite/ghost3/babyorange.png",
        "src\\main\\resources\\Theme\\gamewat3.png",
        "src/main/resources/Theme/lostwin/win3.png",
        "src/main/resources/Theme/lostwin/lost3.png"),

    Temple3("Temple3",
        "src\\main\\resources\\Theme\\temp4.png",
        "/sprite/pixil-frame-3.png",
        "/sprite/orange.png",
        "/sprite/mspacman.png",
        "/sprite/ghost4/eyered.png",
        "/sprite/ghost4/eyepink.png",
        "/sprite/ghost4/eyecyan.png",
        "/sprite/ghost4/eyeor.png",
        "src\\main\\resources\\Theme\\gamewat4.png",
        "src/main/resources/Theme/lostwin/win4.png",
        "src/main/resources/Theme/lostwin/lost4.png"),

    Temple4("Temple4",
        "src\\main\\resources\\Theme\\temp5.png",
        "/sprite/pixil-frame-4.png",
        "/sprite/melon.png",
        "/sprite/mspacman.png",
        "/sprite/ghost5/bloodred.png",
        "/sprite/ghost5/bloodpink.png",
        "/sprite/ghost5/bloodcyan.png",
        "/sprite/ghost5/bloodor.png",
        "src\\main\\resources\\Theme\\gamewat5.png",
        "src/main/resources/Theme/lostwin/win5.png",
        "src/main/resources/Theme/lostwin/lost5.png");

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
