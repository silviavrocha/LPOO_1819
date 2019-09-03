import java.util.ArrayList;
import java.util.List;

public class LogicVariable {
    private String name;
    private boolean value;
    private List<LogicGate> gates = new ArrayList<>();
    LogicVariable(String name, boolean value)
    {
        this.name=name;
        this.value=value;
    }

    LogicVariable(String name)
    {
        this.name=name;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value)
    {
        this.value = value;
        for( LogicGate gate : gates)
        {
            for(int i=0; i<gate.getInputs().length;i++)
                if(gate.getInputs()[i]==this)
                    gate.getOutput();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // are the references equal
        if (o == null) return false; // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        LogicVariable l = (LogicVariable) o; // cast the other object
        return (name==l.getName()); // actual comparison
    }

    public void addGate(LogicGate gate) throws ColisionException
    {
        if(this.equals(gate.getOutput()))
            if(getCalculatedBy()!=null)
                throw new ColisionException();
        gates.add(gate);
    }

    public LogicGate getCalculatedBy()
    {
        for(LogicGate gate : gates)
            if(this.equals(gate.getOutput()))
                return gate;
        return null;
    }

    public String getFormula()
    {
        if(getCalculatedBy()==null)
            return name;
        else
            return (getCalculatedBy().getFormula());
    }

}
