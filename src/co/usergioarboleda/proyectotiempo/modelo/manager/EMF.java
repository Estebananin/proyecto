package co.usergioarboleda.proyectotiempo.modelo.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author esteban_lopez
 */

public final class EMF {
	
	private static EntityManagerFactory emfInstance;
        private static final String Selftime = "Selftime";
	
	public static EntityManagerFactory get() {
            if (emfInstance == null) {
                emfInstance = Persistence.createEntityManagerFactory(Selftime);
            }
            
            return emfInstance;
	}

        public static void shutdown(){
            if (emfInstance != null) {
                emfInstance.close();
            }
        }
        
        
}