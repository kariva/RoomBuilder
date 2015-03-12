/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomlayout;

import java.util.ArrayList;

/**
 *
 * @author Kari Vass
 */
public class Wall {
    //Coordinates
    private double x1, x2, y1, y2;
    
    //Attached walls
    private ArrayList<Wall> joinedWalls;
    
    //Constructor
    public Wall(double newX1, double newY1, double newX2, double newY2){
        this.x1 = newX1;
        this.y1 = newY1;
        this.x2 = newX2;
        this.y2 = newY2;
        this.joinedWalls = new ArrayList<Wall>();
    }
    
    //Getters and setters for the variables of this class
    public double getX1(){ return this.x1; }
    public double getY1(){ return this.y1; }
    public double getX2(){ return this.x2; }
    public double getY2(){ return this.y2; }
    public ArrayList<Wall> getJoinedWalls(){ return this.joinedWalls; }

    public void setX1(double newX1) { this.x1 = newX1; }
    public void setY1(double newY1) { this.y1 = newY1; }
    public void setX2(double newX2) { this.x2 = newX2; }
    public void setY2(double newY2) { this.y2 = newY2; }
    
    //Add joining walls
    public void addJoiningWall(Wall w) {
        this.joinedWalls.add(w);
    }
}
