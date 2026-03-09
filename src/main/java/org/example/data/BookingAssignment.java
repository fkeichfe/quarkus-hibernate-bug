package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class BookingAssignment extends AbstractIdEntity {

    @ManyToOne(optional = false)
    private Account account;

    @ManyToOne(optional = false)
    private Booking booking;

}
