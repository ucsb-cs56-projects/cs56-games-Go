/**
 An interface to represent a place to send messages.
 Used in GoComponent
  
   @author Phill David Winkenwerder and Dustin Henderson
   @version CS56 cp1 05.17.2012
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
