package leo.fastregex.parser;

public class QuoraRepetition extends RegEx
{
	public RegEx internal;

	public QuoraRepetition(RegEx re)
	{
		this.internal = re;
		this.type = RegExType.QuoraRepetition;
	}

	@Override
	public String toString()
	{
		return "[? repetition of " + internal + "]";
	}
}
