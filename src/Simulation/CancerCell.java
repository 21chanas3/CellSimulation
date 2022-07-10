package Simulation;

import Util.Mapper;
import Util.Pair;

import java.util.ArrayList;

public class CancerCell extends Cell{
    public CancerCell(int x, int y) {
        super(1,x,y,2);
    }
    public CancerCell(Pair pair) {
        super(1,pair.getX(),pair.getY(),3);
    }

    @Override
    public void interactNeighbours(ArrayList<Cell> neighbours) {
        if((replaceNeighbourCell(0,2,1, neighbours))) {return;} //If replacement of a dead cell is successful, end action;
        int tissueCount = 0;
        int immuneCount = 0;
        for(Cell c : neighbours) {
            if(c instanceof TissueCell) { tissueCount++;}
            else if (c instanceof ImmuneCell) { immuneCount++;}
        }
        if(tissueCount > immuneCount) {
            if(replaceNeighbourCell(1,0,1,neighbours)) {return;} //If replacement of a tissue cell is successful, end action;
        }

        //Immune Cell Combat!
        ArrayList<Cell> immuneCellNeighbours = scanNeighboursOfType(neighbours,4);
        if(immuneCellNeighbours.size() > 0) {
            int rng = (int) Math.round(Math.random() * (immuneCellNeighbours.size() - 1));
            Cell defendingCell = immuneCellNeighbours.get(rng);
            if(defendingCell.isExhausted()) {
                neighbours.remove(Mapper.indexFromCoord(defendingCell.getCoord()));
                neighbours.add(Mapper.indexFromCoord(defendingCell.getCoord()), new DeadCell(defendingCell.getCoord()));
            } else {
                defendingCell.decrementStrength();
            }
        }
    }
}
