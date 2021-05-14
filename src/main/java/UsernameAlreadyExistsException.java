public class UsernameAlreadyExistsException extends Exception {

    private String username;

    public UsernameAlreadyExistsException(String username) {
        super(String.format("Un cont cu numele de utilizator %s deja exista!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
