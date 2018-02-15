package Go;

public class Status {
    private static boolean SFXonOrOff;
    private static int SkippedTurn;


    public Status() {
        SFXonOrOff = true;
        SkippedTurn = 0;
    }

    public static int getSkippedTurn() {
        return SkippedTurn;
    }

    public static void setSkippedTurn(int skippedTurn) {
        SkippedTurn = skippedTurn;
    }

    public static boolean getSFXonOrOff() {
        return SFXonOrOff;
    }

    public static void setSFXonOrOff(boolean SFXonOrOff) {
        Status.SFXonOrOff = SFXonOrOff;
    }
}
