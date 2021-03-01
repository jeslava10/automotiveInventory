package co.com.nxs.automotiveInventory.repositories;


import co.com.nxs.automotiveInventory.factories.MerchandiseUserFactory;
import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MerchandiseUserRepositoryUnitTests {

    private MerchandiseUser merchandiseUser;

    @Autowired
    private MerchandiseUserRepository merchandiseUserRepository;

    @BeforeEach
    public void setUp(){
        merchandiseUser = new MerchandiseUserFactory().newInstance();
    }

    @Test
    public void testSaveMerchandiseUserRepository() {

        MerchandiseUser merchandiseUserSave = merchandiseUserRepository.save(merchandiseUser);
        Optional<MerchandiseUser> optionalMerchandiseUser = merchandiseUserRepository.findById(merchandiseUserSave.getId());

        assertNotNull(optionalMerchandiseUser.get());
        assertEquals(optionalMerchandiseUser.get().getId(), merchandiseUserSave.getId());
        assertEquals(optionalMerchandiseUser.get().getName(), merchandiseUserSave.getName());
    }

    @Test
    public void testUpdateMerchandiseUserRepository() {

        MerchandiseUser merchandiseUserSave = merchandiseUserRepository.save(merchandiseUser);
        merchandiseUserSave.setName("Carlos montaner");

        MerchandiseUser merchandiseUserUpdate = merchandiseUserRepository.save(merchandiseUserSave);
        Optional<MerchandiseUser> optionalMerchandiseUserUpdate = merchandiseUserRepository.findById(merchandiseUserSave.getId());

        assertNotNull(optionalMerchandiseUserUpdate);
        assertEquals(merchandiseUserUpdate.getId(), optionalMerchandiseUserUpdate.get().getId());
        assertEquals(merchandiseUserUpdate.getName(), optionalMerchandiseUserUpdate.get().getName());
    }

    @Test
    public void findAllMerchandiseUserRepository() {
        MerchandiseUser merchandiseUserSave = merchandiseUserRepository.save(merchandiseUser);
        assertNotNull(merchandiseUserSave);
        assertNotNull(merchandiseUserRepository.findAll());
    }

}