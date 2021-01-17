package com.andrewmcguiness.coachingappapi.domain;

import java.util.Objects;

public abstract class IdEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdEntity entity = (IdEntity) o;
        return getId() != null && Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
