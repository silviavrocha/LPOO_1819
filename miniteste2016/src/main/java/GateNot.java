public class GateNot implements LogicGate {
    private LogicVariable result, input;
    GateNot(LogicVariable result, LogicVariable input) throws ColisionException, CycleException
    {
        if(input.getCalculatedBy()!=null)
        {
            for(int i=0; i<input.getCalculatedBy().getInputs().length;i++)
                if(input.getCalculatedBy().getInputs()[i]==result)
                    throw new CycleException();
        }

        this.result=result;
        this.input=input;
        result.addGate(this);
        input.addGate(this);

    }

    @Override
    public LogicVariable getOutput() {
        result.setValue(!input.getValue());
        return result;
    }

    @Override
    public LogicVariable[] getInputs() {
        LogicVariable[] inputs = {input};
        return inputs;
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }

    @Override
    public String getFormula() {
        return (getSymbol()+"("+ input.getFormula() + ")");
    }
}
