package Simulation;

import Util.Pair;

import java.util.ArrayList;

public class ImmuneCell extends Cell{
    public ImmuneCell(int x, int y) {
        super(3,x,y,3);
    }
    public ImmuneCell(Pair pair) {
        super(3,pair.getX(),pair.getY(),4);
    }

    @Override
    public void interactNeighbours(ArrayList<Cell> neighbours) {
        replaceNeighbourCell(2,0,1, neighbours); //Replace Neighbour Cell with ID:2 with cell of ID:0 100% of the time
    }
}
