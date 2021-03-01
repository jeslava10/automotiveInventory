package co.com.nxs.automotiveInventory.services;

import co.com.nxs.automotiveInventory.factories.MerchandiseUserFactory;
import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseUserTransform;
import co.com.nxs.automotiveInventory.repositories.MerchandiseUserRepository;
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
public class MerchandiseUserServiceUnitTests {

    private MerchandiseUser merchandiseUser;
    private MerchandiseUserDTO merchandiseUserDTO;
    private static final MerchandiseUserTransform MERCHANDISE_USER_TRANSFORM = new MerchandiseUserTransform();

    @Autowired
    private MerchandiseUserService merchandiseUserService;

    @MockBean
    private MerchandiseUserRepository merchandiseUserRepository;

    @BeforeEach
    public void setUp(){
        merchandiseUser = new MerchandiseUserFactory().newInstance();
        merchandiseUserDTO = MERCHANDISE_USER_TRANSFORM.MerchandiseUserToMerchandiseUserDTO(merchandiseUser);
    }


    @Test
    public void testCreateMerchandiseUser() {

        Mockito.when(merchandiseUserRepository.save(merchandiseUser)).thenReturn(merchandiseUser);
        assertThat(merchandiseUserService.saveMerchandiseUser(merchandiseUserDTO)).isEqualTo(merchandiseUser);
    }

    @Test
    public void testUpdateMerchandiseUser() {
        Mockito.when(merchandiseUserRepository.findById(merchandiseUserDTO.getId())).thenReturn(Optional.of(merchandiseUser));
        merchandiseUser.setName("Carlos montana");
        merchandiseUserDTO.setName("Carlos montana");
        Mockito.when(merchandiseUserRepository.save(merchandiseUser)).thenReturn(merchandiseUser);
        Mockito.when(merchandiseUserRepository.save(merchandiseUser)).thenReturn(merchandiseUser);
        assertThat(merchandiseUserService.updateMerchandiseUser(merchandiseUserDTO).equals(merchandiseUser));
    }


}

