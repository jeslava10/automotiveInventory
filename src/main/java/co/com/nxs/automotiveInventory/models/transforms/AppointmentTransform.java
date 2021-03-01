package co.com.nxs.automotiveInventory.models.transforms;

import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;

public class AppointmentTransform {

    public AppointmentDTO AppointmentToAppointmentDTO(Appointment appointment){
        AppointmentDTO appointmentDTOResponse = null;

        if (null != appointment){
            appointmentDTOResponse = AppointmentDTO.builder()
                    .id(appointment.getId())
                    .description(appointment.getDescription())
                    .build();
        }

        return appointmentDTOResponse;
    }

    public Appointment AppointmentDtoToAppointment(AppointmentDTO appointmentDTO){
        Appointment appointmenResponse = null;

        if (null != appointmentDTO){
            appointmenResponse = Appointment.builder()
                    .id(appointmentDTO.getId())
                    .description(appointmentDTO.getDescription())
                    .build();
        }

        return appointmenResponse;
    }


}
