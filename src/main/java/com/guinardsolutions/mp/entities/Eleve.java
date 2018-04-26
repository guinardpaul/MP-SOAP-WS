/**
 * 
 */
package com.guinardsolutions.mp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Eleve object.
 *
 * @author Paul
 */
@Entity
@Table(name = "eleves")
public class Eleve implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5039096999369173703L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The first name. */
	@Column(name = "first_name")
	private String firstname;

	/** The last name. */
	@Column(name = "last_name")
	private String lastname;

	/** The classe. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classe_id")
	private Classe classe;

	/** The resultats. */
	@OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Resultat> resultats;

	/**
	 * Instantiates a new eleve.
	 */
	public Eleve() {
		super();
	}

	/**
	 * Instantiates a new eleve.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 */
	public Eleve(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * Instantiates a new eleve.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param resultats
	 *            the resultats
	 */
	public Eleve(String firstname, String lastname, List<Resultat> resultats) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.resultats = resultats;
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the resultats.
	 *
	 * @return the resultats
	 */
	public List<Resultat> getResultats() {
		return resultats;
	}

	/**
	 * Sets the resultats.
	 *
	 * @param resultats
	 *            the resultats to set
	 */
	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}

	/**
	 * Gets the classe.
	 *
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * Sets the classe.
	 *
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
