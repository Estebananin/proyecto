package co.usergioarboleda.proyectotiempo.modelo.dao;

import javax.persistence.EntityManager;

import co.usergioarboleda.proyectotiempo.modelo.manager.EMF;
import co.usergioarboleda.proyectotiempo.modelo.vo.Actividad;

public class ActiviDao {

	public EntityManager em = null;

	public boolean insertObject(Actividad p) {

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

	public boolean findObject(Actividad p) {

		try {
			em = EMF.get().createEntityManager();
			em.getTransaction().begin();
			em.find(Actividad.class, p.getNombre());
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
	
public boolean updateObject(Actividad p) {
		
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
