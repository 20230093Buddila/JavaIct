public class  Ticket {
    private int row;
    private int seat;
    private int price;
    private Person person;

    //constructors
    public Ticket(int row,int seat,int price,Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    //setters
    public void setRow(int row){
        this.row = row;
    }
    public void setSeat(int seat){
        this.seat = seat;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setPerson(Person person){
        this.person = person;
    }
    //getters
    public int getRow(){
        return row;
    }
    public int getSeat(){
        return seat;
    }
    public int getPrice(){
        return price;
    }
    public Person getPerson(){
        return person;
    }

    //method for printing ticket info
    public void ticketInfo(){
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: $" + price);
        System.out.println("Person Information:");
        person.personInfo();
    }

}