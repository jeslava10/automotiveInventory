package co.com.nxs.automotiveInventory.factories;


import co.com.nxs.automotiveInventory.models.Appointment;
import co.com.nxs.automotiveInventory.models.dtos.AppointmentDTO;
import org.fluttercode.datafactory.impl.DataFactory;

public class AppointmentFactory {

    private static final DataFactory dataFactory = new DataFactory();

    private Long id;
    private String description;


    public AppointmentFactory() {
        // Initialize the factory with default values
        this.id = (long) dataFactory.getNumberBetween(1, 10);
        this.description = dataFactory.getBusinessName();

    }

    public Appointment newInstance() {
        return Appointment.builder()
                .id(this.id)
                .description(this.description)
                .build();
    }

    public AppointmentDTO newInstanceDto() {
        return AppointmentDTO.builder()
                .id(this.id)
                .description(this.description)
                .build();
    }

    public AppointmentFactory setId(Long id) {
        this.id = id;
        return this;
    }

    public AppointmentFactory setDescription(String description) {
        this.description = description;
        return this;
    }
}
