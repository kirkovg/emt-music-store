package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.Category;
import mk.ukim.finki.emt.musicstore.domain.DeliveryPackage;
import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.InstrumentDetails;
import mk.ukim.finki.emt.musicstore.domain.exceptions.CategoryInUseException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.EntityNotFoundException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface StoreManagementService {
    Category createTopLevelCategory(String name);

    Category createCategory(String name, Long parentId);

    Category updateCategoryName(Long id, String newName);

    Category changeCategoryParent(Long id, Long parentId) throws EntityNotFoundException;

    Instrument getInstrument(Long instrumentId);

    Instrument updateInstrumentCategory(Long instrumentId, Long newCategoryId);

    Instrument createInstrument(
        String name,
        BigDecimal price,
        Boolean promoted,
        String itemNumber,
        Long categoryId,
        Long manufacturerId
    );

    Instrument updateInstrument(
        Long id,
        String name,
        BigDecimal price,
        Boolean promoted,
        String itemNumber,
        Long categoryId,
        Long manufacturerId
    );

    void addInstrumentInStock(
        Long instrumentId,
        Integer quantity
    );

    void removeInstrumentFromStock(
        Long instrumentId,
        Integer quantity
    ) throws NotEnoughStockException;

    void removeCategory(Long categoryId) throws CategoryInUseException;

    void clearCart(Long cartId);

    void markInvoiceAsExpired(Long invoiceId);

    DeliveryPackage markInvoiceAsPayed(Long invoiceId);

    void preparedDelivery(Long deliverId);

    void shippedDelivery(Long deliveryId);

    void closeDeliveryWithoutConfirmation(Long deliveryId);

    InstrumentDetails addInstrumentDetails(
        Long instrumentId,
        byte[] content,
        String contentType,
        String description
    ) throws SQLException;

    InstrumentDetails updateInstrumentDetails(
        Long instrumentId,
        byte[] content,
        String contentType,
        String description
    ) throws SQLException;

    void removeInstrumentDetails(Long instrumentId);
}
