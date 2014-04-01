package fastregex.nfa;

public class State implements Comparable<State>
{

	private static int count = 1;
	public static final int Split = 256;
	protected final int id;
	// public static State matchState = new State(257);
	int c;
	// char c2;
	State out;
	State out1;
	int lastlist1;

	public State()
	{
		id = count++;
	}

	public State(int c)
	{
		id = count++;
		this.c = c;
	}

	public State(char c)
	{
		id = count++;
		this.c = c - ' ';
	}

	public State(int c, State o, State o1)
	{
		id = count++;
		this.c = c;
		out = o;
		out1 = o1;
	}

	public State(char c, State o, State o1)
	{
		id = count++;
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

	@Override
	public int hashCode()
	{
		return id;
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof State)) return false;
		return this.id == ((State) o).id;
	}

	@Override
	public int compareTo(State other)
	{
		if (this.id > other.id) return 1;
		else if (this.id < other.id) return -1;
		return 0;
	}
}
