
package pkgfinal.project;

import java.util.Random;


public class StandardPassenger extends Passenger {
    
    
    //default constructor
    public StandardPassenger() {
        passengerID = passengerCounter++;
         type ="Standard Passenger";
         
    }
    //parametric constructor
        public StandardPassenger(int t) {
            passengerID = t;
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
        public StandardPassenger(StandardPassenger s) {
            type = s.type;
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


