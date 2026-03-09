package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class AddressAssignment extends AbstractIdEntity {

    @OneToOne
    private UserName userName;

    @OneToOne
    private Address address;

    @ManyToOne(optional = false)
    private Booking booking;

    @ManyToOne(optional = false)
    private Account account;

}
