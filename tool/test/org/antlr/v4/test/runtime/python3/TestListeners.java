package org.antlr.v4.test.runtime.python3;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

@SuppressWarnings("unused")
public class TestListeners extends BasePython3Test {

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testTokenGetters_1() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(535);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitA(self, ctx):\n");
		grammarBuilder.append("        if ctx.getChildCount()==2:\n");
		grammarBuilder.append("            print(ctx.INT(0).symbol.text + ' ' + ctx.INT(1).symbol.text + ' ' + str_list(ctx.INT()))\n");
		grammarBuilder.append("        else:\n");
		grammarBuilder.append("            print(str(ctx.ID().symbol))\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a 1 2)\n" +
			"1 2 [1, 2]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testBasic() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(386);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def visitTerminal(self, node):\n");
		grammarBuilder.append("        print(node.symbol.text)\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a 1 2)\n" +
			"1\n" +
			"2\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testTokenGetters_2() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(535);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitA(self, ctx):\n");
		grammarBuilder.append("        if ctx.getChildCount()==2:\n");
		grammarBuilder.append("            print(ctx.INT(0).symbol.text + ' ' + ctx.INT(1).symbol.text + ' ' + str_list(ctx.INT()))\n");
		grammarBuilder.append("        else:\n");
		grammarBuilder.append("            print(str(ctx.ID().symbol))\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="abc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a abc)\n" +
			"[@0,0:2='abc',<4>,1:0]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testLRWithLabels() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(527);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitCall(self, ctx):\n");
		grammarBuilder.append("        print(ctx.e().start.text + ' ' + str(ctx.eList()))\n");
		grammarBuilder.append("    def exitInt(self, ctx):\n");
		grammarBuilder.append("        print(ctx.INT().symbol.text)\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=e ;\n");
		grammarBuilder.append("e : e '(' eList ')' # Call\n");
		grammarBuilder.append("  | INT             # Int\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("eList : e (',' e)* ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1(2,3)";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(e (e 1) ( (eList (e 2) , (e 3)) ))\n" +
			"1\n" +
			"2\n" +
			"3\n" +
			"1 [13 6]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testRuleGetters_1() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(572);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitA(self, ctx):\n");
		grammarBuilder.append("        if ctx.getChildCount()==2:\n");
		grammarBuilder.append("            print(ctx.b(0).start.text + ' ' + ctx.b(1).start.text + ' ' + ctx.b()[0].start.text)\n");
		grammarBuilder.append("        else:\n");
		grammarBuilder.append("            print(ctx.b(0).start.text)\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : b b		// forces list\n");
		grammarBuilder.append("  | b		// a list still\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("b : ID | INT;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a (b 1) (b 2))\n" +
			"1 2 1\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testLR() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(547);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitE(self, ctx):\n");
		grammarBuilder.append("        if ctx.getChildCount()==3:\n");
		grammarBuilder.append("            print(ctx.e(0).start.text + ' ' + ctx.e(1).start.text + ' ' + ctx.e()[0].start.text)\n");
		grammarBuilder.append("        else:\n");
		grammarBuilder.append("            print(ctx.INT().symbol.text)\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("	: r=e ;\n");
		grammarBuilder.append("e : e op='*' e\n");
		grammarBuilder.append("	| e op='+' e\n");
		grammarBuilder.append("	| INT\n");
		grammarBuilder.append("	;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1+2*3";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(e (e 1) + (e (e 2) * (e 3)))\n" +
			"1\n" +
			"2\n" +
			"3\n" +
			"2 3 2\n" +
			"1 2 1\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* this file and method are generated, any edit will be overwritten by the next generation */
	@Test
	public void testRuleGetters_2() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(572);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("class LeafListener(TListener):\n");
		grammarBuilder.append("    def exitA(self, ctx):\n");
		grammarBuilder.append("        if ctx.getChildCount()==2:\n");
		grammarBuilder.append("            print(ctx.b(0).start.text + ' ' + ctx.b(1).start.text + ' ' + ctx.b()[0].start.text)\n");
		grammarBuilder.append("        else:\n");
		grammarBuilder.append("            print(ctx.b(0).start.text)\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("print($ctx.r.toStringTree(recog=self))\n");
		grammarBuilder.append("walker = ParseTreeWalker()\n");
		grammarBuilder.append("walker.walk(TParser.LeafListener(), $ctx.r)\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : b b		// forces list\n");
		grammarBuilder.append("  | b		// a list still\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("b : ID | INT;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="abc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a (b abc))\n" +
			"abc\n", found);
		assertNull(this.stderrDuringParse);

	}


}