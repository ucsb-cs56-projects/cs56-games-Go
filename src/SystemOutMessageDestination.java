//package edu.ucsb.cs56.S12.dwinkenwerder.cp1

/**
   An interface to represent a place to send messages. Used in GoComponent
   
   @author David Winkenwerder and Dustin Henderson
   @version CS56 cp1 05.17.2012
   @see GoComponent
*/
public class SystemOutMessageDestination implements MessageDestination
{
    /**
       Get this string to the user via System.out
       @param msg message to display to user
    */
    
    public void append(String msg)
    {
	System.out.println(msg);
    }
}