/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import com.mycompany.hosts.monitoring.entities.Host;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.HostManager;

/**
 *
 * @author majdi
 */
@Named(value = "hostDetailsMBean")
@ViewScoped
public class HostDetailsMBean implements Serializable {
    private int idHost;
    private Host host;
     @EJB
    private HostManager hostManager;

  public int getIdHost() {
    return idHost;
  }

  public void setIdHost(int idHost) {
    this.idHost = idHost;
  }

  /**
   * Retourne les détails du client courant (celui dans l'attribut customer de
   * cette classe), qu'on appelle une propriété (property)
   */
    public Host getDetails() {
      return host;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à host.
    host = hostManager.update(host);
    return "HostList";
  }

  public void loadHost() {
    this.host = hostManager.getHost(idHost);
  }

    /**
     * Creates a new instance of HostDetailsMBean
     */
    public HostDetailsMBean() {
    }
    
}
