/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author camilo
 */
@Named(value = "menuBean")
@RequestScoped
public class MenuBean {

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
    }
    
    public void save(){
        addMessage("Data saved");
    }
    
    public void update() {
        addMessage("Data updated");
    }
     
    public void delete() {
        addMessage("Data deleted");
    }

   public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
