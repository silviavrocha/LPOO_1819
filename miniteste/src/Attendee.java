public class Attendee implements Person{
    private String name;
    private int age, fee;
    private boolean hasPaid;
    Attendee(String name)
    {
        this.name=name;
        this.age=0;
        hasPaid=false;
    }

    Attendee(String name, int age)
    {
        this.name=name;
        this.age=age;
        hasPaid=false;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public boolean hasPaid()
    {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public String toString()
    {
        String s= "Attendee "+ name +(hasPaid() ? " has":" hasn't")+" paid its registration.";
        return s;
    }

    public boolean equals(Person p)
    {
        if(this.name==p.getName())
            return true;
        return false;
    }

    @Override
    public String getUsername() {
        return (name+age);
    }
}
