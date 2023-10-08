
package pkgfinal.project;

import java.util.ArrayList;
import java.util.Random;


public abstract class Passenger {

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

   
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
    public static int passengerCounter = 0;
    protected int passengerID;
    protected int startFloor;
    protected int endFloor;
    protected String type;
    private ArrayList<Passenger> passengers = new ArrayList<>();
//default constructor
    public Passenger() {
        //this generates a start floor and end floor for passengers
        Random rnd = new Random();
        this.startFloor = rnd.nextInt(10);
        this.endFloor = rnd.nextInt(10);
        while(this.startFloor == this.endFloor){
            this.endFloor = rnd.nextInt(10);
        } 
         
    }
    //parametric constructor
        public Passenger(int passengerID,int startFloor, int endFloor) {
            this.passengerID = passengerID;
            this.startFloor = startFloor;
            this.endFloor = endFloor;
            
        }
       //setter
        public void setPassengerID(int passengerID){
            this.passengerID = passengerID;
        }
        public void setStartFloor(int startFloor){
            this.startFloor = startFloor;
        }
        public void setEndFloor(int endFloor){
            this.endFloor = endFloor;
        }
        public void setType(String type) {
            this.type = type;
        }
        //getter
        public int getPassengerID() {
            return this.passengerID;
        }
        public int getStartFloor() {
            return this.startFloor;
        }
        public int getEndFloor() {
            return this.endFloor;
        }
        public String getType() {
        type ="";
        return type;
        }
        //copy constructor
        public Passenger(Passenger p) {
            this.passengerID = p.passengerID;
            this.startFloor = p.startFloor;
            this.endFloor = p.endFloor;
        }

    @Override
    public String toString() {
        return "ID: " + passengerID + "|Type: " + type + "|" + startFloor + "=>" + endFloor;
        
        
    }
        
    public void Passenger(){
        this.passengerID = +passengerCounter;
        passengerCounter++;
    }
    public abstract boolean requestElevator(SimulatorSettings settings);

    
    
    }


