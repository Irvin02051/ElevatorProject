
package pkgfinal.project;

import java.util.ArrayList;
import java.util.Random;


public class FinalProject {
private static ArrayList<Passenger> passengers = new ArrayList<>();
  
     public static void main(String[] args) {
        Floor f = new Floor();
      Random rnd = new Random();
        
        //Use the percentage from the file
        for(int i = 0; i < 10; i++){
            double n = rnd.nextDouble(); //from 0 to 1.0 default of nextDouble()
            if (n<0.70) { //70%
            passengers.add(new StandardPassenger());
            }
            else if (n<0.85) { //15%
                passengers.add(new VipPassenger());
            }
            else if (n<0.95) { //10%
                passengers.add(new FreightPassenger());
            }
            else {//5%
                passengers.add(new GlassPassenger());
                
            
            }
        }
        
        System.out.println("Passengers: ");
        for (int j = 0; j < passengers.size(); j++) {
            System.out.println(passengers.get(j).toString()+", "); // we are printing the passengers arraylist using toString to display object to output window
            
        }
        System.out.println("======================================================");
        //switch case we are getting the objects passenger starting floor then we are making a comparison with these cases. If the passengers starting floor
        //is 0 then we will proceed in that case. Each case represents the index of the multidimentional arraylist
        
        for (int i = 0; i < passengers.size(); i++) { //taking the passengers arraylist and inserting them to their floors (multidimentional arraylist) using a switch case
            switch(passengers.get(i).getStartFloor()) { //startfloor 
                case 0:
                    f.getPassengerFloor().get(0).add(passengers.get(i));
                    break;
                case 1:
                    f.getPassengerFloor().get(1).add(passengers.get(i));
                    break;
                case 2:
                    f.getPassengerFloor().get(2).add(passengers.get(i));
                    break;
                case 3: 
                    f.getPassengerFloor().get(3).add(passengers.get(i));
                    break;
                case 4: 
                    f.getPassengerFloor().get(4).add(passengers.get(i));
                    break;
                case 5: 
                    f.getPassengerFloor().get(5).add(passengers.get(i));
                    break;

                case 6:
                    f.getPassengerFloor().get(6).add(passengers.get(i));
                    break;
                    
                case 7:
                    f.getPassengerFloor().get(7).add(passengers.get(i));
                    break;
                case 8:
                    f.getPassengerFloor().get(8).add(passengers.get(i));
                    break;
                case 9:
                    f.getPassengerFloor().get(9).add(passengers.get(i));
                    break;
                default:
                    System.out.println("Starting floor does not exist");
                    break;
            }
            
            }
        //one arraylist thats inside each index has an arraylist
        //first for loop iterates through the arraylist 0-9 index of each floor
        //second for loop iterates that arraylist in that index (elements inside the arraylist)
        //checking if passengers the passengers are added to the right arraylist and printing it out in the output window
        for (int i = 0; i < f.getPassengerFloor().size(); i++) {
            System.out.print("Floor" + i + ": ");
            for (int j = 0; j < f.getPassengerFloor().get(i).size(); j++) {
                System.out.print(f.getPassengerFloor().get(i).get(j).toString() + ", ");
            }
            System.out.println();
            
        }
        System.out.println("======================================================");
        StandardElevator se = new StandardElevator();
        ExpressElevator ee = new ExpressElevator();
        FreightElevator fe = new FreightElevator();
        GlassElevator ge = new GlassElevator();
        
        
        //make elevator start at ground floor
        //use boolean to call the method once because if you keep calling it it will mess up the compiling and glitch out
        // using if else to check if there is a request from the ground floor
        // to check the request we want to see the passengers if they have the same type as the elevator
        //also want to check if the starting floor that the passengers are at is less than the destination floor
        //because the elevator logic since elevator is starting at ground floor might as well allow only people who wants to go up in the elevator
        //for the boolean we just want to call the uprequest once if there is a request because it would generate alot of uprequest calling it multiply time
        //because once you call it once you don't have to call it again
        
        // in other words  I created 4 boolean variables for each of the up request
        boolean callStandardElevator = false;
        boolean callExpressElevator = false;
        boolean callFreightElevator = false;
        boolean callGlassElevator = false;
        //two for loop iterating through the multidimentional arraylist
        for (int i = 0; i < f.getPassengerFloor().size(); i++) {
            for (int j = 0; j < f.getPassengerFloor().get(i).size(); j++) {
                Passenger p = f.getPassengerFloor().get(i).get(j); // passenger p is object that is inside the multidimentional arraylist (passengers in floors)
                //created passenger p variable because I didn't want to write out f.getPassengerFloor().get(i).get(j) in the if statements simplfy the code
                if (p.getType().equals("Standard Passenger") && p.getStartFloor() < p.getEndFloor() && callStandardElevator == false) { //checking if the passenger starting floor is equal to the same type of the elevator and checking if the passengers destination floor is larger than the start floor because we are handling the uprequest right now
                   callStandardElevator = true;
                   se.upRequest(f.getPassengerFloor());
                   
                }    
           
                else if ((p.getType().equals("Vip Passenger") && p.getStartFloor() < p.getEndFloor()) && callExpressElevator == false )  { //default set to false if its true then we can call the uprequest
                    callExpressElevator = true;
                    ee.upRequest(f.getPassengerFloor());
                }
                else if ((p.getType().equals("Freight Passenger") && p.getStartFloor() < p.getEndFloor()) && callFreightElevator== false )  {
                    callFreightElevator = true;
                    fe.upRequest(f.getPassengerFloor());
            
               }
                
                else if ((p.getType().equals("Glass Passenger") && p.getStartFloor() < p.getEndFloor()) && callGlassElevator == false )    {
                    callGlassElevator = true;
                    ge.upRequest(f.getPassengerFloor());
               }
            
            
            }
        }
         System.out.println("ALL REQUEST ARE DONE");
    }

}
    




    

