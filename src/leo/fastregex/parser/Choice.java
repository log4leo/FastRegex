package leo.fastregex.parser;

public class Choice extends RegEx
{
	public RegEx thisOne;
	public RegEx thatOne;

	public Choice(RegEx thisOne, RegEx thatOne)
	{
		this.thisOne = thisOne;
		this.thatOne = thatOne;
		this.type = RegExType.Choice;
	}

	@Override
	public String toString()
	{
		return "[Choice in " + thisOne + " and " + thatOne + "]";
	}

}