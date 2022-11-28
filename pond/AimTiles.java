package pond;

public class AimTiles {
    private boolean[] tiles;

    public AimTiles() {
        tiles = new boolean[6];
    }

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
