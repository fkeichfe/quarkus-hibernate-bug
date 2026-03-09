package org.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class UserName extends AbstractIdEntity {

    @OneToOne(mappedBy = "userName", fetch = FetchType.LAZY)
    private Account device;

    @OneToOne(mappedBy = "userName", fetch = FetchType.LAZY)
    private AddressAssignment addressAssignment;

    public Account getDevice() {
        return device;
    }

    public void setDevice(Account device) {
        this.device = device;
    }

    public AddressAssignment getAddressAssignment() {
        return addressAssignment;
    }

    public void setAddressAssignment(AddressAssignment addressAssignment) {
        this.addressAssignment = addressAssignment;
    }

}
