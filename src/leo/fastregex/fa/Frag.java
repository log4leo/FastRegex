package leo.fastregex.fa;

import java.util.ArrayList;

public class Frag
{
	public State start;
	ArrayList<State> out;
	ArrayList<State> out1;

	public Frag(State s, ArrayList<State> o)
	{
		start = s;
		out = o;
		out1 = new ArrayList<>();
	}

	public Frag(State s)
	{
		start = s;
		out = new ArrayList<>();
		out1 = new ArrayList<>();
	}

	public Frag(State s, ArrayList<State> o, ArrayList<State> o1)
	{
		start = s;
		out = o;
		out1 = o1;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[Frag start:]" + start);
		sb.append("[Frag out:]" + out);
		sb.append("\n");
		return sb.toString();
	}
}
