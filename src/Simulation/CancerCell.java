package Simulation;

import Util.Pair;

import java.util.ArrayList;

public class CancerCell extends Cell{
    public CancerCell(int x, int y) {
        super(1,x,y,3);
    }
    public CancerCell(Pair pair) {
        super(1,pair.getX(),pair.getY(),3);
    }

    @Override
    public void interactNeighbour(ArrayList<Cell> neighbours) {

    }
}
