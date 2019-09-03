import java.util.ArrayList;
import java.util.List;

public class Event implements Object {
    private  String title, description, date, s;
    private List<Person> participants = new ArrayList<>();
    Event() {}
    Event(String name)
    {
        title=name;
        description="";
        date="";
    }
    Event(String name, String date)
    {
        title=name;
        description="";
        this.date=date;
    }

    Event(String name, String date, String description)
    {
        title=name;
        this.description=description;
        this.date=date;

    }

    Event(Event e)
    {
        title=e.getTitle();
        description=e.getDescription();
        date=e.getDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public List<Person> getParticipants()
    {
        return participants;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        s= title+" is a "+description+ " and will be held at " +date+".";
        return s;
    }
    public boolean equals(Object e)
    {
        if(this.title==e.getTitle())
        {
            if (this.date == e.getDate())
                if (this.description == e.getDescription())
                    return true;
        }
        return false;
    }

    public boolean addPerson (Person p)
    {
        for(Person person: participants)
        {
            if(person.equals(p))
                return false;
        }
        participants.add(p);
        return true;
    }

    public int getAudienceCount ()
    {
        return participants.size();
    }
}
