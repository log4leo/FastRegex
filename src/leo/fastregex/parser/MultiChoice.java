package leo.fastregex.parser;

public class MultiChoice extends RegEx
{
	// public ArrayList<MultiChoice> choices;
	private static final int ARRAY_SIZE = 256;
	public boolean[] scale = new boolean[ARRAY_SIZE];

	/*
	 * public MultiChoice(boolean negative, ArrayList<MultiChoice> list) {
	 * this.choices = list; type = negative ? RegExType.NegativeMultiChoice :
	 * RegExType.MultiChoice; }
	 */
	public MultiChoice()
	{
		type = RegExType.MultiChoice;
	}

	public MultiChoice(char c1, char c2)
	{
		type = RegExType.MultiChoice;
		int i1 = c1 - ' ';
		int i2 = c2 - ' ';
		for (int i = i1; i <= i2; i++)
		{
			scale[i] = true;
		}
	}

	public void and(MultiChoice other)
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			if (this.scale[i] && !other.scale[i])
			{
				scale[i] = false;
			}
		}
	}

	public void or(MultiChoice other)
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			if (other.scale[i])
			{
				scale[i] = true;
			}
		}
	}

	public void reverse()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			scale[i] = !scale[i];
		}
	}
	/*
	 * @Override public String toString() { return choices.toString(); }
	 */
}
