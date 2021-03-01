package co.com.nxs.automotiveInventory.factories;


import co.com.nxs.automotiveInventory.models.Merchandise;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseDTO;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseUserTransform;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Date;

public class MerchandiseFactory {

    private static final DataFactory dataFactory = new DataFactory();
    private static final MerchandiseUserTransform MERCHANDISE_USER_TRANSFORM = new MerchandiseUserTransform();

    private Long id;

    private String productName;

    private Long amount;

    private Date admissionDate;

    private Date modificationDate;

    private MerchandiseUserDTO idUser;

    public MerchandiseFactory() {
        // Initialize the factory with default values
        this.id = (long) dataFactory.getNumberBetween(4, 10);
        this.productName = dataFactory.getRandomChars(0,50);
        this.amount = (long)  dataFactory.getNumber();
        this.idUser = MerchandiseUserDTO.builder().id((long) dataFactory.getNumberBetween(1, 3)).build();
        this.admissionDate =  dataFactory.getDate(2001,02,5);
        this.modificationDate =  dataFactory.getDate(2001,02,5);
    }

    public Merchandise newInstance() {
        return Merchandise.builder()
                .id(this.id)
                .productName(this.productName)
                .amount(this.amount)
                .idUser(MERCHANDISE_USER_TRANSFORM.MerchandiseUserDTOToMerchandiseUser(this.idUser))
                .admissionDate(this.admissionDate)
                .modificationDate(this.modificationDate)
                .build();
    }

    public MerchandiseDTO newInstanceDto() {
        return MerchandiseDTO.builder()
                .id(this.id)
                .productName(this.productName)
                .amount(this.amount)
                .idUser(this.idUser)
                .admissionDate(this.admissionDate)
                .modificationDate(this.modificationDate)
                .build();
    }

    public MerchandiseFactory setId(Long id) {
        this.id = id;
        return this;
    }

    public MerchandiseFactory setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public MerchandiseFactory setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public MerchandiseFactory setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
        return this;
    }

    public MerchandiseFactory setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public MerchandiseFactory setIdUser(MerchandiseUserDTO idUser) {
        this.idUser = idUser;
        return this;
    }
}
