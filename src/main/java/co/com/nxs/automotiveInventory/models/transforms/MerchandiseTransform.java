package co.com.nxs.automotiveInventory.models.transforms;

import co.com.nxs.automotiveInventory.models.Merchandise;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;

public class MerchandiseTransform {

    private static final MerchandiseUserTransform merchandiseUserTransforms = new MerchandiseUserTransform();

    public MerchandiseDTO MerchandiseToMerchandiseDTO(Merchandise merchandise){
        MerchandiseDTO MerchandiseDTOResponse = null;

        if (null != merchandise){
            MerchandiseDTOResponse = MerchandiseDTO.builder()
                    .id(merchandise.getId())
                    .productName(merchandise.getProductName())
                    .admissionDate(merchandise.getAdmissionDate())
                    .amount(merchandise.getAmount())
                    .modificationDate(merchandise.getModificationDate())
                    .idUser(merchandiseUserTransforms.MerchandiseUserToMerchandiseUserDTO(merchandise.getIdUser()))
                    .build();
        }

        return MerchandiseDTOResponse;
    }

}
