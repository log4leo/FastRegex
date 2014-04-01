package fastregex.nfa;

public class ScaleState extends State
{
	public boolean[] scale;

	public ScaleState(boolean[] s)
	{
		super(Pattern.Scale);
		this.scale = s;
	}
}
