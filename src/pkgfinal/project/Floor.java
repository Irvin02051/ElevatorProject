
package pkgfinal.project;

import java.util.ArrayList;

public class Floor extends Building {

    static boolean size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int FloorID;
    
    // Multi dimentional arraylist index 0 is an arraylist
    private ArrayList<ArrayList<Passenger>> PassengerFloor = new ArrayList<>();
     
    
    //default constructor
    public Floor() {
        //each floor has a arraylist of passenger starting from index 0
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        PassengerFloor.add(new ArrayList<Passenger>());
        
    }
//parametric constructor
    public Floor(int FloorID){
        this.FloorID =FloorID;
    }
         
    public int getFloorID() {
        return FloorID;
    }

    
    public void setFloorID(int FloorID) {
        this.FloorID = FloorID;
    }

    
    public ArrayList<ArrayList<Passenger>> getPassengerFloor() {
        return PassengerFloor;
    }

    
    public void setPassengerFloor(ArrayList<ArrayList<Passenger>> PassengerFloor) {
        this.PassengerFloor = PassengerFloor;
    }

    
    
    

    
    public void setFloor(ArrayList<Floor> floor) {
        this.floor = floor;
    }
    
    
    
}
