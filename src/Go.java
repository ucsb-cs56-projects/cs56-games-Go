//package edu.ucsb.cs56.S12.dwinkenwerder.cp1;

import java.util.Scanner;

/**
   A Text UI for playing Go.

  
   @author David Winkenwerder and Dustin Henderson
   @version CS56 cp1 05.17.2012
   @see GoGridTest
 */
public class Go
{
    
    public static void main(String [] args) {
	
	Scanner sc = new Scanner(System.in);
	boolean done = false;
	char winner=' ';
	boolean surrender1=false;boolean surrender2=false;
	
	// GoGrid implements GoGame
	GoGame g = new GoGrid();
	
	while (!done) {
	   System.out.println(g); // g.toString() implicitly invoked
	   System.out.print(g.getTurn() + "'s move: ");
	   System.out.println("Enter the space to place your tile, or press 0 to pass.");
	   String line  = sc.nextLine();
	 
	   int num = 0;
	   try {
	       num = Integer.parseInt(line);
	       if(num==0 && g.getTurn()=='B'){
		   surrender1=true;
		   g.setTurn('W');
	       }
	       else if(num == 0 && g.getTurn()=='W'){
		   surrender2=true;
		   g.setTurn('B');
	       }
	       else if (g.isBlank(num)) {
		   winner = g.move(num);		   
		   done = (winner!=' ');
	       }
	       else
		   System.out.println("Space " + num + " is already occupied");
	   } catch ( NumberFormatException nfe ) {
	       System.out.println("You entered: " + line);
	       System.out.println("Instead, please enter a number between 1 and 361 of a space not occupied.");
	   }
	   if(surrender1 && surrender2){
	       g.setSurrendering();
	       winner = g.getWinner();
	       done=true;
	   }
	 }
	System.out.println(g); // g.toString() implicitly invoked
	if (winner==' ')
	    System.out.println("Game was a draw");
	else
	    System.out.println(winner + " wins!");
	System.out.println("Goodbye!");
    }

}