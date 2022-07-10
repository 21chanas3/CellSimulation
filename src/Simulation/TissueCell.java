package Simulation;

import Util.Mapper;
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
        ArrayList<Cell> deadCellsAround = new ArrayList<Cell>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Cell cellBeingChecked = neighbours.get(Mapper.indexFromCoord(this.getX() + i, this.getY() + j));
                if (cellBeingChecked instanceof DeadCell) {
                    deadCellsAround.add(cellBeingChecked);
                }
            }
        }

        if (deadCellsAround.size() > 0) {
            int rng = (int) Math.round(Math.random() * deadCellsAround.size());
            Cell cellToReplace = deadCellsAround.get(rng);
            neighbours.remove(rng);
            neighbours.add(rng, new TissueCell(cellToReplace.getCoord()));
        } else {
            return;
        }

    }
}
