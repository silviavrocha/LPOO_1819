package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    Integer number;
    DivisibleByFilter(Integer number)
    {
        this.number=number;
    }
    public boolean accept(Integer number)
    {
        if ((number % this.number) == 0)
            return true;
        return false;
    }
}
