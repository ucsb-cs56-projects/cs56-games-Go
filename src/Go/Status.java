package Go;

public class Status {
    private static boolean SFXonOrOff;
    private static boolean SkippedTurn;
    private static boolean GameIsOver;
    private static int WhiteScore;
    private static int BlackScore;


    public Status() {
        SFXonOrOff = true;
        SkippedTurn = false;
        WhiteScore = 0;
        BlackScore = 0;
        GameIsOver = false;
    }

    public static int getWhiteScore() {
        return WhiteScore;
    }

    public static void setWhiteScore(int whiteScore) {
        WhiteScore = whiteScore;
    }

    public static int getBlackScore() {
        return BlackScore;
    }

    public static void setBlackScore(int blackScore) {
        BlackScore = blackScore;
    }

    public static boolean getGameIsOver() {
        return GameIsOver;
    }

    public static void setGameIsOver(boolean gameIsOver) {
        GameIsOver = gameIsOver;
    }

    public static boolean getSkippedTurn() {
        return SkippedTurn;
    }

    public static void setSkippedTurn(boolean skippedTurn) {
        SkippedTurn = skippedTurn;
    }

    public static boolean getSFXonOrOff() {
        return SFXonOrOff;
    }

    public static void setSFXonOrOff(boolean SFXonOrOff) {
        Status.SFXonOrOff = SFXonOrOff;
    }
}
