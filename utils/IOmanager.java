package utils;
public abstract class IOmanager {   

    public static int getPlayersNum() {
        int playersNum = KeyboardInput.readInt("How many players will there be?");
        while (playersNum < Constants.MIN_PLAYERS || playersNum > Constants.MAX_PLAYERS) {
            playersNum = KeyboardInput.readInt("Enter valid number of players");
        }
        return playersNum;
    }

    public static String enterPlayerName(int playerNum) {
        return KeyboardInput.readString("Enter the name of Player " + playerNum);
    }

    /*public void invalidCardNum() {
        System.out.println("Enter valid card number");
    }*/
}
