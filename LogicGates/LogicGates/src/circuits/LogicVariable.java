package circuits;

public class LogicVariable {
	private String name;
	private boolean value;
	private LogicGate calculatedBy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getValue() {
		if(calculatedBy == null)
			return value;
		return calculatedBy.getValue();
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public LogicVariable(String name, boolean value) {
		super();
		this.name = name;
		this.value = value;
	}
	public LogicVariable(String name) {
		super();
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		return name.equals(((LogicVariable) obj).getName());
	}
	
	public String getFormula() {
		if(calculatedBy == null)
			return name;
		return calculatedBy.getFormula();
	}
	
	public void setCalculatedBy(LogicGate value) {
		this.calculatedBy = value;
	}
	public LogicGate getCalculatedBy() {
		return calculatedBy;
	}
}
