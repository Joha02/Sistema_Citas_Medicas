package logic;

public class Ciudad {
    String ID;
    String name;

    public Ciudad() {
    }

    public Ciudad(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Ciudad{" + "ID=" + ID + ", name=" + name + '}';
    }
    
    
}
