public class StringInverter implements StringTransformer {

    private StringDrink string;
    StringInverter(StringDrink s)
    {
        string= s;
    }
    public void execute()
    {
        StringBuffer str= new StringBuffer(string.getText());
        str.reverse();
        string.setText(str.toString());
    }
}
