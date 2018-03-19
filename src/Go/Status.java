package Go;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Status {
    private static boolean SFXonOrOff;
    private static boolean MusicOnOrOff;
    private static boolean SkippedTurn;
    private static boolean GameIsOver;
    private static boolean WhiteSurrendered;
    private static boolean BlackSurrendered;
    private static int WhiteScore;
    private static int BlackScore;
    private static ArrayList<String> Moves;
    private static int boardSize;



    public Status() {
        SFXonOrOff = true;
        MusicOnOrOff = true;
        SkippedTurn = false;
        WhiteScore = 0;
        BlackScore = 0;
        GameIsOver = false;
        WhiteSurrendered = false;
        BlackSurrendered = false;

        Moves = new ArrayList<String>();
        boardSize = 0;
    }

    public static void addMove(int col, int row, int state) {
        String aMove = col + "," + row + "," + state;
        Moves.add(aMove);
    }

    public static void storeGame() {
        try {
            FileOutputStream fileStream = new FileOutputStream("save.ser");
            ObjectOutputStream oStream = new ObjectOutputStream(fileStream);

            int storeSize = boardSize;
            ArrayList<String> storage = Moves;
            boolean storeSFX = SFXonOrOff;
            boolean storeMusic = MusicOnOrOff;
            boolean storeSkip = SkippedTurn;
            boolean storeGameOver = GameIsOver;
            boolean storeBlackSurrendered = BlackSurrendered;
            boolean storeWhiteSurrendered = WhiteSurrendered;

            oStream.writeObject(storeSize);
            oStream.writeObject(storage);
            oStream.writeObject(storeSFX);
            oStream.writeObject(storeMusic);
            oStream.writeObject(storeSkip);
            oStream.writeObject(storeGameOver);
            oStream.writeObject(storeBlackSurrendered);
            oStream.writeObject(storeWhiteSurrendered);

            oStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> getMoves() {
        return Moves;
    }

    public static void setMoves(ArrayList<String> moves) {
        Moves = moves;
    }

    public static int getBoardSize() {
        return boardSize;
    }

    public static void setBoardSize(int boardSize) {
        Status.boardSize = boardSize;

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

    public static boolean getWhiteSurrendered() {
        return WhiteSurrendered;
    }

    public static void setWhiteSurrendered(boolean whiteSurrendered) {
        WhiteSurrendered = whiteSurrendered;
    }

    public static boolean getBlackSurrendered() {
        return BlackSurrendered;
    }

    public static void setBlackSurrendered(boolean blackSurrendered) {
        BlackSurrendered = blackSurrendered;
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


    public static boolean getMusicOnOrOff() {
        return MusicOnOrOff;
    }

    public static void setMusicOnOrOff(boolean musicOnOrOff) {
        MusicOnOrOff = musicOnOrOff;
    }

}
