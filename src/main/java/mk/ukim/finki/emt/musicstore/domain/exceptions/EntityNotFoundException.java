package mk.ukim.finki.emt.musicstore.domain.exceptions;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
