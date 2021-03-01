package co.com.nxs.automotiveInventory.repositories;

import co.com.nxs.automotiveInventory.models.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {

    Merchandise findByProductName(String productName);

}
