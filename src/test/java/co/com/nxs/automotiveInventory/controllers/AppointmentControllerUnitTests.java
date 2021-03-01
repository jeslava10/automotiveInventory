package co.com.nxs.automotiveInventory.controllers;


import co.com.nxs.automotiveInventory.factories.AppointmentFactory;
import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import co.com.nxs.automotiveInventory.models.transforms.AppointmentTransform;
import co.com.nxs.automotiveInventory.services.AppointmentService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentControllerUnitTests {

    private Appointment appointment;
    private AppointmentDTO appointmentDTO;
    private static final AppointmentTransform APPOINTMENT_TRANSFORM = new AppointmentTransform();

    @Autowired
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp(){
        appointment = new AppointmentFactory().newInstance();
        appointmentDTO = APPOINTMENT_TRANSFORM.AppointmentToAppointmentDTO(appointment);
    }

    @Test
    public void saveAppointment() {

        AppointmentDTO appointmentDTOSave =  appointmentService.saveAppointment(appointmentDTO);
        assertNotNull(appointmentDTOSave);
        assertEquals(appointmentDTOSave.getId(), appointmentDTO.getId());
        assertEquals(appointmentDTOSave.getDescription(), appointmentDTO.getDescription());
    }

    @Test
    public void UpdateAppointment() {

        AppointmentDTO appointmentDTOUpdate =  appointmentService.saveAppointment(appointmentDTO);
        assertNotNull(appointmentDTOUpdate);
        assertEquals(appointmentDTOUpdate.getId(), appointmentDTO.getId());

    }

    @Test
    public void findAllAppointment() {
        List<AppointmentDTO> appointmentDTOList = appointmentService.findAllAppointment();
        assertNotNull(appointmentDTOList);
        assertEquals(appointmentDTOList.get(2).getId(), appointmentDTO.getId());
        assertEquals(appointmentDTOList.get(2).getDescription(), appointmentDTO.getDescription());
    }

}
