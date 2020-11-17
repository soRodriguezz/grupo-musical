package com.escalab.grupomusical.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "formacion", nullable = false, length = 25)
    private Date formacion;

    @Column(name = "desintegracion", nullable = false, length = 25)
    private Date desintegracion;

    @JoinTable(name="grupo_musico", joinColumns = @JoinColumn(name="idGrupo", nullable = false), inverseJoinColumns = @JoinColumn(name = "idMusico", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Musico> grupoMusico;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFormacion() {
        return formacion;
    }

    public void setFormacion(Date formacion) {
        this.formacion = formacion;
    }

    public Date getDesintegracion() {
        return desintegracion;
    }

    public void setDesintegracion(Date desintegracion) {
        this.desintegracion = desintegracion;
    }

    public List<Musico> getGrupoMusico() {
        return grupoMusico;
    }

    public void setGrupoMusico(List<Musico> grupoMusico) {
        this.grupoMusico = grupoMusico;
    }
}
