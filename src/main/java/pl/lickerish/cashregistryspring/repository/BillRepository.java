package pl.lickerish.cashregistryspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lickerish.cashregistryspring.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
