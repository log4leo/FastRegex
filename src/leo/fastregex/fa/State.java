package leo.fastregex.fa;

public class State
{
	public static final int Split = 256;
	public static State matchState = new State(257);
	int c;
	// char c2;
	State out;
	State out1;
	int lastlist1;

	public State()
	{

	}

	public State(int c)
	{
		this.c = c;
	}

	public State(char c)
	{
		this.c = c - ' ';
	}

	public State(int c, State o, State o1)
	{
		this.c = c;
		out = o;
		out1 = o1;
	}

	public State(char c, State o, State o1)
	{
		this.c = c - ' ';
		out = o;
		out1 = o1;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[c:" + c);
		sb.append(",out:" + out == null ? "null" : out.c);
		sb.append(",out1:" + out1 == null ? "null" : out1.c);
		sb.append("]");
		return sb.toString();
	}
}
