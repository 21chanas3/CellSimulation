package Rendering;

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pixel extends Component {
    private final int x;
    private final int y;
    int colorID;
    Color[] colors = new Color[10];
    private final int w;
    private final int h;

    public Pixel(int x, int y, int colorID, int w, int h) {
        this.x = x;
        this.y = y;
        this.colorID = colorID;
        this.w = w;
        this.h = h;
        colors[0] = Color.BLACK;
        colors[1] = Color.RED;
        colors[2] = Color.BLUE;
        colors[3] = Color.GREEN;
        colors[4] = Color.WHITE;
        colors[5] = Color.CYAN;
        colors[6] = Color.MAGENTA;
        colors[7] = Color.ORANGE;
        colors[8] = Color.YELLOW;
        colors[9] = Color.LIGHT_GRAY;
    }

    public void setColor(int colorID){
        if(colorID >= 0 && colorID <= 4){
            this.colorID = colorID;
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(colors[colorID]);
        g.fillRect(x,y,w,h);
    }
}
