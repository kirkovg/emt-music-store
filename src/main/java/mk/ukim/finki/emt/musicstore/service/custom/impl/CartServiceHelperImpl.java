package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.Cart;
import mk.ukim.finki.emt.musicstore.domain.CartItem;
import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughItemQuantityException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;
import mk.ukim.finki.emt.musicstore.repository.CartItemRepository;
import mk.ukim.finki.emt.musicstore.repository.CartRepository;
import mk.ukim.finki.emt.musicstore.repository.InstrumentRepository;
import mk.ukim.finki.emt.musicstore.service.custom.CartServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceHelperImpl implements CartServiceHelper {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private InstrumentRepository instrumentRepository;

    @Autowired
    public CartServiceHelperImpl(CartRepository cartRepository,
                                 CartItemRepository cartItemRepository,
                                 InstrumentRepository instrumentRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public Cart takeCart() {
        Cart cart = new Cart();
        cart.setExpiryDate(LocalDateTime.now().plusDays(7));
        cart.setTotalPrice(new BigDecimal(0));
        return cartRepository.save(cart);
    }

    @Override
    public CartItem addToCart(Long cartId, Long instrumentId, Integer quantity) throws NotEnoughStockException {
        Cart cart = cartRepository.findOne(cartId);
        Instrument instrument = instrumentRepository.findOne(instrumentId);

        CartItem cartItem = cartItemRepository.findByCartIdAndInstrumentId(cartId, instrumentId);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setInstrument(instrument);
        }

        if (instrument.getQuantityInStock() == 0 || instrument.getQuantityInStock() == null
                || instrument.getQuantityInStock() < quantity) {
            throw new NotEnoughStockException();
        } else {
            instrument.setQuantityInStock(instrument.getQuantityInStock() - quantity);
        }

        instrumentRepository.save(instrument);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void removeFromCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException, NotEnoughItemQuantityException {
        Instrument instrument = instrumentRepository.findOne(instrumentId);
        CartItem cartItem = cartItemRepository.findByCartIdAndInstrumentId(cartId, instrumentId);

        if (cartItem.getQuantity() < quantity) {
            throw new NotEnoughItemQuantityException();
        } else if (cartItem.getQuantity().equals(quantity)) {
            instrument.setQuantityInStock(instrument.getQuantityInStock() + quantity);
            cartItemRepository.delete(cartItem);
            instrumentRepository.save(instrument);
            return;
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            instrument.setQuantityInStock(instrument.getQuantityInStock() + quantity);
        }

        instrumentRepository.save(instrument);
        cartItemRepository.save(cartItem);
    }

    @Override
    public BigDecimal getTotalPriceFromCart(Long cartId) {
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartId(cartId);
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem c : cartItems) {
            BigDecimal subtotal = c.getInstrument().getPrice().multiply(new BigDecimal(c.getQuantity()));
            total.add(subtotal);
        }
        return total;
    }

    @Override
    public List<CartItem> getAllFromCart(Long cartId) {
        return cartItemRepository.findCartItemsByCartId(cartId);
    }

    @Override
    public void clearCart(Long cartId) {
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartId(cartId);
        cartItemRepository.delete(cartItems);
    }
}
