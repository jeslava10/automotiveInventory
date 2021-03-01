package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.exceptions.ResourceNotFoundException;
import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import co.com.nxs.automotiveInventory.models.transforms.AppointmentTransform;
import co.com.nxs.automotiveInventory.repositories.AppointmentRepository;
import co.com.nxs.automotiveInventory.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppointmentService {

    private static final AppointmentTransform APPOINTMENT_TRANSFORM = new AppointmentTransform();

    private final AppointmentRepository appointmentRepository;
    private  final MessageUtil messageUtil;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              MessageUtil messageUtil) {
        this.appointmentRepository = appointmentRepository;
        this.messageUtil = messageUtil;

    }

    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {

        if (appointmentDTO != null) {

            Appointment appointment = Appointment.builder()
                    .id(appointmentDTO.getId())
                    .description(appointmentDTO.getDescription())
                    .build();

            return APPOINTMENT_TRANSFORM.AppointmentToAppointmentDTO(appointmentRepository.save(appointment));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));
    }

    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {

        if (appointmentDTO != null) {

            Appointment appointment = Appointment.builder()
                    .id(appointmentDTO.getId())
                    .description(appointmentDTO.getDescription())
                    .build();

            return APPOINTMENT_TRANSFORM.AppointmentToAppointmentDTO(appointmentRepository.save(appointment));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));

    }

    public List<AppointmentDTO> findAllAppointment() {
        return appointmentRepository.findAll().stream()
                .map(APPOINTMENT_TRANSFORM::AppointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    public String deleteAppointment(Long id) {

        if (id != null) {
            appointmentRepository.deleteById(id);
            return messageUtil.resolveMessageSource("successful.delete.message");
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("fieldEmpty.exception.message"));

    }
}
