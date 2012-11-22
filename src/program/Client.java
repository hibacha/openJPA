package program;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Person;
import model.Photo;
import model.Photographer;
import model.Specialty;

public class Client {

	private EntityManager em;

	public Client() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test-jpa");
		if (emf == null) {
			throw new IllegalStateException(
					"EntityManagerFactory is unavailable");
		}

		em = emf.createEntityManager();
		if (em == null) {
			throw new IllegalStateException("EntityManager is unavailable");
		}
	}

	public Collection<Photographer> listAllPhotographerShot(String particular) {

		Query query = em
				.createQuery("SELECT p FROM Person p where p.name=:name");
		query.setParameter("name", particular);

		System.out.println("size:" + query.getResultList().size());
		// get person named Mona Lisa
		HashMap<Integer, Photographer> map = new HashMap<Integer, Photographer>();

		for (Object obj : query.getResultList()) {
			Person p = (Person) obj;
			// System.out.println("Name:"+p.getName());
			// System.out.println("size:"+p.getPhotos().size());
			for (Photo photo : p.getPhotos()) {
				Photographer pher = photo.getPhotographer();
				int id = pher.getId();
				// System.out.println("id:"+id);
				System.out.println(isContain(pher.getSpecialties(), "portrait"));
				if (!map.containsKey(id)&&isContain(pher.getSpecialties(), "portrait")) {
					map.put(id, pher);
				}
			}
		}

		return map.values();
	}

	
	public Collection<Person> listAllPersonShotByLoc(String city){
		String queryStr="select p from Photo p where p.photographer.location.city=:city";
		Query query=em.createQuery(queryStr);
		query.setParameter("city", city);
		HashMap<Integer, Person> map=new HashMap<Integer, Person>();
		for(Object obj:query.getResultList()){
			Photo p= (Photo)obj;
			List<Person> persons=p.getPersons();
			for(Person person:persons){
				if(!map.containsKey(person.getId())){
					map.put(person.getId(), person);
				}
			}
		//	System.out.println("id:"+p.getId());
		}
//		int size=query.getResultList().size();
//		System.out.println(size);
		
		return map.values();
		
	}
	public boolean isContain(List<Specialty> listSpec, String specialty) {
		boolean isExist = false;
		for (Specialty s : listSpec) {
			if (s.getId().getType().equals(specialty))
				isExist = true;
			break;
		}
		return isExist;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		Collection<Photographer> phers = c.listAllPhotographerShot("Mona Lisa");
		Iterator<Photographer> iterator = phers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getPerson().getName());
		}
		System.out.println("@@@@@@@@@@");
		Collection<Person> persons=c.listAllPersonShotByLoc("Boston");
        Iterator<Person> iterator2=persons.iterator();
        while(iterator2.hasNext()){
        	System.out.println(iterator2.next().getName());
        }
		
	}

}
