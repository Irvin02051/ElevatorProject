
package pkgfinal.project;

import java.util.ArrayList;


public class StandardElevator extends Elevator {
    private String type;
    private boolean callRequest1 = false; 
    private ArrayList<Passenger> Standardelevator = new ArrayList<>();
    
    
    
    
    
    
    //default constructor
    public StandardElevator() {
         this.type ="Standard Passenger";
         setMaxCapacity(1000000000);
         setCurrentFloor(0);
         setNextFloor(-1);
    }
    //parametric constructor
        public StandardElevator(String type) {
            this.type = type;
            
        }
       //setter
        public void setType(String type){
            this.type = type;
        }
        //getter
        public String getType() {
            return this.type;
        }
        //copy constructor
        public StandardElevator(StandardElevator s) {
            this.type = s.type;
    
}

    
    public ArrayList<Passenger> getStandardelevator() {
        return Standardelevator;
    }

    
    public void setStandardelevator(ArrayList<Passenger> Standardelevator) {
        this.Standardelevator = Standardelevator;
    }

    @Override
    //created a method  called upRequest
    //has parameters of the multidimentional arraylist because we are calling it in the main so the parameters have to match
    //iterate through the multidimentional arraylist
    //elevator current floor starts at ground floor that is why we are iterating from 0 to Floor.size()
    //We are checking if the passenger is allowed to use that elevator because their types have to match
    //we are also making a comparison if the passengers starting floor is less than the passengers destination floor because we are doing up request
    //setNextFloor will collect the nearest floor request: example if floor 3 and floor 4 calls uprequest it would go to floor 3 first
    //callRequest is true we will break out the inner for loop since we got the request
    //we have another if statement to break out of the outer for loop since we got the request
    //no need to keep iterating through the for loops if we have a request which is why we have the if statement in the outer for loop
    public void upRequest(ArrayList<ArrayList<Passenger>> Floors) { //parameters have to be the same 
        System.out.println("StandardElevator up request");
        System.out.println("Current floor Standard Elevator: " + getCurrentFloor());
        Passenger p;
        callRequest1 = false;
        if(getCurrentFloor() > getNextFloor()) {
            //getting next elevator request
            for (int i = 0; i < Floors.size(); i++) {
            for (int j = 0; j < Floors.get(i).size(); j++) {
                 p = Floors.get(i).get(j);
                if(p.getType().equals(type) &&p.getStartFloor()<p.getEndFloor()) {
                    setNextFloor(i); //next floor the elevator is going to
                    callRequest1 = true; //call request break out of the inner
                    break;
                }
            }
            if(callRequest1) {  //breaking out of the outer for loop
                break;
            }
        }
        }
   if(callRequest1 == false) {
       downRequest(Floors);
   }
        System.out.println("Standard Elevator next request floor: " + getNextFloor());
        //simulating the elevator going through each floor from its current floor to its requested floor
        for (int i = getCurrentFloor(); i <= getNextFloor(); i++) { //simulating the elevators moving through the floors
            System.out.println("Standard Elevator currently at floor number: " + i);
        }
        //updating the elevators current floor once it reaches the floor that is calling for its request (nextfloor is the floor that the passengers are request from)
        setCurrentFloor(getNextFloor());
        
        System.out.print("Before passengers are removed from floor " + getCurrentFloor() + ": "); //checks passengers before removal from the floor
            for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) { //one for loop and it is printing that floor
                System.out.print(Floors.get(getCurrentFloor()).get(i).toString()); //checking on the output window to see if the passenger is entering or exiting the elevator
        }
            System.out.println();

            //iterating through the elvator arraylist checking if the passengers in the elvator arraylist 
            //is equal to the passengers destination floor if it is equal to the elevators current floor add them to the floor 
            // removing passengers from elevator and moving them to destination floor
            for (int i = 0; i < Standardelevator.size(); i++) { //if startFloor and endFloor equals to -1 and passenger type equals tp "Arrived at destination" it means Passenger reach destination and added back to multidimensional arraylist 
            if(Standardelevator.get(i).getEndFloor() == getCurrentFloor()) {
                Standardelevator.get(i).setType("Arrived at destination");
                Standardelevator.get(i).setStartFloor(-1);
                Standardelevator.get(i).setEndFloor(-1);
                Floors.get(getCurrentFloor()).add(Standardelevator.get(i)); //getting passenger from elevator to the floor
                System.out.println("Passenger: " + Standardelevator.get(i).toString() + " has exited the Standard Elevator");
                Standardelevator.remove(Standardelevator.get(i));
            }
        }
        //only want to iterate through the floor the passenger requested because someone from that floor is requesting a up request (this is where we do remove and add)
        //adding passengers to the elevator (which depends on the current floor of the elevator)
        for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) {
            p = Floors.get(getCurrentFloor()).get(i);
            //checks if the types are the same as the elevator and if the startfloor is less than the end floor because we are doing up request
            //and checks max capacity of elevator type
                if(p.getType().equals(type)&& p.getStartFloor() < p.getEndFloor() && Standardelevator.size() < getMaxCapacity()) { 
                    //adds passenger to elevator type
                    Standardelevator.add(p);
                    System.out.println("Passenger: " + p.toString() + " has entered the Standard Elevator");
        }
        }
        
        // this is removing the elements of passengers in the floors using the removeall method 
        // removes all the elements that are similar in standardelevator to floor and remove it from floors
        //removeall method is in the collection class 
            Floors.get(getCurrentFloor()).removeAll(Standardelevator);
            System.out.print("Inside Standard Elevator: ");
            for (int i = 0; i < Standardelevator.size(); i++) {
                System.out.print(Standardelevator.get(i).toString() + ", ");
        }
            System.out.println();
            System.out.print("After passengers are removed from floor " + getCurrentFloor() + ": "); //prints after the passengers are removed from the floor
            for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) {
                System.out.print(Floors.get(getCurrentFloor()).get(i).toString()+ ", ");
        }
            System.out.println();
            
            callRequest1 = false; //sets to false because the previous callrequest was still equal to true resetting elevator from 0 to the first request floor
             for (int i = getCurrentFloor(); i < Floors.size(); i++) { //next uprequest after the first uprequest
            for (int j = 0; j < Floors.get(i).size(); j++) {
                 p = Floors.get(i).get(j);
                if(p.getType().equals(type) &&p.getStartFloor()<p.getEndFloor()) {
                    setNextFloor(i); //next floor the elevator is going to
                   
                    callRequest1 = true;
                    
                    break;
                }
            }
            if(callRequest1) {  //breaking out of the outer for loop
                break;
            }
        }
             //checking inside the elevator if there is a floor request and if passengers want to leave before the nextfloor leaves before
             if(callRequest1) {//checking if its true
                 if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the closes end floor request if theres passengers in the elevator hat need to exit
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() < min) {
                             min = Standardelevator.get(i).getEndFloor();
                         }    
                 }
                     if(min<getNextFloor()){//checking if the denfloor of the passenger inside the elevator is less than the floor request
                         setNextFloor(min);
                     }
                     
                 }
                 System.out.println("======================================================");
                    upRequest(Floors); // if callrequest is true uprequest is called again (recursion- making method into smaller steps)
                 
             }else {//if there are no more requesting from starting floor we will fullfil the departure request if theres still passengers in  the elevator
                 //checks inside elevator if there sitll needs passengers to depart to their destination floor
                 if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the nearest departure request inside the elevator
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() < min) {
                             min = Standardelevator.get(i).getEndFloor();
                         }    
                    }
                    setNextFloor(min);//min should be greater than elevators current floor
                 
                     System.out.println("======================================================");
                     upRequest(Floors); // if callrequest is true uprequest is called again (recursion- making method into smaller steps)
                    }
                 else{
                     callRequest1 = false;
                     downRequest(Floors);//calls downRequest method

                 }
                 
             }
                 
             
        }
    

    @Override
    public void downRequest(ArrayList<ArrayList<Passenger>> Floors) {
        System.out.println("STANDARD ELEVATOR DOWN REQUEST METHOD");
        System.out.println("Current floor Standard Elevator: " + getCurrentFloor());
        
        if(callRequest1 == false) {
            
        
        for (int i =getCurrentFloor() ; i < 10; i++) { //for loop checking from the current floor to the highest floor
            for (int j = 0; j < Floors.get(i).size(); j++) { //for loop checking the passengers inside the floors (multidimentional arraylist)
                
                Passenger pa = Floors.get(i).get(j);
                if(pa.getType().equals(type) &&pa.getStartFloor()>pa.getEndFloor()) {
                setNextFloor(pa.getStartFloor()); // setting the next floor to the start floor of the passenger
            }
        }
    }
        callRequest1 =true;
}           else { 
            callRequest1 = false;
            for (int i = getCurrentFloor(); i >= 0; i--) {
            for (int j = 0; j < Floors.get(i).size(); j++) {
                Passenger pa = Floors.get(i).get(j);
                if(pa.getType().equals(type) &&pa.getStartFloor()>pa.getEndFloor()) {
                setNextFloor(pa.getStartFloor());
                callRequest1 = true; //call request break out of the inner
                    break;
            }
            }
            if(callRequest1) {  //breaking out of the outer for loop
                break;
        }
            
    }
            if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the nearest departure request inside the elevator
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() > min && Standardelevator.get(i).getEndFloor() > getNextFloor()) {
                             min = Standardelevator.get(i).getEndFloor();
                             setNextFloor(min);
            }
            
        }
    }
     if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the nearest departure request inside the elevator
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() > min) {
                             min = Standardelevator.get(i).getEndFloor();
                             setNextFloor(min);   
            }
        } 
    }
}
        System.out.println("First request for passengers going down " +getNextFloor());
        for (int i = getCurrentFloor(); i <= getNextFloor(); i++) { //simulating the elevators moving through the floors
            System.out.println("Standard Elevator currently at floor number: " + i);
       }
        setCurrentFloor(getNextFloor());
        
        System.out.print("Before passengers are removed from floor " + getCurrentFloor() + ": "); //checks passengers before removal from the floor
            for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) { //one for loop and it is printing that floor
                System.out.print(Floors.get(getCurrentFloor()).get(i).toString()); //checking on the output window to see if the passenger is entering or exiting the elevator
        }
            for (int i = 0; i < Standardelevator.size(); i++) { //if startFloor and endFloor equals to -1 and passenger type equals tp "Arrived at destination" it means Passenger reach destination and added back to multidimensional arraylist 
            if(Standardelevator.get(i).getEndFloor() == getCurrentFloor()) {
                Standardelevator.get(i).setType("Arrived at destination");
                Standardelevator.get(i).setStartFloor(-1);
                Standardelevator.get(i).setEndFloor(-1);
                Floors.get(getCurrentFloor()).add(Standardelevator.get(i)); //getting passenger from elevator to the floor
                System.out.println("Passenger: " + Standardelevator.get(i).toString() + " has exited the Standard Elevator");
                Standardelevator.remove(Standardelevator.get(i));
            }
        }
            System.out.println();
        for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) {
           Passenger pa = Floors.get(getCurrentFloor()).get(i);
            //checks if the types are the same as the elevator and if the startfloor is less than the end floor because we are doing up request
            //and checks max capacity of elevator type
                if(pa.getType().equals(type)&& pa.getStartFloor() > pa.getEndFloor() && Standardelevator.size() < getMaxCapacity()) { 
                    //adds passenger to elevator type
                    Standardelevator.add(pa);
                    System.out.println("Passenger: " + pa.toString() + " has entered the Standard Elevator");
            }
        }
        // this is removing the elements of passengers in the floors using the removeall method 
        // removes all the elements that are similar in standardelevator to floor and remove it from floors
        //removeall method is in the collection class 
            Floors.get(getCurrentFloor()).removeAll(Standardelevator);
            System.out.print("Inside Standard Elevator: ");
            for (int i = 0; i < Standardelevator.size(); i++) {
                System.out.print(Standardelevator.get(i).toString() + ", ");
        }
            System.out.println();
            System.out.print("After passengers are removed from floor " + getCurrentFloor() + ": "); //prints after the passengers are removed from the floor
            for (int i = 0; i < Floors.get(getCurrentFloor()).size(); i++) {
                System.out.print(Floors.get(getCurrentFloor()).get(i).toString()+ ", ");
        }
            System.out.println();
            callRequest1 = false; //sets to false because the previous callrequest was still equal to true resetting elevator from 0 to the first request floor
             for (int i = getCurrentFloor(); i >= 0; i--) { //next uprequest after the first uprequest
            for (int j = 0; j < Floors.get(i).size(); j++) {
                Passenger pa = Floors.get(i).get(j);
                if(pa.getType().equals(type) &&pa.getStartFloor() > pa.getEndFloor()) {
                    setNextFloor(i); //next floor the elevator is going to
                   
                    callRequest1 = true;
                    
                    break;
                }
            }
            if(callRequest1) {  //breaking out of the outer for loop
                break;
            }
        }
             //checking inside the elevator if there is a floor request and if passengers want to leave before the nextfloor leaves before
             if(callRequest1) {//checking if its true
                 if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the closes end floor request if theres passengers in the elevator hat need to exit
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() > min) {
                             min = Standardelevator.get(i).getEndFloor();
                         }    
                 }
                     if(min > getNextFloor()){//checking if the denfloor of the passenger inside the elevator is less than the floor request
                         setNextFloor(min);
                     }
                     
                 }
                 System.out.println("======================================================");
                    downRequest(Floors); // if callrequest is true uprequest is called again (recursion- making method into smaller steps)
                 
             }else {//if there are no more requesting from starting floor we will fullfil the departure request if theres still passengers in  the elevator
                 //checks inside elevator if there sitll needs passengers to depart to their destination floor
                 if(!Standardelevator.isEmpty()) { //checks if the elevator is not empty
                     int min = Standardelevator.get(0).getEndFloor();//getting the nearest departure request inside the elevator
                     for (int i = 0; i < Standardelevator.size(); i++) {
                         if(Standardelevator.get(i).getEndFloor() > min) {
                             min = Standardelevator.get(i).getEndFloor();
                         }    
                    }
                    setNextFloor(min);//min should be greater than elevators current floor
                 
                     System.out.println("======================================================");
                     downRequest(Floors); // if callrequest is true uprequest is called again (recursion- making method into smaller steps)
                    }
                 else{
                     setCurrentFloor(0);
                     System.out.println("STANDARD ELEVATOR CALL REQUEST DONE");
                     
            
            
        }
        System.out.println("======================================================");
             }             
                         
    }        
}                
                 
                 
             
    
    

    
    
