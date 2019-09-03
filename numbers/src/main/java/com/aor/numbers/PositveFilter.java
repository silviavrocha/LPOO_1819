package com.aor.numbers;

public class PositveFilter implements IListFilter {
    @Override
    public boolean accept(Integer number)
    {
        if(number>0)
            return true;
        return false;
    }
}
