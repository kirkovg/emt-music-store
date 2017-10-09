package mk.ukim.finki.emt.musicstore.service.custom.impl;

import mk.ukim.finki.emt.musicstore.domain.Category;
import mk.ukim.finki.emt.musicstore.domain.DeliveryPackage;
import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.InstrumentDetails;
import mk.ukim.finki.emt.musicstore.domain.exceptions.CategoryInUseException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.EntityNotFoundException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;
import mk.ukim.finki.emt.musicstore.service.custom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class StoreManagementServiceImpl implements StoreManagementService {

    private CategoryServiceHelper categoryServiceHelper;
    private InstrumentServiceHelper instrumentServiceHelper;
    private InstrumentDetailsServiceHelper instrumentDetailsServiceHelper;
    private StockServiceHelper stockServiceHelper;
    private CartServiceHelper cartServiceHelper;

    @Autowired
    public StoreManagementServiceImpl(CategoryServiceHelper categoryServiceHelper,
                                      InstrumentServiceHelper instrumentServiceHelper,
                                      InstrumentDetailsServiceHelper instrumentDetailsServiceHelper,
                                      StockServiceHelper stockServiceHelper,
                                      CartServiceHelper cartServiceHelper) {
        this.categoryServiceHelper = categoryServiceHelper;
        this.instrumentServiceHelper = instrumentServiceHelper;
        this.instrumentDetailsServiceHelper = instrumentDetailsServiceHelper;
        this.stockServiceHelper = stockServiceHelper;
        this.cartServiceHelper = cartServiceHelper;
    }

    @Override
    public Category createTopLevelCategory(String name) {
        return categoryServiceHelper.createTopLevelCategory(name);
    }

    @Override
    public Category createCategory(String name, Long parentId) {
        return categoryServiceHelper.createCategory(name, parentId);
    }

    @Override
    public Category updateCategoryName(Long id, String newName) {
        return categoryServiceHelper.updateCategoryName(id, newName);
    }

    @Override
    public Category changeCategoryParent(Long id, Long parentId) throws EntityNotFoundException {
        return categoryServiceHelper.changeCategoryParent(id, parentId);
    }

    @Override
    public Instrument getInstrument(Long instrumentId) {
        return instrumentServiceHelper.getInstrument(instrumentId);
    }

    @Override
    public Instrument updateInstrumentCategory(Long instrumentId, Long newCategoryId) {
        return instrumentServiceHelper.updateInstrumentCategory(instrumentId, newCategoryId);
    }

    @Override
    public Instrument createInstrument(
            String name,
            BigDecimal price,
            Boolean promoted,
            String itemNumber,
            Long categoryId,
            Long manufacturerId) {

        return instrumentServiceHelper.createInstrument(name, price, promoted, itemNumber, categoryId, manufacturerId);
    }

    @Override
    public Instrument updateInstrument(
            Long id,
            String name,
            BigDecimal price,
            Boolean promoted,
            String itemNumber,
            Long categoryId,
            Long manufacturerId) {

        return instrumentServiceHelper.updateInstrument(id, name, price, promoted, itemNumber, categoryId, manufacturerId);
    }

    @Override
    public void addInstrumentInStock(Long instrumentId, Integer quantity) {
        stockServiceHelper.addInstrumentInStock(instrumentId, quantity);
    }

    @Override
    public void removeInstrumentFromStock(Long instrumentId, Integer quantity) throws NotEnoughStockException {
        stockServiceHelper.removeInstrumentFromStock(instrumentId, quantity);
    }

    @Override
    public void removeCategory(Long categoryId) throws CategoryInUseException {
        categoryServiceHelper.removeCategory(categoryId);
    }

    @Override
    public void clearCart(Long cartId) {
        cartServiceHelper.clearCart(cartId);
    }

    @Override
    public void markInvoiceAsExpired(Long invoiceId) {

    }

    @Override
    public DeliveryPackage markInvoiceAsPayed(Long invoiceId) {
        return null;
    }

    @Override
    public void preparedDelivery(Long deliverId) {

    }

    @Override
    public void shippedDelivery(Long deliveryId) {

    }

    @Override
    public void closeDeliveryWithoutConfirmation(Long deliveryId) {

    }

    @Override
    public InstrumentDetails addInstrumentDetails(
            Long instrumentId,
            byte[] content,
            String contentType,
            String description) throws SQLException {

        return instrumentDetailsServiceHelper.addInstrumentDetails(instrumentId, content, contentType, description);
    }

    @Override
    public InstrumentDetails updateInstrumentDetails(
            Long instrumentId,
            byte[] content,
            String contentType,
            String description
    ) throws SQLException {
        return instrumentDetailsServiceHelper.updateInstrumentDetails(instrumentId, content, contentType, description);
    }

    @Override
    public void removeInstrumentDetails(Long instrumentId) {
        instrumentDetailsServiceHelper.removeInstrumentDetails(instrumentId);
    }
}
