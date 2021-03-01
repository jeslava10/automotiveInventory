package co.com.nxs.automotiveInventory.repositories;


import co.com.nxs.automotiveInventory.factories.AppointmentFactory;
import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.repositories.AppointmentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryUnitTests {

    private Appointment appointment;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void setUp(){
        appointment = new AppointmentFactory().newInstance();
    }

    @Test
    public void testSaveAppointmentRepository() {

        Appointment appointmentSave = appointmentRepository.save(appointment);
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentSave.getId());

        assertNotNull(optionalAppointment.get());
        assertEquals(optionalAppointment.get().getId(), appointmentSave.getId());
        assertEquals(optionalAppointment.get().getDescription(), appointmentSave.getDescription());
    }

    @Test
    public void testUpdateAppointmentRepository() {

        Appointment appointmentSave = appointmentRepository.save(appointment);
        appointmentSave.setDescription("Asistente de ventas");

        Appointment appointmentUpdate = appointmentRepository.save(appointmentSave);
        Optional<Appointment> optionalAppointmentUpdate = appointmentRepository.findById(appointmentSave.getId());

        assertNotNull(appointmentUpdate);
        assertEquals(appointmentUpdate.getId(), optionalAppointmentUpdate.get().getId());
        assertEquals(appointmentUpdate.getDescription(), optionalAppointmentUpdate.get().getDescription());
    }

    @Test
    public void findAllAppointmentRepository() {
        Appointment appointmentSave = appointmentRepository.save(appointment);
        assertNotNull(appointmentSave);
        assertNotNull(appointmentRepository.findAll());
    }
}