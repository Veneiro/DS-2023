package interpreter.visitor;

import java.util.Optional;

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

public class PrintVisitor implements Visitor {

	@Override
	public Object visit(Program p, Object param) {
		for (Statement st : p.statements) {
			st.accept(this, param);
		}
		return param;
	}

	@Override
	public Object visit(Print p, Object param) {
		System.out.print("print ");
		p.expression.accept(this, param);
		System.out.println(";");
		return param;
	}

	@Override
	public Object visit(Assignment p, Object param) {
		p.variable.accept(this, param);
		System.out.print(" = ");
		p.expression.accept(this, param);
		System.out.println(";");
		return param;
	}

	@Override
	public Object visit(Division p, Object param) {
		p.left.accept(this, param);
		System.out.print(" / ");
		p.right.accept(this, param);
		return param;
	}

	@Override
	public Object visit(IntegerLiteral p, Object param) {
		System.out.print(p.value);
		return Optional.of(p.value);
	}

	@Override
	public Object visit(Product p, Object param) {
		p.left.accept(this, param);
		System.out.print(" * ");
		p.right.accept(this, param);
		return param;
	}

	@Override
	public Object visit(Read p, Object param) {
		System.out.print("read ");
		p.variable.accept(this, param);
		System.out.println(";");
		return param;
	}

	@Override
	public Object visit(Sum p, Object param) {
		p.left.accept(this, param);
		System.out.print(" + ");
		p.right.accept(this, param);
		return param;
	}

	@Override
	public Object visit(Variable p, Object param) {
		System.out.print(p.name);
		return param;
	}

}
