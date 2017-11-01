
package EntityManagers;


import com.mycompany.cos720computersecurityass.CleanInsuranceClaims;
import java.rmi.activation.Activator;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gershom
 */
public class ConcreteDAO<T> implements GenericModelDAO<T> 
{
        
    private static final String PERSISTENCE_UNIT_NAME = "Mains";
    private static EntityManagerFactory factory;
    private static EntityManager em ;
    
    public ConcreteDAO()
    {
    
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    @Override
    public void add(T entityClass) 
    {      
         em.getTransaction().begin(); 
         em.persist(entityClass);
         em.getTransaction().commit();
         em.close();
    }
    @Override
    public void update(T entityClass) 
    {       
         em.getTransaction().begin(); 
         em.persist(entityClass);
         em.getTransaction().commit();
         
    }

    @Override
    public void delete(T entityClass) 
    {
        
         em.getTransaction().begin(); 
         em.remove(entityClass);
         em.getTransaction().commit();
         em.close();
       
    }
    public List<CleanInsuranceClaims> getAllClaims()
    {
        List<CleanInsuranceClaims> list = em.createQuery("SELECT q FROM CleanInsuranceClaims q").getResultList();
        return list;
    }
}
