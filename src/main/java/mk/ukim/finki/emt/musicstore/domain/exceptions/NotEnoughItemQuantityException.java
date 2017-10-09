package mk.ukim.finki.emt.musicstore.domain.exceptions;

public class NotEnoughItemQuantityException extends Exception {

    public NotEnoughItemQuantityException(String message) {
        super(message);
    }

    public NotEnoughItemQuantityException() {
    }
}
