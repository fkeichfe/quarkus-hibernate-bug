package org.example.data;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class AbstractIdEntity {

    @Id
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIdEntity that = (AbstractIdEntity) o;
        if (id != null || that.id != null) {
            return Objects.equals(id, that.id);
        } else {
            return this == that;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
