package co.com.nxs.automotiveInventory.repositories;

import co.com.nxs.automotiveInventory.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AppointmentRepository extends JpaRepository<Appointment, Long> {

}
