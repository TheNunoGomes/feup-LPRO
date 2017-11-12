package circuits;

import java.util.ArrayList;

public class CombinatorialCircuit {
	private ArrayList<LogicVariable> variables = new ArrayList<LogicVariable>();
	
	public CombinatorialCircuit() {
	}
	public boolean addVariable(LogicVariable variable) {
		for(LogicVariable elem : variables)
			if(elem.equals(variable))
				return false;
		variables.add((LogicVariable) variable);
		return true;
	}
	public LogicVariable getVariableByName(String name) {
		for(LogicVariable elem : variables) {
			if(elem.getName().equals(name))
				return elem;
		}
		return null;
	}
}
