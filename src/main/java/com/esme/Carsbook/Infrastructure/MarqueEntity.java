package com.esme.Carsbook.Infrastructure;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MarqueEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME", length = 20, nullable = false)
    private String name;


}
