package fastregex.parser;

@Deprecated
public class Suffix extends RegEx
{
	public RegEx internal;

	public Suffix(RegEx re)
	{
		this.internal = re;
		this.type = RegExType.Suffix;
	}

	@Override
	public String toString()
	{
		return "[Suffix of " + internal + " ]";
	}
}
