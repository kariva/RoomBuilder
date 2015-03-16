/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import java.util.ArrayList;
import javafx.scene.control.Button;

/**
 *
 * @author Kari Vass
 */
public class MainModel {
    //Subscribers
    private ArrayList<ModelListener> subscribers;
    //List of tools
    private ArrayList<Button> tools;
    //Walls
    private ArrayList<Wall> walls;
    //A variable for the wall being drawn
    private Wall beingDrawn;
    
    //Constructor
    public MainModel(){
        this.beingDrawn = new Wall(0, 0, 0, 0);
        this.tools = new ArrayList<Button>();
        this.walls = new ArrayList<Wall>();
        this.subscribers = new ArrayList<ModelListener>();
    }
    
    public void addWall(Wall e){
        Wall toAdd = new Wall(e.getX1(), e.getY1(), e.getX2(), e.getY2());
        walls.add(toAdd);
        this.notifySubscribers();
    }
    
    public Wall getLineBeingDrawn(){
        return this.beingDrawn;
    }
    
    public void startDrawnLine(double newX1, double newY1){
        this.beingDrawn.setX1(newX1);
        this.beingDrawn.setY1(newY1);
        this.beingDrawn.setX2(newX1);
        this.beingDrawn.setY2(newY1);
        this.notifySubscribers();
    }
    
    public void endDrawnLine(double newX2, double newY2){
        this.beingDrawn.setX2(newX2);
        this.beingDrawn.setY2(newY2);

        //Values for comparison of X,Y values
        double largerX = 0.0;
        double smallerX = 0.0;
        double largerY = 0.0;
        double smallerY = 0.0;
        
        int retVal = Double.compare(beingDrawn.getX1(), beingDrawn.getX2());
        if(retVal > 0) { //x1 is bigger than x2
            largerX = beingDrawn.getX1();
            smallerX = beingDrawn.getX2();
        }
        else{ //x2 is less than or equal to x1
            largerX = beingDrawn.getX2();
            smallerX = beingDrawn.getX1();
        }
        retVal = Double.compare(beingDrawn.getY1(), beingDrawn.getY2());
        if(retVal > 0) { //y1 is bigger than y2
            largerY = beingDrawn.getY1();
            smallerY = beingDrawn.getY2();
        }
        else{ //y2 is less than or equal to y1
            largerY = beingDrawn.getY2();
            smallerY = beingDrawn.getY1();
        }
        
        //Now check whether to draw horizontally or vertically
        if(largerX - smallerX > largerY - smallerY) { //Drawing horizontally
            this.addWall(new Wall(beingDrawn.getX1(), beingDrawn.getY1(), beingDrawn.getX2(), beingDrawn.getY1()));
        }
        else { //Drawing vertically
            this.addWall(new Wall(beingDrawn.getX1(), beingDrawn.getY1(), beingDrawn.getX1(), beingDrawn.getY2()));
        }
        
        //Reset the temp line
        this.beingDrawn.setX1(0);
        this.beingDrawn.setX2(0);
        this.beingDrawn.setY2(0);
        this.beingDrawn.setY1(0);
        this.notifySubscribers();
    }
    
    public void updateDrawnLine(double newX2, double newY2){
        this.beingDrawn.setX2(newX2);
        this.beingDrawn.setY2(newY2);
        this.notifySubscribers();
    }
    
    public void abandonDrawnLine(){
        this.beingDrawn.setX1(0);
        this.beingDrawn.setX2(0);
        this.beingDrawn.setY2(0);
        this.beingDrawn.setY1(0);
        this.notifySubscribers();
    }
    
    public void addModelListener(ModelListener newSub){
        subscribers.add(newSub);
        this.notifySubscribers();
    }
        
    public void notifySubscribers(){
        for(ModelListener subs : subscribers){
            subs.modelChanged();
        }
    }
    
    public void addTool(Button b) {
        this.tools.add(b);
    }
    
    public ArrayList<Button> getToolList(){
        return this.tools;
    }
        
    public ArrayList<Wall> getWallList(){
        return this.walls;
    }
    
    //For complete clearing of the canvas space
    public void clearAll(){
        this.walls.clear();
    }
}
