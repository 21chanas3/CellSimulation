import java.util.ArrayList;
import java.util.HashMap;
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

    //Setters & Getters
    public void setStrength(int strength) {
        this.strength = Math.max(strength, 0);
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

    public int getId() {
        return id;
    }
}

