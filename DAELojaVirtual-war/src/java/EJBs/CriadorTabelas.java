/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBs;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author canixe
 */
@Stateless
@LocalBean
@Startup
public class CriadorTabelas {
    
    @PersistenceContext(unitName = "DAELojaVirtual-warPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
