package leo.fastregex.parser;

public class Blank extends RegEx
{
	public Blank()
	{
		this.type = RegExType.Blank;
	}

	@Override
	public String toString()
	{
		return "";
	}
}