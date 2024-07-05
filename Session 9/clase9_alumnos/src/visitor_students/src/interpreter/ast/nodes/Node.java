package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public interface Node
{
	public Object accept (Visitor v, Object param);
}
