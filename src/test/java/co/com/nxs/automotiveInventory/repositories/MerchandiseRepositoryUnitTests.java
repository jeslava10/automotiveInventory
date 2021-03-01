package co.com.nxs.automotiveInventory.repositories;


import co.com.nxs.automotiveInventory.factories.MerchandiseFactory;
import co.com.nxs.automotiveInventory.models.Merchandise;
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
public class MerchandiseRepositoryUnitTests {

    private Merchandise merchandise;

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @BeforeEach
    public void setUp(){
        merchandise = new MerchandiseFactory().newInstance();
    }

    @Test
    public void testSaveMerchandiseRepository() {

        Merchandise merchandiseSave = merchandiseRepository.save(merchandise);
        Optional<Merchandise> optionalMerchandise = merchandiseRepository.findById(merchandiseSave.getId());

        assertNotNull(optionalMerchandise.get());
        assertEquals(optionalMerchandise.get().getId(), merchandiseSave.getId());
        assertEquals(optionalMerchandise.get().getProductName(), merchandiseSave.getProductName());
    }

    @Test
    public void testUpdateMerchandiseRepository() {

        Merchandise merchandiseSave = merchandiseRepository.save(merchandise);
        merchandiseSave.setProductName("Camaro");

        Merchandise merchandiseUpdate = merchandiseRepository.save(merchandiseSave);
        Optional<Merchandise> optionalMerchandiseUpdate = merchandiseRepository.findById(merchandiseSave.getId());

        assertNotNull(optionalMerchandiseUpdate);
        assertEquals(merchandiseUpdate.getId(), optionalMerchandiseUpdate.get().getId());
        assertEquals(merchandiseUpdate.getProductName(), optionalMerchandiseUpdate.get().getProductName());
    }

    @Test
    public void findAllMerchandiseRepository() {
        Merchandise merchandiseSave = merchandiseRepository.save(merchandise);
        assertNotNull(merchandiseSave);
        assertNotNull(merchandiseRepository.findAll());
    }

    @Test
    public void findByProductNameMerchandiseRepository() {

        Merchandise merchandiseSave = merchandiseRepository.save(merchandise);
        String productName = merchandiseSave.getProductName() ;

        Merchandise merchandiseFind = merchandiseRepository.findByProductName(productName);

        assertNotNull(merchandiseFind);
        assertEquals(merchandiseSave.getId(), merchandiseFind.getId());
        assertEquals(merchandiseSave.getProductName(), merchandiseFind.getProductName());
    }
}