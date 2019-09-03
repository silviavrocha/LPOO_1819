public interface LogicGate {
     LogicVariable getOutput();
     LogicVariable[] getInputs();
     String getSymbol();
     String getFormula();
}
