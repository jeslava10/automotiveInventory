package co.com.nxs.automotiveInventory.models;


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
import javax.persistence.Table;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "appointment id ", required = true)
    private Long id;

    @Column(name = "description")
    @ApiModelProperty(value = "appointment description ", required = true)
    private String description;


}
