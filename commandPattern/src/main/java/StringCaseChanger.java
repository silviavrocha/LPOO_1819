public class StringCaseChanger implements StringTransformer {

    StringDrink str;
    StringCaseChanger(StringDrink s)
    {
        str=s;
    }
    public void execute()
    {
        String newString="";
        for(int i=0; i<str.getText().length(); i++)
        {
            if(Character.isLowerCase(str.getText().charAt(i)))
                newString += Character.toUpperCase(str.getText().charAt(i));
            else
                newString += Character.toLowerCase(str.getText().charAt(i));
        }
        str.setText(newString);
    }

}
