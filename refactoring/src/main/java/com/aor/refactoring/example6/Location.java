package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Location {
    private String latitude;
    private String longitude;
    private String name;

    public Location(String locationLatitude, String locationLongitude, String locationName){
        this.latitude = locationLatitude;
        this.longitude= locationLongitude;
        this.name= locationName;
    }
    public String toString() {
        return (this.latitude + "," + this.longitude + " (" + this.name + ")");
    }

    public String getLatitude()
    {
        return latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getName()
    {
        return name;
    }
}
