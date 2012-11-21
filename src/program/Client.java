package program;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Person;
import model.Photographer;




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
	
	public Collection<Photographer> listAllPhotographer(){
		
		Photographer ph= em.find(Photographer.class, 1);
		Query query=em.createQuery("SELECT p.person FROM Photographer p where p.person.name='ee'");
		System.out.println(query.getResultList().size());
		for(Object obj:query.getResultList()){
			
			Person p=(Person)obj;
			
			System.out.println("Name:"+p.getName());
		}
		System.out.println(ph.getId());
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Client c=new Client();
      c.listAllPhotographer();
      
	}

}
