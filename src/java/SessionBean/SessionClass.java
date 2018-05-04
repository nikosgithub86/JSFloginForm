package SessionBean;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;



@Stateless
public class SessionClass {
    
    
@PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

 
  public boolean matchUser(String name, String password) {
        boolean result = false;
        User u = null;
        
        try {
            u = em.createNamedQuery("User.findByName", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        
        if (u != null && u.getPassword().equals(password)){
            result = true;
        }
        return result;
    }

}
