public class ImpatientStrategy implements OrderingStrategy {

    private boolean isHappyHour;
    public void wants(StringRecipe recipe, StringBar bar)
    {
        bar.order(recipe);
    }
    public void happyHourStarted(Bar bar)
    {
        isHappyHour= bar.isHappyHour();
    }
    public void happyHourEnded(Bar bar)
    {
        isHappyHour=bar.isHappyHour();
    }
}
