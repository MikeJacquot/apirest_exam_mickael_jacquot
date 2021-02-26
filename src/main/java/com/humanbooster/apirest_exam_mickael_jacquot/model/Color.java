package com.humanbooster.apirest_exam_mickael_jacquot.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "color")
public class Color {

    public Color() {
    }

    public Color(String codeRgb, String libelle) {
        this.codeRgb = codeRgb;
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_rgb")
    @NotBlank(message = "ne doit pas etre vide")
    @Pattern(regexp = "\\(\\s*((?:[0-2]?[0-5])?[0-5])\\s*,\\s*((?:[0-2]?[0-5])?[0-5])\\s*,\\s*((?:[0-2]?[0-5])?[0-5])\\s*\\)$",message = "la couleur doit etre au format(xxx,xxx,xxx) et x se trouve entre 0 et 255")
    private String codeRgb;

    @Basic
    @NotBlank(message = "ne doit pas etre vide")
    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeRgb() {
        return codeRgb;
    }

    public void setCodeRgb(String codeRgb) {
        this.codeRgb = codeRgb;
    }
}
