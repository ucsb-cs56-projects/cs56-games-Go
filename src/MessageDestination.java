//package edu.ucsb.cs56.W14.kwwham.cp1;

/**
 An interface to represent a place to send messages.
 Used in GoComponent
  
   @author Phill David Winkenwerder and Dustin Henderson
   @version CS56 summer 2016
   @author Chunqing Liu and Xingyuan Zhang
   @see GoComponent
 */
public interface MessageDestination
{
    /** 
	Get this string to the user
	@param msg String to send to the user
     */

   public void append(String msg);

}
