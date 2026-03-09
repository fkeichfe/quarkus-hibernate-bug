package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Address extends AbstractIdEntity {

    @ManyToOne(optional = false)
    private Store store;

    @OneToOne(optional = true, mappedBy = "address", fetch = FetchType.LAZY)
    private AddressAssignment addressAssignment;

}
