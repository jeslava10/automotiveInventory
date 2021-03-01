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

}
