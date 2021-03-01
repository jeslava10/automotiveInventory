package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.factories.MerchandiseFactory;
import co.com.nxs.automotiveInventory.models.Merchandise;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseTransform;
import co.com.nxs.automotiveInventory.repositories.MerchandiseRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchandiseServiceUnitTests {

    private Merchandise merchandise;
    private MerchandiseDTO merchandiseDTO;
    private static final MerchandiseTransform MERCHANDISE_TRANSFORM = new MerchandiseTransform();

    @Autowired
    private MerchandiseService merchandiseService;

    @MockBean
    private MerchandiseRepository merchandiseRepository;

    @BeforeEach
    public void setUp(){
        merchandise = new MerchandiseFactory().newInstance();
        merchandiseDTO = MERCHANDISE_TRANSFORM.MerchandiseToMerchandiseDTO(merchandise);
    }


    @Test
    public void testCreateMerchandise() {

        Mockito.when(merchandiseRepository.save(merchandise)).thenReturn(merchandise);
        assertThat(merchandiseService.saveMerchandise(merchandiseDTO)).isEqualTo(merchandise);
    }

    @Test
    public void testUpdateMerchandise() {
        Mockito.when(merchandiseRepository.findById(merchandiseDTO.getId())).thenReturn(Optional.of(merchandise));
        merchandise.setProductName("Camaro 2.0");
        merchandiseDTO.setProductName("Camaro 2.0");
        Mockito.when(merchandiseRepository.save(merchandise)).thenReturn(merchandise);
        assertThat(merchandiseService.updateMerchandise(merchandiseDTO).equals(merchandise));
    }


}

