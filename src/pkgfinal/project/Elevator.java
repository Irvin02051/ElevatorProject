
package pkgfinal.project;

import java.util.ArrayList;


public abstract class Elevator {
    private String ElevatorID;
    private int startFloor;
    private int endFloor;
    private String type;
    private int currentFloor;
    private int nextFloor;
    private int maxCapacity;
    
    private ArrayList<Passenger> PassengerElevator = new ArrayList<>();
    private ArrayList<Elevator> elevator = new ArrayList<>();

    public abstract void upRequest(ArrayList<ArrayList<Passenger>> Floors);
    public abstract void downRequest(ArrayList<ArrayList<Passenger>> Floors);
        
    




    
        public String getElevatorID() {
        return ElevatorID;
    }

    
    public void setElevatorID(String ElevatorID) {
        this.ElevatorID = ElevatorID;
    }

   
    public int getStartFloor() {
        return startFloor;
    }

   
    public void setStartFloor(int startFloor) {
        this.startFloor = startFloor;
    }

   
    public int getEndFloor() {
        return endFloor;
    }

    
    public void setEndFloor(int endFloor) {
        this.endFloor = endFloor;
    }

    
    public String getType() {
        type ="";
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }

 
    public int getCurrentFloor() {
        return currentFloor;
    }


    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

   
    public ArrayList<Passenger> getPassengerElevator() {
        return PassengerElevator;
    }

   
    public void setPassengerElevator(ArrayList<Passenger> PassengerElevator) {
        this.PassengerElevator = PassengerElevator;
    }

   
    public ArrayList<Elevator> getElevator() {
        return elevator;
    }

   
    public void setElevator(ArrayList<Elevator> elevator) {
        this.elevator = elevator;
    }

    
    public int getNextFloor() {
        return nextFloor;
    }

    
    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

   
    public int getMaxCapacity() {
        return maxCapacity;
    }

    
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
 
    
    
        
    
}

