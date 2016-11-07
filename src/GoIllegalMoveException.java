/**
   Exception for illegal move in Go. Its used in the GoGrid file.
   @author David Winkenwerder and Dustin Henderson
   @version CS56 Spring 2012, UCSB
   @see GoGrid
*/
    public class GoIllegalMoveException extends RuntimeException {
    // we have to declare this, because we declaired the other one, so this wont get made automaticly
    public GoIllegalMoveException () {};
    public GoIllegalMoveException (String messege) {
	super(messege);
    }
}
