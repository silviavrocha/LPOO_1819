public class StringReplacer implements StringTransformer {

    private StringDrink str;
    private Character replaced, newChar;
    StringReplacer(StringDrink s, Character old, Character newChar)
    {
        str=s;
        replaced=old;
        this.newChar=newChar;
    }

    public void execute()
    {
        String newString = str.getText().replace(replaced, newChar);
        str.setText(newString);
    }
}
