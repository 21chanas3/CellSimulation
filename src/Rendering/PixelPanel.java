package Rendering;

import Util.Mapper;
import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PixelPanel extends JPanel {

    private ArrayList<Pixel> pixels;
    private int width;
    private int height;
    private Mapper mapper;


    public PixelPanel(int w, int h, int pixelWidth, int pixelHeight){
        this.width = w;
        this.height = h;
        mapper = new Mapper(width, height);
        pixels = new ArrayList();
        Pair currCoords;
        for(int i = 0; i < width*height; i++){
            currCoords = mapper.coordFromIndex(i);
            pixels.add(new Pixel(currCoords.getX()*pixelWidth, currCoords.getY()*pixelHeight,0,pixelWidth, pixelHeight));
        }
    }

    public void paintComponent(Graphics g){
        for(Pixel p : pixels){
            p.draw(g);
        }
    }

    public Pixel getPixel(int x, int y){
        return pixels.get(x + (y * width));
    }

    public int canvasSize(){
        return(width*height);
    }
}