package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Specialty database table.
 * 
 */
@Embeddable
public class SpecialtyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int photographer;

	private String type;

	public SpecialtyPK() {
	}
	public int getPhotographer() {
		return this.photographer;
	}
	public void setPhotographer(int photographer) {
		this.photographer = photographer;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SpecialtyPK)) {
			return false;
		}
		SpecialtyPK castOther = (SpecialtyPK)other;
		return 
			(this.photographer == castOther.photographer)
			&& this.type.equals(castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.photographer;
		hash = hash * prime + this.type.hashCode();
		
		return hash;
	}
}