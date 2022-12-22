package pond;

import utils.Constants;

public class AimTiles {
    private boolean[] tiles = new boolean[Constants.POND_SIZE];;

    public AimTiles() {}

    public boolean isAimed(int index) {
        return tiles[index];
    }

    public void aimAt(int index) {
        tiles[index] = true;
    }

    public void removeAim(int index) {
        tiles[index] = false;
    }
}
