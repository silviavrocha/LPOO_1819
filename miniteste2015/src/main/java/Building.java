import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {

    private String name;
    private int minFloor, maxFloor, capacity;
    private List<Room> rooms = new ArrayList<>();
    Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException
    {

        if(maxFloor<minFloor)
            throw new IllegalArgumentException();
        this.name=name;
        this.minFloor=minFloor;
        this.maxFloor=maxFloor;
        capacity=0;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean canEnter(User u1)
    {
        for(Room room : rooms)
            if(room.canEnter(u1))
                return true;
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    @Override
    public String toString() {
        return "Building(" +name+ ")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addRoom(Room r) throws DuplicateRoomException{
        for(Room room : rooms)
        {
      //      System.out.println(room.getName());
        //    System.out.println(r.getName());
            if(room.equals(r))
                throw new DuplicateRoomException();
        }

        this.capacity+=r.getCapacity();
        rooms.add(r);
     //   System.out.println(rooms.size());
    }

}
