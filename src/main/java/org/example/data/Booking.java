package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking extends AbstractIdEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    private Set<Store> stores = new HashSet<>();

}
