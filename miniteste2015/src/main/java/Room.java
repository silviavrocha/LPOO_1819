import java.util.ArrayList;
import java.util.List;

public class Room implements Facility {
    private String name, number;
    private int floor, capacity;
    private Building building;
    private List<User> usersAllowed = new ArrayList<>();
    Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        if(building.getMaxFloor()<floor || building.getMinFloor()>floor)
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.name = building.getName() + number;
        this.capacity=0;
        building.addRoom(this);
    }

    Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        if(building.getMaxFloor()<floor || building.getMinFloor()>floor)
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.name = building.getName() + number;
        this.capacity=capacity;
        building.addRoom(this);
    }


    public String getName() {
        return name;
    }

    public void authorize(User u1) {
        usersAllowed.add(u1);
    }

    @Override
    public boolean canEnter(User u1)
    {
        for(User user : usersAllowed)
            if(user.equals(u1))
                return true;
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Room(" +building.getName() + "," +number + ")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // are the references equal
        if (o == null) return false; // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        Room r = (Room) o; // cast the other object
        return (name.equals(r.getName())); // actual comparison
    }
}