package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.factories.AppointmentFactory;
import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import co.com.nxs.automotiveInventory.models.transforms.AppointmentTransform;
import co.com.nxs.automotiveInventory.repositories.AppointmentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceUnitTests {

    private Appointment appointment;
    private AppointmentDTO appointmentDTO;
    private static final AppointmentTransform APPOINTMENT_TRANSFORM = new AppointmentTransform();

    @Autowired
    private AppointmentService appointmentService;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void setUp(){
        appointment = new AppointmentFactory().newInstance();
        appointmentDTO = APPOINTMENT_TRANSFORM.AppointmentToAppointmentDTO(appointment);
    }


    @Test
    public void testCreateAppointment() {

        Mockito.when(appointmentRepository.save(appointment)).thenReturn(appointment);
        assertThat(appointmentService.saveAppointment(appointmentDTO)).isEqualTo(appointment);
    }

    @Test
    public void testUpdateAppointment() {
         Mockito.when(appointmentRepository.findById(appointmentDTO.getId())).thenReturn(Optional.of(appointment));
         appointment.setDescription("Asistente de ventas jefe");
        appointmentDTO.setDescription("Asistente de ventas jefe");
         Mockito.when(appointmentRepository.save(appointment)).thenReturn(appointment);
         assertThat(appointmentService.updateAppointment(appointmentDTO).equals(appointment));
    }


}

