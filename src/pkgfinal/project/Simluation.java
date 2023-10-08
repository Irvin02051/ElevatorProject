
package pkgfinal.project;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Simluation {
     SimulatorSettings settings = new SimulatorSettings("settings.txt");
    public void InitSimulation() throws FileNotFoundException{
        ///// Read all parameters from the file and store in the class
        File file = new File("settings.txt");
        Scanner scanner = new Scanner(file);
        //FileReader freader = new FileReader(file); 
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith("floor="))
            {
                line= line.replace("floor=", "");
                // Convert the value to the wanted type 
                System.out.println(line);
            }
        }
        settings.setNofloors(55);
        Passenger pass1 = new StandardPassenger();
        pass1.requestElevator(settings);
            ArrayList<Passenger> passengers = new ArrayList<>();
            ArrayList<Elevator> elevator = new ArrayList<>();
    

        //100 passsengers and depending on what percentage it is it adds to the type of passenger it is
        
        Random rnd = new Random();
        double n = rnd.nextDouble();
        
        for(int i = 0; i < 100; i++){
            //Use the percentage from the file
            if (n<0.70) {
            passengers.add(new StandardPassenger());
            }
            else if (n<0.85) {
                passengers.add(new VipPassenger());
            }
            else if (n<0.95) {
                passengers.add(new FreightPassenger());
            }
            else {
                passengers.add(new GlassPassenger());
                
            
            }
        }
        
        System.out.print("Passengers: ");
        for (int j = 0; j < passengers.size(); j++) {
            System.out.print(passengers.get(j).toString()+", ");
            
        }
        
            //creates an arraylist of 4 types of elevators
            
       
                    elevator.add(new StandardElevator()); //0
                    elevator.add(new ExpressElevator()); //1
                    elevator.add(new FreightElevator()); //2
                    elevator.add(new GlassElevator()); //3
                    
            

        //create passengers inside the elevator
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                
                elevator.get(i).getPassengerElevator().add(passengers.get(j));
            
                
        }
        
}
        
        //depending on what type of passenger you are you go to the designated elevator type
        ArrayList<Passenger> Standardelevator = new ArrayList<>();
        ArrayList<Passenger> Expresselevator = new ArrayList<>();
        ArrayList<Passenger> Freightelevator = new ArrayList<>();
        ArrayList<Passenger> Glasselevator = new ArrayList<>();
        
        StandardElevator se = new StandardElevator();
        ExpressElevator ee = new ExpressElevator();
        FreightElevator fe = new FreightElevator();
        GlassElevator ge = new GlassElevator();
            
            for (int i = 0; i < 100; i++) {
                if(passengers.get(i).getType().equals(se.getType())) {
                    Standardelevator.add(passengers.get(i));
                }
                else if (passengers.get(i).getType().equals(ee.getType())) {
                    Expresselevator.add(passengers.get(i));
                }
                else if (passengers.get(i).getType().equals(fe.getType())) {
                    Freightelevator.add(passengers.get(i));
                }
                else if (passengers.get(i).getType().equals(ge.getType())) {
                    Glasselevator.add(passengers.get(i));
                }
            }
                System.out.print(" StandardElevator: " );
                for (int i = 0; i < Standardelevator.size(); i++) {
                    System.out.print(Standardelevator.get(i).toString() + ", ");
                }
                    System.out.println();
                    
                    System.out.print(" ExpressElevator: " );
                for (int i = 0; i < Expresselevator.size(); i++) {
                    System.out.print(Expresselevator.get(i).toString() + ", ");
                }
                System.out.println();
                
                System.out.print(" FreightElevator: " );
                for (int i = 0; i < Freightelevator.size(); i++) {
                    System.out.print(Freightelevator.get(i).toString() + ", ");
                }
                System.out.println();
                System.out.print(" GlassElevator: " );
                for (int i = 0; i < Glasselevator.size(); i++) {
                    System.out.print(Glasselevator.get(i).toString() + ", ");
                }
                System.out.println();
                
        }
            
            }
        
        

        
        //created an arraylist of floors 10 for reference
        //ArrayList<Floor> floor = new ArrayList<>();
       // for (int j = 0; j < 10; j++) {
         //   floor.add(new Floor(j));
//

        //create an arraylist of passenger in each floor
      //  Random rnd = new Random();
       // for (int j = 0; j < 10; j++) {
           // for (int k = 0; k < 100; k++) {
              //  floor.get(j).getPassengerFloor().add(passengers.get(rnd.nextInt()));
      //  }
            
        
    

        //create a code to check if the elevator is at the right floor(whatever floor the passenger is at has to match the elevator)
        
        //for loop elevator current //for loop passengerfloor start floor
        //for loop elevator type // for loop passenger type 
        //if the elevator current floor matches the passengerfloor start floor
        //if the passenger type matches the elevator type
        //if the passengerelevator < max capacity add more passengers from the floor to the passenger and remove from the floor
        //
        //then passenger to the elevator
       // for (int i = 0; i < 10; i++) { //for loop elevator current floor
          //  for (int j = 0; j < 10; j++) { //for loop passengerfloor start floor
               // for (int k = 0; k < 10; k++) { //for loop elevator type
             //       for (int l = 0; l < 10; l++) { //for loop passenger type
                      //  if(PassengerElevator.get)
                    
                    
                
                
            
       
        














                
                       
            

    

        