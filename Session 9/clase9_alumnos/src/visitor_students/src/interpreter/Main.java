package interpreter;

import java.util.ArrayList;
import java.util.List;
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
import interpreter.visitor.PrintVisitor;
import interpreter.visitor.SolveVisitor;
import interpreter.visitor.Visitor;

public class Main 
{
	public static void main(String[] args) 
	{
		/*
		 	read ancho; 
		 	read alto; 
		 	area = alto * ancho / 2; 
		 	print area + 10;
		 */

		List<Statement> statements = new ArrayList<Statement>();

		// read ancho;
		statements.add(new Read(new Variable("ancho")));

		// read alto;
		statements.add(new Read(new Variable("alto")));

		// area = alto * ancho / 2;
		Product prod = new Product(new Variable("alto"), new Variable("ancho"));
		statements.add(new Assignment(new Variable("area"), new Division(prod, new IntegerLiteral("2"))));

		// print area + 10;
		statements.add(new Print(new Sum(new Variable("area"), new IntegerLiteral("10"))));

		Program program = new Program(statements);

		System.out.println("\n--- Recorrido Recursivo: todo en un método");
		RecursiveTreeTraversal recursiveTraversal = new RecursiveTreeTraversal();
		recursiveTraversal.visit(program);

		// No compila
		System.out.println("\n--- Recorrido ideal: no compila");
		// IdealVersion ideal = new IdealVersion();
		// ideal.visit(program);
		
		// TODO: Tenéis que hacer que funcione lo siguiente
		System.out.println("\n--- Recorrido con el patrón Visitor: sin hacer");
		Visitor printVisitor = new PrintVisitor();
		program.accept(printVisitor, null);
		
		// TODO: Después, otro visitor que interprete el programa
		Scanner input = new Scanner(System.in);
		Visitor solveVisitor = new SolveVisitor(input);
		program.accept(solveVisitor, null);
		input.close();
	}
}
