package com.sudria.demo.infrastructure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "MARQUE", length = 50, nullable = false)
  private String marque;
  @Column(name = "MODELE", length = 50, nullable = false)
  private String modele;
  @Column(name = "CATEGORIE", length = 50, nullable = false)
  private String categorie;
  @Column(name = "SUPERVISEUR", length = 50, nullable = false)
  private String superviseur;
}
