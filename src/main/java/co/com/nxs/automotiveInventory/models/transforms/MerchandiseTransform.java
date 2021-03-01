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

    public Merchandise MerchandiseDTOToMerchandise(MerchandiseDTO merchandiseDTO){
        Merchandise MerchandiseResponse = null;

        if (null != merchandiseDTO){
            MerchandiseResponse = Merchandise.builder()
                    .id(merchandiseDTO.getId())
                    .productName(merchandiseDTO.getProductName())
                    .admissionDate(merchandiseDTO.getAdmissionDate())
                    .amount(merchandiseDTO.getAmount())
                    .modificationDate(merchandiseDTO.getModificationDate())
                    .idUser(merchandiseUserTransforms.MerchandiseUserDTOToMerchandiseUser(merchandiseDTO.getIdUser()))
                    .build();
        }

        return MerchandiseResponse;
    }

}
