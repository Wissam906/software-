package lb.edu.barbershop;
public class Employees {
    private int id;
    private String name;
    public Employees(int id, String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString(){
        return "ID: "+ id +
                "\nName: " + name;
    }
}

