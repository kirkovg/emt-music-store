package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
