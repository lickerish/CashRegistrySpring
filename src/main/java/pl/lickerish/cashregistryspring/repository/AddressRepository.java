package pl.lickerish.cashregistryspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lickerish.cashregistryspring.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
