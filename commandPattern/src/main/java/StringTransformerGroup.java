import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    private List<StringTransformer> transformers;
    StringTransformerGroup(List<StringTransformer> transformers)
    {
        this.transformers=transformers;
    }

    public void execute()
    {
        for(StringTransformer transformer : transformers)
        {
            transformer.execute();
        }
    }
}
