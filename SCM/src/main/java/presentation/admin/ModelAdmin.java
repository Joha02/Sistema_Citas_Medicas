package presentation.admin;

import logic.Admin;

public class ModelAdmin {
    Admin current;
    
    public ModelAdmin() {
        this.reset();
    }
    
    public void reset(){
        setAdmin(new Admin());        
    }
    
    public Admin getAdmin() {
        return current;
    }

    public void setAdmin(Admin current) {
        this.current = current;
    }    
}
