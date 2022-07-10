package Util;

public class Mapper {
    private static int width;
    private static int length;

    public Mapper(int width, int length) {
        this.width = Math.max(width,1);
        this.length = Math.max(length,1);
    }

    public static int indexFromCoord(int x, int y) {
        if(x >= width || y>= length) {
            return -1;
        } else {
            return width * y + x;
        }
    }

    public static int indexFromCoord(Pair coord) {
        return indexFromCoord(coord.getX(), coord.getY());
    }

    public static Pair coordFromIndex(int i) {
        return new Pair(i % width, (i - (i % width))/width);
    }
}
