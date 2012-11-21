package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Specialty database table.
 * 
 */
@Entity
public class Specialty implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SpecialtyPK id;

	//bi-directional many-to-one association to Photographer
	@ManyToOne
	@JoinColumn(name="photographer")
	private Photographer photographerBean;

	public Specialty() {
	}

	public SpecialtyPK getId() {
		return this.id;
	}

	public void setId(SpecialtyPK id) {
		this.id = id;
	}

	public Photographer getPhotographerBean() {
		return this.photographerBean;
	}

	public void setPhotographerBean(Photographer photographerBean) {
		this.photographerBean = photographerBean;
	}

}