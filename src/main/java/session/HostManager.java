/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import com.mycompany.hosts.monitoring.entities.Host;  
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author majdi
 */
@Stateless
public class HostManager {

    @PersistenceContext(unitName = "hostPU")
    private EntityManager em;
 
    public List<Host> getAllhosts() {
          Query query = em.createNamedQuery("Host.findAll");
       return query.getResultList();
    }
    public Host update(Host host) {
      return em.merge(host);  
    }    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Host host) {
        

        em.persist(host);
            
    }
     public Host getHost(int idHost) {  
  return em.find(Host.class, idHost);  
}
}
