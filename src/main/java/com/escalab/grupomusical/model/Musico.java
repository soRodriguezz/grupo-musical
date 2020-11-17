package com.escalab.grupomusical.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="musico")
public class Musico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusico;

    @Column(name="nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name="instrumento", nullable = false, length = 20)
    private String instrumento;

    @Column(name="lugarnacimiento", nullable = false, length = 20)
    private String lugarnacimiento;

    @Column(name = "fechanacimiento", nullable = false, length = 20)
    private Date fechanacimiento;

    @ManyToMany(mappedBy = "grupoMusico")
    private List<Grupo> musicoGrupo;

    public Integer getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(Integer idMusico) {
        this.idMusico = idMusico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public List<Grupo> getMusicoGrupo() {
        return musicoGrupo;
    }

    public void setMusicoGrupo(List<Grupo> musicoGrupo) {
        this.musicoGrupo = musicoGrupo;
    }
}