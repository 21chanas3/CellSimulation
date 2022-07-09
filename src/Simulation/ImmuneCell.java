package Simulation;

import Util.Pair;

import java.util.ArrayList;

public class ImmuneCell extends Cell{
    public ImmuneCell(int x, int y) {
        super(3,x,y,4);
    }
    public ImmuneCell(Pair pair) {
        super(3,pair.getX(),pair.getY(),4);
    }

    @Override
    public void interactNeighbour(ArrayList<Cell> neighbours) {

    }
}
