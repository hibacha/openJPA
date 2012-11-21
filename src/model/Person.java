package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Person database table.
 * 
 */
@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-many association to Photo
	@ManyToMany(mappedBy="persons")
	private List<Photo> photos;

	//bi-directional one-to-one association to Photographer
	@OneToOne(mappedBy="person")
	private Photographer photographer;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photographer getPhotographer() {
		return this.photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

}