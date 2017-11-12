package circuits;

public abstract class LogicGate {
	protected LogicVariable output;
	protected LogicVariable[] inputs;
	
	public LogicVariable[] getInputs() {
		return inputs.clone();
	}
	public LogicVariable getOutput() {
		return output;
	}
	public abstract String getSymbol();
	public abstract boolean getValue();

	public abstract String getFormula();
}