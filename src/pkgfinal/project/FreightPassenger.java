
package pkgfinal.project;

import java.util.Random;


public class FreightPassenger extends Passenger {
            
        
        //default constructor
        public FreightPassenger() {
            passengerID = passengerCounter++;
            type ="Freight Passenger";
        }
        //parametric constructor
        public FreightPassenger(String t) {
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
        public FreightPassenger(FreightPassenger f) {
            type = f.type;
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

    

