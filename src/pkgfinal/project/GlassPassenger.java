
package pkgfinal.project;

import java.util.Random;


public class GlassPassenger extends Passenger{
        
    
    //default constructor
    public GlassPassenger() {
        passengerID = passengerCounter++;
         type ="Glass Passenger";
    }
    //parametric constructor
        public GlassPassenger(String t) {
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
        public GlassPassenger(GlassPassenger g) {
            type = g.type;
        }
    @Override
    public boolean requestElevator(SimulatorSettings settings){
        //Generating a start floor and end floor and if start floor and end floor is the same generate a new end floor
        Random rand = new Random();
        this.startFloor = rand.nextInt()% settings.getNofloors();
        this.endFloor = rand.nextInt() % settings.getNofloors();
        while(this.startFloor == this.endFloor){
            this.endFloor = rand.nextInt() % settings.getNofloors();
        }
        return true;
    }
}

