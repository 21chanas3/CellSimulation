package Simulation;

import java.util.ArrayList;

import Util.Mapper;
import Util.Pair;

public class Logic {
    private int width; //number of cells in x dir
    private int height; //number of cells in y dir
    private ArrayList<Cell> cellList; //arraylist holding cells
    private Mapper mapper; //helpful calculator

    public Logic(int width, int height){
        this.width = width;
        this.height = height;
        this.mapper = new Mapper(width, height);
        cellList = new ArrayList<>();
        initialize();
    }

    /**
     * Puts cells on the board.
     */
    private void initialize(){
        double rngNum =0;
        for(int i =0; i < width*height; i++){
            rngNum = Math.random()*100;
            if (rngNum < 90.0){
                cellList.add(new TissueCell(mapper.coordFromIndex(i)));
            }
            else if (rngNum >= 90.0 && rngNum < 99.0){
                cellList.add(new ImmuneCell(mapper.coordFromIndex(i)));
            } else {
                cellList.add(new CancerCell(mapper.coordFromIndex(i)));
            }
        }
    }

    /**
     * Calls the interaction method on each cell in the list.
     */
    public void timeStep(){
        for(Cell c : cellList){
            c.interactNeighbours(cellList);
        }
    }

    public int setColor(Pair coords){
        int toRet = cellList.get(mapper.indexFromCoord(coords)).getId();
        return toRet;
    }
}