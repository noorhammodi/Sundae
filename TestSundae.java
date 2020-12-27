import java.util.*;
public class TestSundae {
	
	static Scanner key=new Scanner(System.in);
    private static Sundae[] todaysSundaes;

	//What this method does is essentially display the main menu, to see what the user wants to do. 
    //it loops until user puts a value between 1 and 5.
    public static int MainMenu() {
    	int answer=0;
    	
    	System.out.println("What do you want to do? ");
		
		System.out.println("\t 1. Enter a new sundae order"+"\n\t 2. Change information a specific order"+
		"\n\t 3. Display details for all sundaes of a specific ice cream flavor"+"\n\t 4. Statistics on today's sundaes"+
				"\n\t 5. Quit");
		System.out.print("Please enter your choice > ");
		answer=key.nextInt();
	//below we are implementing a while loop so that if user enters a number thats not an option
	// program keeps prompting user until they're answer is valid
		while(answer<1||answer>5) {
			System.out.print("not valid, try again");
			System.out.print("Please enter your choice > ");
			answer=key.nextInt();
			}
		return answer;
    }
    //what this method does essentially is display the Statistics Menu. this menu only appears when the user chooses to see todays statistics
    //within this menu there is another set of options
    public static void StatMenu() {
    	do {
    		System.out.println("What information would you like?"+"\n\t 1. List all sundaes sold today"
    				+"\n\t 2. Details of the cheapest sundae \n\t 3. Number of sundaes sold today \n\t 4. Number of sundaes with a specific # of scoop"
    							+"\n\t 5. Average cost of sundaes \n\t 6. Quit"+"\n Enter your choice >");
    
    	int reponse=key.nextInt();
    	//what is happening here is that we are checking the array filled with the sundaes object and getting the number of sundaes total
    	if(reponse==1) { 
    		for(int j=0;j<Sundae.getNbSundaes();j++) 
    			System.out.println(todaysSundaes[j].toString());
    	}
    	
    	else if (reponse==2) {
    		Sundae thecheapest=todaysSundaes[0];
    		for(int k=1;k<Sundae.getNbSundaes();k++) {
    			if(todaysSundaes[k].getCost()<thecheapest.getCost())
    				thecheapest=todaysSundaes[k];
    		}
    		System.out.println(thecheapest.toString());
    		
    	}
    	else if(reponse==3) {
    		System.out.print("Number of sundaes sold: "+ Sundae.getNbSundaes());
    		
    	}
    	else if (reponse==4) {
    		System.out.print("How many scoops? ");
    		int scoops1=key.nextInt();
    		for(int w=0;w<Sundae.getNbSundaes();w++) {
    			if(todaysSundaes[w].getScoops()==scoops1) {
    				System.out.print(todaysSundaes[w].toString());
    			}
    				   		}
    	}
    	else if (reponse==5) {
    		double total=0.0;
    		for(int u=0;u<Sundae.getNbSundaes();u++) {
    			total+=todaysSundaes[u].getCost();
    		}
    		double average=(total/Sundae.getNbSundaes());
    		System.out.println("Average = $" +average);
    	}
    	else if (reponse==6) {
    		MainMenu();
    	}
    	}while(true);
    } 
    
	public static void main(String[] args) {
		
	     System.out.println("Welcome to Nancy's Sundae Parlour!");
	     System.out.print("How many sundaes could you make today?");
	     int max=key.nextInt();
	     Sundae[] todaysSundaes = new Sundae[max];
	     int option=MainMenu();
	     int num=0;
	     if(option!=5) {
	    	 switch (option) {
//if user chooses to add a sundae, what this segment of code does is that it adds a new sundae, but first we check if we have enough ingredients
	    	 
	    	 case 1: {
	    		 if(num>=max) {
	                   System.out.println("\nSorry we don't have enough ingredients to make another sundae.\n");
	               }
	               else {
	            	  //we are creating a new sundae
	               Sundae s1;
	    	       System.out.print("\nHow many scoops of icecream? ");
	    	       int scoops=key.nextInt();
	    	       while(scoops<=0) {
	    	           System.out.print("\nHow many scoops of icecream? ");
	    	           scoops=key.nextInt();
	    	       }
	    	       key.nextLine();
	    	       System.out.print("What flavor? ");
	    	       String flavor=key.nextLine();
	    	       System.out.print("Any nuts? (y for yes anything else for no) ");
	    	       char nut=key.nextLine().charAt(0);
	    	       if(nut=='y' || nut=='Y') {
	    	           s1=new Sundae(flavor,scoops,true);
	    	       }
	    	       else {
	    	          s1=new Sundae(flavor,scoops,false);
	    	       }
	    	       todaysSundaes[max]=s1;
	    	       return;
			      
	    	 }
	    	 }
	    	 break;
				
	    	//this section changes the flavor,scoops and nuts and costs, by accessing each variable and setting them to users input, only way to exit is to press 4 for exit 
	    	case 2:{
	    		{
	    			System.out.println("\t----->valid sundae numbers are 0 to "+ (todaysSundaes.length-1));
	    			System.out.print("which sundae do you wish to modify? ");
	    			int answer=key.nextInt();
	    			if(answer>todaysSundaes.length-1) {
	    				System.out.println("sorry no such sundae.");
	    				System.out.println("Do you want to enter another sundae number or return to the Main menu? ");
	    				if (key.next().compareToIgnoreCase("quit")==0)
	    					break;
	    				else if 
	    					(key.next().compareToIgnoreCase("return")==0);
	    					MainMenu();

	    			}
	    			else {
	    				System.out.println("Sundae #"+Sundae.getNbSundaes());
	    				System.out.println(" "+todaysSundaes[answer].toString());
	    				
	    				int choice=0;
	    				do {
	    				System.out.print("What would you like to change?"+
	    				"\n\t 1.Ice cream flavour \n\t 2.Number of scoops \n\t 3.Nuts or no nuts \n\t 4.quit"+
	    						"\n Enter choice > ");
	    				choice=key.nextInt();
	    				 
	    					switch(choice) {
	    				
	    					case 1:
	    						System.out.print("New Flavour: ");			
	    						todaysSundaes[choice].setFlavor(key.next());	
	    						System.out.println("Here is what the sundae looks like now");
	    						System.out.println(todaysSundaes[choice].toString());
	    						
	    						break;
	    					case 2:
	    						System.out.println("How many scoops? ");
	    						todaysSundaes[choice].setScoops(key.nextInt());
	    						todaysSundaes[choice].updateCost();
	    						System.out.println("Here is what the sundae looks like now");
	    						System.out.println("\t"+todaysSundaes[choice].toString());
	    						break;
	    					case 3:
	    						if(todaysSundaes[choice].getNuts()==true)							
	    							todaysSundaes[choice].setNuts(false);
	    						else
	    							todaysSundaes[choice].setNuts(true);
	    						todaysSundaes[choice].updateCost();
	    						System.out.println("Here is what the sundae looks like now");
	    						System.out.println("\t"+todaysSundaes[choice].toString());
	    						break;
	    					}
	    					
	    			}while (choice!=4);	
	    		}
	    	 }
	    	 }
	    	//
	    	case 3:{
	    		System.out.print("What flavor do you want list of ");
                String flavor = key.next();
                for (int i = 0; i < Sundae.getNbSundaes(); i++) {
                    if (todaysSundaes[i].getFlavor().equals(flavor)) {
                        System.out.println("Sundae #" + i);
                        System.out.println(todaysSundaes[i].toString());
                    }
                }
	    	}
	    	break;
	    	case 4:{
	    		StatMenu();
	    		
	    	}
	    	

	}

}else 
	    		 System.out.println("goodbye");
	    		 


	
}
}

