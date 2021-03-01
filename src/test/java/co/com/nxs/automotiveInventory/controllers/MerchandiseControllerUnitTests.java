package co.com.nxs.automotiveInventory.controllers;


import co.com.nxs.automotiveInventory.factories.MerchandiseFactory;
import co.com.nxs.automotiveInventory.models.Merchandise;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseTransform;
import co.com.nxs.automotiveInventory.services.MerchandiseService;
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
public class MerchandiseControllerUnitTests {

    private Merchandise merchandise;
    private MerchandiseDTO merchandiseDTO;
    private static final MerchandiseTransform MERCHANDISE_TRANSFORM = new MerchandiseTransform();

    @Autowired
    private MerchandiseService merchandiseService;

    @BeforeEach
    public void setUp(){
        merchandise = new MerchandiseFactory().newInstance();
        merchandiseDTO = MERCHANDISE_TRANSFORM.MerchandiseToMerchandiseDTO(merchandise);
    }

    @Test
    public void saveMerchandise() {

        MerchandiseDTO merchandiseDTOSave =  merchandiseService.saveMerchandise(merchandiseDTO);
        assertNotNull(merchandiseDTOSave);
        assertEquals(merchandiseDTOSave.getId(), merchandiseDTO.getId());
        assertEquals(merchandiseDTOSave.getProductName(), merchandiseDTO.getProductName());
    }

    @Test
    public void UpdateMerchandise() {

        MerchandiseDTO merchandiseDTOUpdate =  merchandiseService.saveMerchandise(merchandiseDTO);
        assertNotNull(merchandiseDTOUpdate);
        assertEquals(merchandiseDTOUpdate.getId(), merchandiseDTO.getId());

    }

    @Test
    public void findAllMerchandise() {
        List<MerchandiseDTO> merchandiseDTOList = merchandiseService.findAllMerchandise();
        assertNotNull(merchandiseDTOList);
        assertEquals(merchandiseDTOList.get(2).getId(), merchandiseDTO.getId());
        assertEquals(merchandiseDTOList.get(2).getProductName(), merchandiseDTO.getProductName());
    }

}
