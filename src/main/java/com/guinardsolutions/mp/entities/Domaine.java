/**
 * 
 */
package com.guinardsolutions.mp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Domaine.
 *
 * @author Paul
 */
@Entity
@Table(name = "domaines")
public class Domaine extends AbstractDomaine implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1790193507158697081L;

	/** The competences. */
	@OneToMany(mappedBy = "abstractDomaine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AbstractDomaine> abstractDomaines;

	/**
	 * Instantiates a new domaine.
	 */
	public Domaine() {
		super();
	}

	/**
	 * Instantiates a new domaine.
	 *
	 * @param abstractDomaines
	 *            the abstract domaines
	 */
	public Domaine(List<AbstractDomaine> abstractDomaines) {
		super();
		this.abstractDomaines = abstractDomaines;
	}

	/**
	 * Instantiates a new domaine.
	 *
	 * @param ref
	 *            the ref
	 * @param description
	 *            the description
	 * @param cycle
	 *            the cycle
	 * @param abstractDomaine
	 *            the abstract domaine
	 */
	public Domaine(String ref, String description, String cycle, AbstractDomaine abstractDomaine) {
		super(ref, description, cycle, abstractDomaine);
	}

	/**
	 * Gets the abstract domaines.
	 *
	 * @return the abstractDomaines
	 */
	public List<AbstractDomaine> getAbstractDomaines() {
		return abstractDomaines;
	}

	/**
	 * Sets the abstract domaines.
	 *
	 * @param abstractDomaines
	 *            the abstractDomaines to set
	 */
	public void setAbstractDomaines(List<AbstractDomaine> abstractDomaines) {
		this.abstractDomaines = abstractDomaines;
	}

	/**
	 * Adds the abstract domaine.
	 *
	 * @param abstractDomaine
	 *            the abstract domaine
	 */
	public void addAbstractDomaine(AbstractDomaine abstractDomaine) {
		abstractDomaines.add(abstractDomaine);
		abstractDomaine.setAbstractDomaine(this);
	}

	/**
	 * Removes the abstract domaine.
	 *
	 * @param abstractDomaine
	 *            the abstract domaine
	 */
	public void removeAbstractDomaine(AbstractDomaine abstractDomaine) {
		abstractDomaines.remove(abstractDomaine);
		abstractDomaine.setAbstractDomaine(null);
	}

}
