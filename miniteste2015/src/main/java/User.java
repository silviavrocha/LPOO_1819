public class User {
    private String name;
    User(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // are the references equal
        if (o == null) return false; // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        User u = (User) o; // cast the other object
        return (name==u.getName()); // actual comparison
    }
}
