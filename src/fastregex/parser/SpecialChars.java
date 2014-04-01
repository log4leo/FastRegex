package fastregex.parser;

public class SpecialChars extends RegEx
{
	public char special;

	public SpecialChars(char c)
	{
		special = c;
		type = RegExType.SpecialChars;
	}

	@Override
	public String toString()
	{
		return "[Special character:\\" + special;
	}
}
