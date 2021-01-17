package com.andrewmcguiness.coachingappapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "area", schema = "coaching")
@SequenceGenerator(name = "areaSequence", sequenceName = "areaSequence", schema = "coaching", initialValue = 1000)
public class AreaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areaSequence")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "area_name")
    private String areaName;

    public AreaEntity() {
    }

    public AreaEntity(Long id, String areaName) {
        this.id = id;
        this.areaName = areaName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String area) {
        this.areaName = area;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaEntity that = (AreaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
