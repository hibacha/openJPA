package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Photo database table.
 * 
 */
@Entity
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp takenAt;

	private String type;

	//bi-directional many-to-many association to Person
	@ManyToMany
	@JoinTable(
		name="Appearance"
		, joinColumns={
			@JoinColumn(name="isShownIn")
			}
		, inverseJoinColumns={
			@JoinColumn(name="shows")
			}
		)
	private List<Person> persons;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="photographedAt")
	private Location location;

	//bi-directional many-to-one association to Photographer
	@ManyToOne
	@JoinColumn(name="takenBy")
	private Photographer photographer;

	public Photo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTakenAt() {
		return this.takenAt;
	}

	public void setTakenAt(Timestamp takenAt) {
		this.takenAt = takenAt;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Photographer getPhotographer() {
		return this.photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

}