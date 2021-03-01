package co.com.nxs.automotiveInventory.repositories;

import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseUserRepository extends JpaRepository<MerchandiseUser, Long> {

}
