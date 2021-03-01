package co.com.nxs.automotiveInventory.factories;


import co.com.nxs.automotiveInventory.models.MerchandiseUser;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import co.com.nxs.automotiveInventory.models.dtos.MerchandiseUserDTO;
import co.com.nxs.automotiveInventory.models.transforms.AppointmentTransform;
import co.com.nxs.automotiveInventory.models.transforms.MerchandiseUserTransform;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Date;

public class MerchandiseUserFactory {

    private static final DataFactory dataFactory = new DataFactory();
    private static final AppointmentTransform APPOINTMENT_TRANSFORM = new AppointmentTransform();

    private Long id;

    private String name;

    private Long age;

    private AppointmentDTO idAppointment;

    private Date admissionDate;


    public MerchandiseUserFactory() {
        // Initialize the factory with default values
        this.id = (long) dataFactory.getNumberBetween(4, 10);
        this.name = dataFactory.getName();
        this.age = (long)  dataFactory.getNumber();
        this.idAppointment = AppointmentDTO.builder().id((long) dataFactory.getNumberBetween(1, 3)).build();
        this.admissionDate =  dataFactory.getDate(2001,02,5);

    }

    public MerchandiseUser newInstance() {
        return MerchandiseUser.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .idAppointment(APPOINTMENT_TRANSFORM.AppointmentDtoToAppointment(this.idAppointment))
                .admissionDate(this.admissionDate)
                .build();
    }

    public MerchandiseUserDTO newInstanceDto() {
        return MerchandiseUserDTO.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .idAppointment(this.idAppointment)
                .admissionDate(this.admissionDate)
                .build();
    }

    public MerchandiseUserFactory setId(Long id) {
        this.id = id;
        return this;
    }

    public MerchandiseUserFactory setName(String name) {
        this.name = name;
        return this;
    }

    public MerchandiseUserFactory setAge(Long age) {
        this.age = age;
        return this;
    }

    public MerchandiseUserFactory setIdAppointment(AppointmentDTO idAppointment) {
        this.idAppointment = idAppointment;
        return this;
    }

    public MerchandiseUserFactory setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
        return this;
    }
}
