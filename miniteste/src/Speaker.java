public class Speaker implements Person {
    private String name;
    private int age, fee;
    Speaker(String name)
    {
        this.name=name;
        this.age=0;
    }

    Speaker(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public String toString()
    {
        String s= "Speaker "+ name +" as a fee value of "+ fee +".";
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
