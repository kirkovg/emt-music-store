package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.*;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughItemQuantityException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;
import mk.ukim.finki.emt.musicstore.service.custom.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StoreClientServiceImpl implements StoreClientService {

    private CartServiceHelper cartServiceHelper;
    private CategoryServiceHelper categoryServiceHelper;
    private InstrumentServiceHelper instrumentServiceHelper;
    private InstrumentDetailsServiceHelper instrumentDetailsServiceHelper;

    public StoreClientServiceImpl(
            CartServiceHelper cartServiceHelper,
            CategoryServiceHelper categoryServiceHelper,
            InstrumentServiceHelper instrumentServiceHelper,
            InstrumentDetailsServiceHelper instrumentDetailsServiceHelper) {
        this.cartServiceHelper = cartServiceHelper;
        this.categoryServiceHelper = categoryServiceHelper;
        this.instrumentServiceHelper = instrumentServiceHelper;
        this.instrumentDetailsServiceHelper = instrumentDetailsServiceHelper;
    }

    @Override
    public Cart takeCart() {
        return cartServiceHelper.takeCart();
    }

    @Override
    public List<Category> getTopLevelCategories() {
        return categoryServiceHelper.getTopLevelCategories();
    }

    @Override
    public List<Category> getSubCategories(Long categoryId) {
        return categoryServiceHelper.getSubCategories(categoryId);
    }

    @Override
    public InstrumentDetails getInstrumentDetails(Long instrumentId) {
        return instrumentDetailsServiceHelper.getInstrumentDetails(instrumentId);
    }

    @Override
    public InstrumentRating getInstrumentRating(Long instrumentId) {
        return null;
    }

    @Override
    public InstrumentRating updateInstrumentRating(Long instrumentId, Integer rating) {
        return null;
    }

    @Override
    public CartItem addToCart(Long cartId, Long instrumentId, Integer quantity) throws NotEnoughStockException {
        return cartServiceHelper.addToCart(cartId, instrumentId, quantity);
    }

    @Override
    public void removeFromCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException, NotEnoughItemQuantityException {
        cartServiceHelper.removeFromCart(cartId, instrumentId, quantity);
    }

    @Override
    public BigDecimal getTotalPriceFromCart(Long cartId) {
        return cartServiceHelper.getTotalPriceFromCart(cartId);
    }

    @Override
    public List<CartItem> getAllFromCart(Long cartId) {
        return cartServiceHelper.getAllFromCart(cartId);
    }

    @Override
    public Checkout startCheckout(Long cartId) {
        return null;
    }

    @Override
    public DeliveryInfo provideDeliveryInfo(Long checkoutId, String country, String city, String postalCode, String address) {
        return null;
    }

    @Override
    public ContactInfo provideContactInfo(Long checkoutId, String firstName, String lastName, String phone) {
        return null;
    }

    @Override
    public void provideDeliveryAndContactInfoFromCustomerCard(Long checkoutId, Long customerId) {

    }

    @Override
    public void provideCoupon(Long checkoutId, String coupon) {

    }

    @Override
    public Invoice providePaymentInfo(Long checkoutId, String cardNumber, String cardHolder, String cardType, String cvs, String expiryDate) {
        return null;
    }

    @Override
    public void confirmDelivery(Long invoiceId, Integer rating, String comment) {

    }
}
