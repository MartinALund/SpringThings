package dk.lundudvikling.springthings.people.exceptions;

public class JpaException extends Exception {

    public JpaException() {
        super();
    }

    public JpaException(String message) {
        super(message);
    }
}
