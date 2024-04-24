package kz.iitu.taskrestphoenix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "object_request")
@Data
public class ObjectRequest extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;

}
