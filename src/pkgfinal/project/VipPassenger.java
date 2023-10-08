
package pkgfinal.project;

import java.util.Random;


public class VipPassenger extends Passenger {
        
        
        //default constructor
        public VipPassenger() {
            passengerID = passengerCounter++;
            type ="Vip Passenger";
        }
        //parametric constructor
        public VipPassenger(String t) {
            type = t;
        }
       //setter
        public void setType(String t){
            type = t;
        }
        //getter
        
        public String getType() {
            return type;
        }
        //copy constructor
        public VipPassenger(VipPassenger v) {
            type = v.type;
        }
        
       
    @Override
    public boolean requestElevator(SimulatorSettings settings){
        Random rand = new Random();
        this.startFloor = rand.nextInt()% settings.getNofloors();
        this.endFloor = rand.nextInt() % settings.getNofloors();
        while(this.startFloor == this.endFloor){
            this.endFloor = rand.nextInt() % settings.getNofloors();
        }
        return true;
    }
}

