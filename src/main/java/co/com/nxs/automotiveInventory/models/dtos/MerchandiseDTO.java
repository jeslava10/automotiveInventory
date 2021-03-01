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
public class MerchandiseDTO {

    private Long id;

    private String productName;

    private Long amount;

    private Date admissionDate;

    private Date modificationDate;

    private MerchandiseUserDTO idUser;

}
