package com.humanbooster.apirest_exam_mickael_jacquot.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "car")
public class Car {

    public Car() {
    }

    public Car(String marque, String carburant, Long annee, Long kilometrage, String description) {
        this.marque = marque;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @NotBlank(message = "ne doit pas etre vide")
    private String marque;

    @Basic
    @NotBlank(message = "ne doit pas etre vide")
    private String carburant;

    @Basic
    @NotNull(message = "ne doit pas etre nul")
    private Long annee;

    @Basic
    @NotNull(message = "ne doit pas etre nul")
    private Long kilometrage;

    @Basic
    @NotBlank(message = "ne doit pas etre vide")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public Long getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Long kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
