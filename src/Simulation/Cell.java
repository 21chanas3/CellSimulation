package Simulation;

import Util.Mapper;
import Util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

public class Cell {
    private int strength;
    private int x,y;
    private int id;
    private HashSet<String> signalChemicalsEmitting;

    public Cell(int strength, int x, int y, int id) {
        setStrength(strength);
        setX(x);
        setY(y);
        setId(id);
    }


    public void interactNeighbours(ArrayList<Cell> neighbours) {

    }

    public ArrayList<Cell> scanNeighboursOfType(ArrayList<Cell> neighbours, int targetId) {
        ArrayList<Cell> targetCellsAround = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int index = Mapper.indexFromCoord(this.getX() + i, this.getY() + j);
                if(index != -1) {
                    Cell cellBeingChecked = neighbours.get(index);
                    if (cellBeingChecked.getId() == targetId) {
                        targetCellsAround.add(cellBeingChecked);
                    }
                }
            }
        }
        return targetCellsAround;
    }

    public boolean replaceNeighbourCell(int targetId, int newCellID, double chance, ArrayList<Cell> neighbours) {
        ArrayList<Cell> targetCellsAround = scanNeighboursOfType(neighbours, targetId);
        /*if(Math.random() <= 1 - chance) {
            return false;
        }*/
        if (targetCellsAround.size() > 0) {
            int rng = (int) Math.round(Math.random() * (targetCellsAround.size() - 1));
            Pair cellToReplaceCoord = targetCellsAround.get(rng).getCoord();
            neighbours.remove(Mapper.indexFromCoord(cellToReplaceCoord));
            switch (newCellID) {
                case 0 -> neighbours.add(Mapper.indexFromCoord(cellToReplaceCoord), new DeadCell(cellToReplaceCoord));
                case 1 -> neighbours.add(Mapper.indexFromCoord(cellToReplaceCoord), new TissueCell(cellToReplaceCoord));
                case 2 -> neighbours.add(Mapper.indexFromCoord(cellToReplaceCoord), new CancerCell(cellToReplaceCoord));
                case 3 -> neighbours.add(Mapper.indexFromCoord(cellToReplaceCoord), new ImmuneCell(cellToReplaceCoord));
                default -> {
                }
            }
        } else {
            return false;
        }
        return true;
    }

    //Setters & Getters
    public void setStrength(int strength) {
        this.strength = Math.max(strength, 0);
    }

    public void decrementStrength() {
        this.strength--;
    }

    public boolean isExhausted() {
        return this.strength <= 0;
    }

    public void setX(int x) {
        this.x = Math.max(x,0);
    }

    public void setY(int y) {
        this.y = Math.max(y,0);
    }

    public void setId(int id) {
        this.id = Math.max(id, 0);
    }

    public int getStrength() {
        return strength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Pair getCoord() {return new Pair(this.getX(), this.getY()); }

    public int getId() {
        return id;
    }
}

