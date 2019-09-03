public class StringBar extends Bar{
    private boolean isHappyHour;
    StringBar()
    {
        isHappyHour=false;
    }

    public boolean isHappyHour()
    {
        return isHappyHour;
    }

    public void startHappyHour()
    {
        isHappyHour=true;
        notifyObservers();
    }

    public void endHappyHour()
    {
        isHappyHour=false;
        notifyObservers();
    }

    public void order( StringRecipe s)
    {
        s.mix();
    }

}
