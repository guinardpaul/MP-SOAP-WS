package com.guinardsolutions.mp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Classe.
 *
 * @author Paul
 */
@Entity
@Table(name = "classes")
public class Classe implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 723131842951989579L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name.
     */
    @Column(name = "classe_name")
    private String name;

    /**
     * The cycle.
     */
    @Column(name = "classe_cycle")
    private String cycle;

    /**
     * The eleves.
     */
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Eleve> eleves;

    /**
     * Instantiates a new classe.
     */
    public Classe() {
        super();
    }

    /**
     * Instantiates a new classe.
     *
     * @param name the name
     * @param cycle the cycle
     */
    public Classe(String name, String cycle) {
        super();
        this.name = name;
        this.cycle = cycle;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the cycle.
     *
     * @return the cycle
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * Sets the cycle.
     *
     * @param cycle the new cycle
     */
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     * Gets the eleves.
     *
     * @return the eleves
     */
    public List<Eleve> getEleves() {
        return eleves;
    }

    /**
     * Sets the eleves.
     *
     * @param eleves the new eleves
     */
    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    /**
     * Adds the eleves.
     *
     * @param eleve the eleve
     */
    public void addEleves(Eleve eleve) {
        eleves.add(eleve);
        eleve.setClasse(this);
    }

    /**
     * Removes the eleve.
     *
     * @param eleve the eleve
     */
    public void removeEleve(Eleve eleve) {
        eleves.remove(eleve);
        eleve.setClasse(null);
    }

}
