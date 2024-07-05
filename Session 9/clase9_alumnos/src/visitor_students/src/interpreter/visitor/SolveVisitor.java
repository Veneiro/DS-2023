package interpreter.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public class SolveVisitor implements Visitor {

	private Map<String, Integer> ts = new HashMap<>();
	private Scanner input;

	public SolveVisitor(Scanner scanner) {
		this.input = scanner;
	}
	
	@Override
	public Object visit(Program p, Object param) {
		for (Statement st : p.statements) {
			st.accept(this, param);
		}
		return param;
	}

	@Override
	public Object visit(Print p, Object param) {
		Integer value = (Integer) p.expression.accept(this, param);
		System.out.println(value);
		return null;
	}

	@Override
	public Object visit(Assignment p, Object param) {
		int v = (int) p.expression.accept(this, param);
		ts.put(p.variable.name, v);
		return 0;
	}

	@Override
	public Object visit(Division p, Object param) {
		int i1 = (Integer) p.left.accept(this, param);
		int i2 = (Integer) p.right.accept(this, param);
		return i1 / i2;
	}

	@Override
	public Object visit(IntegerLiteral p, Object param) {
		return Integer.parseInt(p.value);
	}

	@Override
	public Object visit(Product p, Object param) {
		int i1 = (Integer) p.left.accept(this, param);
		int i2 = (Integer) p.right.accept(this, param);
		return i1 * i2;
	}

	@Override
	public Object visit(Read p, Object param) {
		System.out.println("Escribe lo que quieres guardar en la ts: ");
		ts.put(p.variable.name, Integer.parseInt(input.nextLine()));
		return param;
	}

	@Override
	public Object visit(Sum p, Object param) {
		int i1 = (Integer) p.left.accept(this, param);
		int i2 = (Integer) p.right.accept(this, param);
		return i1 + i2;
	}

	@Override
	public Object visit(Variable p, Object param) {
		return ts.get(p.name);
	}

}
