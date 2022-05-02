package logic;

public class Ciudad {
    String name;
    
    public Ciudad() {
    }

    public Ciudad(String name) {
        this.name = name;
    }
    
    public String getCiudad() {
        return name;
    }

    public void setCiudad(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ciudad{" + name + "}";
    }
    
    
}
