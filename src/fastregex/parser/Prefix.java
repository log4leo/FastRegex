package fastregex.parser;

@Deprecated
public class Prefix extends RegEx
{
	public RegEx internal;

	public Prefix(RegEx re)
	{
		this.internal = re;
		this.type = RegExType.Prefix;
	}

	@Override
	public String toString()
	{
		return "[Prefix of " + internal + " ]";
	}
}
