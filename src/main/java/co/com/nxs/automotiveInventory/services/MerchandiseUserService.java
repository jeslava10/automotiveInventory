package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.exceptions.ResourceNotFoundException;
import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseUserTransform;
import co.com.nxs.automotiveInventory.repositories.MerchandiseUserRepository;
import co.com.nxs.automotiveInventory.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MerchandiseUserService {

    private static final MerchandiseUserTransform MERCHANDISE_USER_TRANSFORM = new MerchandiseUserTransform();

    private final MerchandiseUserRepository merchandiseUserRepository;
    private  final MessageUtil messageUtil;

    @Autowired
    public MerchandiseUserService(MerchandiseUserRepository merchandiseUserRepository,
                                  MessageUtil messageUtil) {
        this.merchandiseUserRepository = merchandiseUserRepository;
        this.messageUtil = messageUtil;

    }

    public MerchandiseUserDTO saveMerchandiseUser(MerchandiseUserDTO merchandiseUserDTO) {

        if (merchandiseUserDTO != null) {

            MerchandiseUser merchandiseUser = MerchandiseUser.builder()
                    .id(merchandiseUserDTO.getId())
                    .name(merchandiseUserDTO.getName())
                    .age(merchandiseUserDTO.getAge())
                    .admissionDate(merchandiseUserDTO.getAdmissionDate())
                    .idAppointment(Appointment.builder().id(merchandiseUserDTO.getIdAppointment().getId()).build())
                    .build();

            return MERCHANDISE_USER_TRANSFORM.MerchandiseUserToMerchandiseUserDTO(merchandiseUserRepository.save(merchandiseUser));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));
    }

    public MerchandiseUserDTO updateMerchandiseUser(MerchandiseUserDTO merchandiseUserDTO) {

        if (merchandiseUserDTO != null) {

            MerchandiseUser merchandiseUser = MerchandiseUser.builder()
                    .id(merchandiseUserDTO.getId())
                    .name(merchandiseUserDTO.getName())
                    .age(merchandiseUserDTO.getAge())
                    .admissionDate(merchandiseUserDTO.getAdmissionDate())
                    .idAppointment(Appointment.builder().id(merchandiseUserDTO.getIdAppointment().getId()).build())
                    .build();

            return MERCHANDISE_USER_TRANSFORM.MerchandiseUserToMerchandiseUserDTO(merchandiseUserRepository.save(merchandiseUser));
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("dto.null.exception.message"));

    }

    public List<MerchandiseUserDTO> findAllMerchandiseUser() {
        return merchandiseUserRepository.findAll().stream()
                .map(MERCHANDISE_USER_TRANSFORM::MerchandiseUserToMerchandiseUserDTO)
                .collect(Collectors.toList());
    }

    public String deleteMerchandiseUser(Long id) {

        if (id != null) {
            merchandiseUserRepository.deleteById(id);
            return messageUtil.resolveMessageSource("successful.delete.message");
        }
        throw new ResourceNotFoundException(messageUtil.resolveMessageSource("fieldEmpty.exception.message"));

    }
}
