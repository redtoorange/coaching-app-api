package com.andrewmcguiness.coachingappapi.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "area", schema = "coaching")
@SequenceGenerator(name = "areaSequence", sequenceName = "areaSequence", schema = "coaching", initialValue = 1000)
public class AreaEntity extends IdEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areaSequence")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "area_name")
    private String areaName;
}
