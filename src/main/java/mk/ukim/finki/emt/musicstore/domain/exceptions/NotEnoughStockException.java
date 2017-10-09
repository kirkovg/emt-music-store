package mk.ukim.finki.emt.musicstore.domain.exceptions;

public class NotEnoughStockException extends Exception {

    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String message) {
        super(message);
    }
}
