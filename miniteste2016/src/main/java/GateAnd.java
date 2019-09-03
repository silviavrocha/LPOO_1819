public class GateAnd implements  LogicGate{
    private LogicVariable result, input1, input2;
    GateAnd(LogicVariable result, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException
    {
        if(input1.getCalculatedBy()!=null)
        {
            for(int i=0; i<input1.getCalculatedBy().getInputs().length;i++)
                if(input1.getCalculatedBy().getInputs()[i]==result)
                    throw new CycleException();
        }
        if(input2.getCalculatedBy()!=null) {
            for (int i = 0; i < input2.getCalculatedBy().getInputs().length; i++)
                if (input2.getCalculatedBy().getInputs()[i] == result)
                    throw new CycleException();
        }
        this.result=result;
        this.input1=input1;
        this.input2=input2;
        result.addGate(this);
        input1.addGate(this);
        input2.addGate(this);
    }

    @Override
    public LogicVariable getOutput() {
        result.setValue(input1.getValue() && input2.getValue());
        return result;
    }

    @Override
    public LogicVariable[] getInputs() {
        LogicVariable[] inputs = {input1, input2};
        return inputs;
    }

    @Override
    public String getSymbol() {
        return "AND";
    }

    @Override
    public String getFormula() {
        return (getSymbol()+"("+ input1.getFormula() +"," + input2.getFormula() + ")");
    }
}
