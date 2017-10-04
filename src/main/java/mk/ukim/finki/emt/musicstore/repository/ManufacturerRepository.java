package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
