import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    private  String title, description, date, s;
    List<Event> events = new ArrayList<>();
    List<Person> participants = new ArrayList<>();
    Party () {}
    Party(String name)
    {
        title=name;
        description="";
        date="";
    }
    Party(String name, String date)
    {
        title=name;
        description="";
        this.date=date;
    }

    Party(String name, String date, String description)
    {
        title=name;
        this.description=description;
        this.date=date;

    }

    Party(Event e)
    {
        title=e.getTitle();
        description=e.getDescription();
        date=e.getDate();
        for(Person person : e.getParticipants())
        {
            participants.add(person);
        }
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

    public boolean addEvent (Event e)
    {
        for(Event event: events)
        {
            if(event.equals(e))
                return false;
        }
        events.add(e);
        for(Person person : e.getParticipants())
        {
            participants.add(person);
        }
        return true;
    }

    public int getAudienceCount ()
    {
        return participants.size();
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

}

