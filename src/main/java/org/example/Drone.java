package org.example;

public class Drone {

    private String name;
    private int positionX;
    private int positionY;
    private String status;
    private Direction facing;

    public Drone(String name) {
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
        this.status = "Ready";
        this.facing = Direction.NORTH;
    }

    public String getName() {
        return this.name;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getFacing() {
        return this.facing;
    }

/*
    public void setName(String name) {
        this.name = name;
    }
*/

    /*
 Should outside code be allowed to access this directly? No
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
*/

/*
    public void setFacing(Direction facing) {
        this.facing = facing;
    }
*/

    public void moveForward(int steps) {
        switch(facing) {
            case NORTH:
                this.positionY += steps;
                break;
            case SOUTH:
                this.positionY -= steps;
                break;
            case EAST:
                this.positionX += steps;
                break;
            case WEST:
                this.positionX -= steps;
                break;
            default:
                this.status = "I cannot move.";
                return;
        }
        this.status = "Moved by " + steps + " steps.";
    }

    public void turnLeft() {
        switch(facing) {
            case NORTH:
                this.facing = Direction.WEST;
                break;
            case WEST:
                this.facing = Direction.SOUTH;
                break;
            case SOUTH:
                this.facing = Direction.EAST;
                break;
            case EAST:
                this.facing = Direction.NORTH;
                break;
            default:
                this.status = "I cannot turn left.";
                return;
        }
        this.status = "Turned left.";
    }

    public void turnRight() {
        switch(facing) {
            case NORTH:
                this.facing = Direction.EAST;
                break;
            case EAST:
                this.facing = Direction.SOUTH;
                break;
            case SOUTH:
                this.facing = Direction.WEST;
                break;
            case WEST:
                this.facing = Direction.NORTH;
                break;
            default:
                this.status = "I cannot turn right.";
                return;
        }
        this.status = "Turned right.";
    }

    public void updateStatus() {
        this.status = "[" + this.positionX + "," + this.positionY + "]";
    }
}
