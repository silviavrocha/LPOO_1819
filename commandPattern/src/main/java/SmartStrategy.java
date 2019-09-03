import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private boolean isHappyHour;
    List<StringRecipe> orders =new ArrayList<>();
    public void wants(StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour())
            bar.order(recipe);
        else
            orders.add(recipe);
    }

    public void happyHourStarted(Bar bar) {
        isHappyHour=true;
        for(StringRecipe recipe :orders)
            bar.order(recipe);

    }

    public void happyHourEnded(Bar bar) {
        isHappyHour= false;
    }
}