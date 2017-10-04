package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
