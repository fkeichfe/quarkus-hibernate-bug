package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
public class Account extends AbstractIdEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private UserName userName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<AddressAssignment> addressAssignments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<BookingAssignment> bookingAssignments = new HashSet<>();

}
