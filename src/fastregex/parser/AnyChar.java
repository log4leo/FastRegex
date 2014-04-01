package fastregex.parser;

public class AnyChar extends RegEx
{
	public AnyChar()
	{
		this.type = RegExType.AnyChar;
	}

	@Override
	public String toString()
	{
		return "[Any character]";
	}
}
