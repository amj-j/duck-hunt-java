package utils;
public abstract class IOmanager {   

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static int printAndReadInt(String text) {
        return KeyboardInput.readInt(text);
    }


    public static String printAndReadString(String text) {
        return KeyboardInput.readString(text);
    }
}
