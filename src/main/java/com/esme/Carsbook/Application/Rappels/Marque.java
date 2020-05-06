package com.esme.Carsbook.Application.Rappels;


import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Marque {
    private int ID;
    private String nom;
    private int prix;
    private float taille;
    private char modèle;
    private boolean A;
    private LocalDate sortie;
}
