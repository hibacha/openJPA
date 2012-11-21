package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Photographer database table.
 * 
 */
@Entity
public class Photographer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="photographer")
	private List<Photo> photos;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="livesIn")
	private Location location;

	//bi-directional one-to-one association to Person
	@OneToOne
	@JoinColumn(name="id")
	private Person person;

	//bi-directional many-to-one association to Specialty
	@OneToMany(mappedBy="photographerBean")
	private List<Specialty> specialties;

	public Photographer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Specialty> getSpecialties() {
		return this.specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}

}