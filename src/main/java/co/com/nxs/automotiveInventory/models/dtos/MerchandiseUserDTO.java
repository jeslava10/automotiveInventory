package co.com.nxs.automotiveInventory.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchandiseUserDTO {

    private Long id;

    private String name;

    private Long age;

    private AppointmentDTO idAppointment;

    private Date admissionDate;

}
