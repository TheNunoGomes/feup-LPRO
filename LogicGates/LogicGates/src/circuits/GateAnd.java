package circuits;

public class GateAnd extends LogicGate {
	public GateAnd(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException{
		this.inputs = new LogicVariable[2];
		output.setValue(input1.getValue() && input2.getValue());
		
		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		
		output.setCalculatedBy(this);
		
		this.output = output;
		this.inputs[0] = input1;
		this.inputs[1] = input2;
	}
	@Override
	public String getSymbol() {
		return "AND";
	}
	@Override
	public boolean getValue() {
		return (inputs[0].getValue() && inputs[1].getValue());
	}
	public String getFormula() {
		return "AND(" + inputs[0].getFormula() + "," + inputs[1].getFormula() + ")";
	}
}
