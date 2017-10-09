package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.*;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughItemQuantityException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;

import java.math.BigDecimal;
import java.util.List;

public interface StoreClientService {
    Cart takeCart();

    List<Category> getTopLevelCategories();

    List<Category> getSubCategories(Long categoryId);

    InstrumentDetails getInstrumentDetails(Long instrumentId);

    InstrumentRating getInstrumentRating(Long instrumentId);

    InstrumentRating updateInstrumentRating(Long instrumentId, Integer rating);

    CartItem addToCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException;

    void removeFromCart(Long cartId, Long instrumentId, Integer quantity)
            throws NotEnoughStockException, NotEnoughItemQuantityException;

    BigDecimal getTotalPriceFromCart(Long cartId);

    List<CartItem> getAllFromCart(Long cartId);

    Checkout startCheckout(Long cartId);

    DeliveryInfo provideDeliveryInfo(
        Long checkoutId,
        String country,
        String city,
        String postalCode,
        String address
    );

    ContactInfo provideContactInfo(
        Long checkoutId,
        String firstName,
        String lastName,
        String phone
    );

    void provideDeliveryAndContactInfoFromCustomerCard(Long checkoutId, Long customerId);

    void provideCoupon(Long checkoutId, String coupon);

    Invoice providePaymentInfo(
        Long checkoutId,
        String cardNumber,
        String cardHolder,
        String cardType,
        String cvs,
        String expiryDate
    );

    void confirmDelivery(
        Long invoiceId,
        Integer rating,
        String comment
    );
}
