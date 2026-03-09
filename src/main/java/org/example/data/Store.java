package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Store extends AbstractIdEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Booking booking;

}
