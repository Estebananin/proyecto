package co.usergioarboleda.proyectotiempo.modelo.dao;

import javax.persistence.EntityManager;

import co.usergioarboleda.proyectotiempo.modelo.manager.EMF;
import co.usergioarboleda.proyectotiempo.modelo.vo.Usuario;


public class UserDao {

	public EntityManager em = null;

	/**
	 * Método para insertar objeto de usuario que recibe un usuario del Manager
	 * e inserta el objeto.
	 * 
	 * @param Usuario p
	 * @return Devuelve la persistencia del usuario
	 */
	public boolean insertObject(Usuario p) {

		try {
			em = EMF.get().createEntityManager();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.refresh(p);
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (em != null && em.isOpen())
				em.close();

		}
	}
	
	
	/**
	 * Método para encontrar objeto de usuario que recibe un usuario del Manager
	 * para buscar 
	 * 
	 * @param Usuario p
	 * @return Devuelve un booleano con la busqueda del usuario
	 */
	public boolean findObject(Usuario p) {

		try {
			em = EMF.get().createEntityManager();
			em.getTransaction().begin();
			em.find(Usuario.class, p.getCorreo());
			em.getTransaction().commit();
			em.refresh(p);
			em.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (em != null && em.isOpen())
				em.close();

		}

	}
	
	/**
	 * Método para encontrar objeto de usuario que recibe un usuario del Manager
	 * para buscar 
	 * 
	 * @param Usuario p
	 * @return Devuelve un booleano con la busqueda del usuario
	 */
	public boolean updateObject(Usuario p) {
		
		try {
			em = EMF.get().createEntityManager();
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			em.refresh(p);
			em.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (em != null && em.isOpen())
				em.close();

		}
		
	
	}
	
	

}
