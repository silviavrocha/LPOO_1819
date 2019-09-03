public class HumanClient implements Client {
    OrderingStrategy strategy;
    private boolean isHappyHour;
    HumanClient(OrderingStrategy strategy)
    {
        this.strategy=strategy;
    }
    public void wants(StringRecipe recipe, StringBar bar)
    {
        strategy.wants(recipe, bar);
    }

    public void happyHourStarted(Bar bar)
    {
        strategy.happyHourStarted(bar);
    }

    public void happyHourEnded(Bar bar)
    {
        strategy.happyHourEnded(bar);
    }
}
