import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformers;
    StringRecipe(List<StringTransformer> transformers)
    {
        this.transformers=transformers;
    }

    public void mix()
    {
        for(StringTransformer transformer : transformers)
        {
            transformer.execute();
        }
    }
}
