package Util;

public class Pair {
    private int x;
    private int y;

    public Pair() {
        this(0,0);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
