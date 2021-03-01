package co.com.nxs.automotiveInventory.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "merchandise_user")
public class MerchandiseUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "user id", required = true)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "name user", required = true)
    private String name;

    @Column(name = "age")
    @ApiModelProperty(value = "age user", required = true)
    private Long age;

    @OneToOne
    @JoinColumn(name = "id_appointment", referencedColumnName = "id")
    @ApiModelProperty(value ="code of the position in the company", required = true)
    private Appointment idAppointment;

    @Column(name = "cia_admission_date")
    @ApiModelProperty(value = "date of entry to the company")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date admissionDate;

}
