package leo.fastregex.parser;

public abstract class RegEx
{
	public static final RegEx blank = new Blank();
	private boolean isPrefix = false;
	private boolean isSuffix = false;

	protected void setIsPrefix(boolean b)
	{
		isPrefix = b;
	}

	protected void setIsSuffix(boolean b)
	{
		isSuffix = b;
	}

	public boolean getIsPrefix()
	{
		return isPrefix;
	}

	public boolean getIsSuffix()
	{
		return isSuffix;
	}

	public RegExType type;
	// public abstract Frag toNfaFrag();

}
