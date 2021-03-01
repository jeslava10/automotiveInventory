package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.exceptions.ResourceNotFoundException;
import co.com.nxs.automotiveInventory.models.Merchandise;
import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseTransform;
import co.com.nxs.automotiveInventory.repositories.MerchandiseRepository;
import co.com.nxs.automotiveInventory.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MerchandiseService {

    private static final MerchandiseTransform MERCHANDISE_TRANSFORM = new MerchandiseTransform();

    private final MerchandiseRepository merchandiseRepository;
    private  final MessageUtil messageUtil;

    @Autowired
    public MerchandiseService(MerchandiseRepository merchandiseRepository,
                              MessageUtil messageUtil) {
        this.merchandiseRepository = merchandiseRepository;
        this.messageUtil = messageUtil;

    }

    public MerchandiseDTO saveMerchandise(MerchandiseDTO merchandiseDTO) {

        if (merchandiseDTO.getId() != null) {

            Merchandise merchandise = Merchandise.builder()
                    .id(merchandiseDTO.getId())
                    .amount(merchandiseDTO.getAmount())
                    .admissionDate(merchandiseDTO.getAdmissionDate())
                    .productName(merchandiseDTO.getProductName())
                    .idUser(MerchandiseUser.builder().id(merchandiseDTO.getIdUser().getId()).build())
                    .build();

            return MERCHANDISE_TRANSFORM.MerchandiseToMerchandiseDTO(merchandiseRepository.save(merchandise));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));

    }

    public MerchandiseDTO updateMerchandise(MerchandiseDTO merchandiseDTO) {

        if (merchandiseDTO != null) {

            Merchandise merchandise = Merchandise.builder()
                    .id(merchandiseDTO.getId())
                    .amount(merchandiseDTO.getAmount())
                    .admissionDate(merchandiseDTO.getAdmissionDate())
                    .productName(merchandiseDTO.getProductName())
                    .idUser(MerchandiseUser.builder().id(merchandiseDTO.getIdUser().getId()).build())
                    .build();

            return MERCHANDISE_TRANSFORM.MerchandiseToMerchandiseDTO(merchandiseRepository.save(merchandise));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));

    }

    public List<MerchandiseDTO> findAllMerchandise() {
        return merchandiseRepository.findAll().stream()
                .map(MERCHANDISE_TRANSFORM::MerchandiseToMerchandiseDTO)
                .collect(Collectors.toList());
    }

    public void deleteMerchandise(MerchandiseDTO merchandiseDTO) {

        if (merchandiseDTO != null) {

            Merchandise merchandise = Merchandise.builder()
                    .id(merchandiseDTO.getId())
                    .amount(merchandiseDTO.getAmount())
                    .admissionDate(merchandiseDTO.getAdmissionDate())
                    .productName(merchandiseDTO.getProductName())
                    .idUser(MerchandiseUser.builder().id(merchandiseDTO.getIdUser().getId()).build())
                    .build();

            merchandiseRepository.delete(merchandise);


        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("fieldEmpty.exception.message"));

    }

    public MerchandiseDTO findByProductName(String productName) {

        if (!productName.isEmpty()) {
            return MERCHANDISE_TRANSFORM.MerchandiseToMerchandiseDTO(merchandiseRepository.findByProductName(productName));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("fieldEmpty.exception.message"));

    }
}
