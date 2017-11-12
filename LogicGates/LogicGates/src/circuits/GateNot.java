package circuits;

public class GateNot extends LogicGate {
	public GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
		this.inputs = new LogicVariable[1];
		output.setValue(!input.getValue());
		
		if(input.getCalculatedBy().getInputs()[0] == output || input.getCalculatedBy().getInputs()[1] == output)
			throw new CycleException();

		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		
		output.setCalculatedBy(this);
		
		this.output = output;
		this.inputs[0] = input;
	}
	@Override
	public String getSymbol() {
		return "NOT";
	}
	@Override
	public boolean getValue() {
		return (!inputs[0].getValue());
	}
	public String getFormula() {
		return "NOT(" + inputs[0].getFormula() + ")";
	}
}
