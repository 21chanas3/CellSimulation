package Rendering;

import Simulation.Logic;
import Util.Mapper;
import Util.Pair;

import javax.swing.*;

public class Program {

    long timeSinceLastUpdate = 0;
    private final long FRAME_TIME = (long)((1.0/10.0)*1000000000.0);

    private int width;
    private int height;

    public static void main(String[] args){
        Program program = new Program();
    }

    public Program(){
        onUserStart();
    }

    private void onUserStart(){
        width = 100;
        height = 100;
        Logic programLogic = new Logic(width, height);
        int pixelWidth = 10;
        int pixelHeight = 10;
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((width + 2) * pixelWidth, (height + 4) * pixelHeight);
        PixelPanel pixels = new PixelPanel(width, height, pixelWidth, pixelHeight);
        frame.getContentPane().add(pixels);
        frame.setVisible(true);
        pixels.repaint();
        long currTime = 0;
        long nextTime = 0;
        while(true){
            currTime = System.nanoTime();
            onUserUpdate(pixels, currTime - nextTime, programLogic);
            pixels.repaint();
            nextTime = currTime;
        }
    }

    private void onUserUpdate(PixelPanel pixels, long timeElapsed, Logic programLogic){
        if(timeSinceLastUpdate < FRAME_TIME){
            timeSinceLastUpdate += timeElapsed;
        } else {
            timeSinceLastUpdate = 0;
            Pair coords;
            programLogic.timeStep();
            for(int i = 0; i < pixels.canvasSize(); i++){
                coords = Mapper.coordFromIndex(i);
                pixels.getPixel(coords.getX(), coords.getY()).setColor(programLogic.setColor(coords));
            }
        }
    }
}