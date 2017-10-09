package mk.ukim.finki.emt.musicstore.service.custom;



import mk.ukim.finki.emt.musicstore.domain.Cart;
import mk.ukim.finki.emt.musicstore.domain.CartItem;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughItemQuantityException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;

import java.math.BigDecimal;
import java.util.List;

public interface CartServiceHelper {
    Cart takeCart();

    CartItem addToCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException;

    void removeFromCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException, NotEnoughItemQuantityException;

    BigDecimal getTotalPriceFromCart(Long cartId);

    List<CartItem> getAllFromCart(Long cartId);

    void clearCart(Long cartId);
}
