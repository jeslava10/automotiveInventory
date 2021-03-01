package co.com.nxs.automotiveInventory.models.transforms;

import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;

public class MerchandiseUserTransform {

    private static final AppointmentTransform appointmentTransforms = new AppointmentTransform();

    public MerchandiseUserDTO MerchandiseUserToMerchandiseUserDTO(MerchandiseUser merchandiseUser) {
        MerchandiseUserDTO merchandiseUserDTOResponse = null;

        if (null != merchandiseUser) {
            merchandiseUserDTOResponse = MerchandiseUserDTO.builder()
                    .id(merchandiseUser.getId())
                    .name(merchandiseUser.getName())
                    .admissionDate(merchandiseUser.getAdmissionDate())
                    .age(merchandiseUser.getAge())
                    .idAppointment(appointmentTransforms.AppointmentToAppointmentDTO(merchandiseUser.getIdAppointment()))
                    .build();
        }

        return merchandiseUserDTOResponse;

    }

    public MerchandiseUser MerchandiseUserDTOToMerchandiseUser(MerchandiseUserDTO merchandiseUserDTO) {
        MerchandiseUser merchandiseUserResponse = null;

        if (null != merchandiseUserDTO) {
            merchandiseUserResponse = MerchandiseUser.builder()
                    .id(merchandiseUserDTO.getId())
                    .name(merchandiseUserDTO.getName())
                    .admissionDate(merchandiseUserDTO.getAdmissionDate())
                    .age(merchandiseUserDTO.getAge())
                    .idAppointment(appointmentTransforms.AppointmentDtoToAppointment(merchandiseUserDTO.getIdAppointment()))
                    .build();
        }

        return merchandiseUserResponse;

    }

}
