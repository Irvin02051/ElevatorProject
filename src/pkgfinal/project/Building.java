
package pkgfinal.project;

import java.util.ArrayList;


public class Building {
    private int floors;


    public int getFloors() {
        return floors;
    }


    public void setFloors(int floors) {
        this.floors = floors;
    }
    ArrayList<Floor> floor = new ArrayList<>();
    ArrayList<Elevator> elevator = new ArrayList<>();
    
}
