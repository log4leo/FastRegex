package fastregex.parser;

public class Sequence extends RegEx
{
	public RegEx first;
	public RegEx second;

	public Sequence(RegEx first, RegEx second)
	{
		this.first = first;
		this.second = second;
		this.type = RegExType.Sequence;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(first);
		sb.append("+");
		sb.append(second);
		sb.append("]");
		return sb.toString();
	}
}
