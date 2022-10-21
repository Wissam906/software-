package lb.edu.barbershop;
public class Booking {
    private int number;
    private String name;
    private String time;
    private int barberid;
    public Booking(int number, String name, String time, int barberid){
        this.number=number;
        this.name=name;
        this.time=time;
        this.barberid=barberid;
    }
    @Override
    public String toString(){
        return "Number: "+ number +
                "\nName: " + name +
                "\nTime: " + time +
                "\nBarber ID: " + barberid ;
    }
}

