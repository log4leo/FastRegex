package fastregex.parser;

public class Primitives extends RegEx
{
	public char c;

	public Primitives(char c)
	{
		this.c = c;
		this.type = RegExType.Primitive;
	}

	@Override
	public String toString()
	{
		return "Primitives:" + c;
	}
}