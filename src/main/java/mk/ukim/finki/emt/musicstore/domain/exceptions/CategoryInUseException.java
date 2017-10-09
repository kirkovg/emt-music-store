package mk.ukim.finki.emt.musicstore.domain.exceptions;

public class CategoryInUseException extends Exception {
    public CategoryInUseException() {
    }

    public CategoryInUseException(String message) {
        super(message);
    }
}
