package co.usergioarboleda.proyectotiempo.modelo.manager;

import co.usergioarboleda.proyectotiempo.modelo.dao.ActiviDao;
import co.usergioarboleda.proyectotiempo.modelo.vo.Actividad;
import co.usergioarboleda.proyectotiempo.utiles.Utils;

/**
 *
 * @author pc
 */

public class ActivityManager {

    ActiviDao ud = new ActiviDao();
    Actividad u = new Actividad();
    Utils utils = new Utils();

    public String insertActivity(Actividad u) {
        
        ud.insertObject(u);
        return Utils.toJson(u);
        
    }

    /**
     * Método para buscar objeto de usuario que recibe los parametros de correo
     * y contraseña
     *
     * @param correo
     * @param contrasena
     * @return Devuelve un JSON armado con los parametros del objeto ingresado
     */
    public boolean findUser(String correo, String contrasena) {
        
        if (ud.findObject(u) == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Método para buscar objeto de usuario que recibe los parametros de correo
     * y contraseña
     *
     * @param correo
     * @param contrasena
     * @return Devuelve un JSON armado con los parametros del objeto ingresado
     */
    public String updateUser(String correo, String contrasena) {

        ud.updateObject(u);
        return Utils.toJson(u);

    }

    public Actividad getActivityoFromJSon(String s){
    
       
        Actividad u = (Actividad) co.usergioarboleda.proyectotiempo.utiles.Utils.fromJson(s, Actividad.class);
        
        
        return u;
    }
    
    
}


