package logic;

public class Ciudad {
    String name;
    
    public Ciudad() {
    }

    public Ciudad(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ciudad{" + name + "}";
    }
    
    
}
