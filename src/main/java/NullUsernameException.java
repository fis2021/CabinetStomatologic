public class NullUsernameException extends Exception{
    public NullUsernameException() {
        super("Numele utilizatorului nu este completat!");
    }
}