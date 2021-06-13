/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import com.mycompany.hosts.monitoring.entities.Host;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import session.HostManager;
/**
 *
 * @author majdi
 */
@Named(value = "hostMBean")
@ViewScoped
public class HostMBean implements Serializable {
    private List<Host> hostList; 
    @EJB
    private HostManager hostManager;
    /** 
   * Retourne la liste des hosts pour affichage dans une DataTable 
   * @return 
   */  
    public List<Host> getHosts() {
      if (hostList == null) {
        hostList = hostManager.getAllhosts();
      }
      return hostList;
    }  
    /**
     * Creates a new instance of HostMBean
     */
   
    
    public HostMBean() { }
           
  
}
