package leo.fastregex.parser;

public class StarRepetition extends RegEx
{
	public RegEx internal;

	public StarRepetition(RegEx internal)
	{
		this.internal = internal;
		this.type = RegExType.StarRepetition;
	}

	@Override
	public String toString()
	{
		return "[* repetition of" + internal + "]";
	}
}