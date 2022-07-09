package Simulation;

import Util.Pair;

public class DeadCell extends Cell{
    public DeadCell(int x, int y) {
        super(0, x, y,0);
    }
    public DeadCell(Pair pair) {
        super(0,pair.getX(),pair.getY(),0);
    }
}
