package com.andrewmcguiness.coachingappapi.dto;

import java.io.Serializable;

public class AreaDto implements Serializable {
    private Long id;
    private String areaName;

    public AreaDto() {
    }

    public AreaDto(Long id, String areaName) {
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


}
