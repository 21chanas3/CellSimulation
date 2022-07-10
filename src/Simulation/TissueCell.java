package Simulation;

import Util.Pair;

import java.util.ArrayList;

public class TissueCell extends Cell{
    public TissueCell(int x, int y) {
        super(0, x, y, 1);
    }
    public TissueCell(Pair pair) {
        super(0,pair.getX(),pair.getY(),1);
    }

    @Override
    public void interactNeighbours(ArrayList<Cell> neighbours) {
        replaceNeighbourCell(0,1,0.7, neighbours); //Replace Neighbour Cell with ID:0 with cell of ID:1 70% of the time
    }
}
