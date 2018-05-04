package managedBean;
import SessionBean.SessionClass;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedBeanClass implements Serializable{

    private String name;
    private String password;
    
    @EJB
   SessionClass sesClas;

    public ManagedBeanClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SessionClass getSesClas() {
        return sesClas;
    }

    public void setSesClas(SessionClass sesClas) {
        this.sesClas = sesClas;
    }
    
 
    
    public void loginUser() {
        
        if (sesClas.matchUser(name, password)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login OK"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Failed"));
        }
    }
    
    
}
