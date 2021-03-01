package co.com.nxs.automotiveInventory.controllers;


import co.com.nxs.automotiveInventory.factories.MerchandiseUserFactory;
import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseUserTransform;
import co.com.nxs.automotiveInventory.services.MerchandiseUserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchandiseUserControllerUnitTests {

    private MerchandiseUser merchandiseUser;
    private MerchandiseUserDTO merchandiseUserDTO;
    private static final MerchandiseUserTransform MERCHANDISE_USER_TRANSFORM = new MerchandiseUserTransform();

    @Autowired
    private MerchandiseUserService merchandiseUserService;

    @BeforeEach
    public void setUp(){
        merchandiseUser = new MerchandiseUserFactory().newInstance();
        merchandiseUserDTO = MERCHANDISE_USER_TRANSFORM.MerchandiseUserToMerchandiseUserDTO(merchandiseUser);
    }

    @Test
    public void saveMerchandiseUser() {

        MerchandiseUserDTO merchandiseUserDTOSave =  merchandiseUserService.saveMerchandiseUser(merchandiseUserDTO);
        assertNotNull(merchandiseUserDTOSave);
        assertEquals(merchandiseUserDTOSave.getId(), merchandiseUserDTO.getId());
        assertEquals(merchandiseUserDTOSave.getName(), merchandiseUserDTO.getName());
    }

    @Test
    public void UpdateMerchandiseUser() {

        MerchandiseUserDTO merchandiseUserDTOUpdate =  merchandiseUserService.saveMerchandiseUser(merchandiseUserDTO);
        assertNotNull(merchandiseUserDTOUpdate);
        assertEquals(merchandiseUserDTOUpdate.getId(), merchandiseUserDTO.getId());

    }

    @Test
    public void findAllMerchandiseUser() {
        List<MerchandiseUserDTO> merchandiseUserDTOList = merchandiseUserService.findAllMerchandiseUser();
        assertNotNull(merchandiseUserDTOList);
        assertEquals(merchandiseUserDTOList.get(2).getId(), merchandiseUserDTO.getId());
        assertEquals(merchandiseUserDTOList.get(2).getName(), merchandiseUserDTO.getName());
    }

}
