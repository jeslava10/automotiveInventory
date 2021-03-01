package co.com.nxs.automotiveInventory.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "merchandise")
public class Merchandise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "user id", required = true)
    private Long id;

    @Column(name = "product_name")
    @ApiModelProperty(value = "product name", required = true)
    private String productName;

    @Column(name = "amount")
    @ApiModelProperty(value = "quantity of the product in the warehouse", required = true)
    private Long amount;

    @Column(name = "admission_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "product creation date user")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date admissionDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "product modification date user")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date modificationDate;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ApiModelProperty(value ="product creation  user ", required = true)
    private MerchandiseUser idUser;

}
