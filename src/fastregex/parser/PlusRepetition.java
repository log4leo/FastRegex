package fastregex.parser;

public class PlusRepetition extends RegEx
{
	public RegEx internal;

	public PlusRepetition(RegEx re)
	{
		internal = re;
		this.type = RegExType.PlusRepetition;
	}

	@Override
	public String toString()
	{
		return "[+ repetition of " + internal + "]";
	}
}
