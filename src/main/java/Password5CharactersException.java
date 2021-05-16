public class Password5CharactersException extends Exception{
    public Password5CharactersException() {
        super("Parola trebuie sa contina minim 5 caractere!");
    }
}