package leo.fastregex.parser;

public class Parser
{
	private int position = 0;
	private boolean isPrefix = false;
	private boolean isSuffix = false;
	private RegEx re = null;

	public Parser(String in)
	{
		this.input = in;
		if (input.length() > 0 && input.charAt(0) == '^')
		{
			isPrefix = true;
			input = input.substring(1);
		}
		if (input.length() > 0 && input.charAt(input.length() - 1) == '$')
		{
			isSuffix = true;
			input = input.substring(0, input.length() - 1);
		}
		re = regex();
		re.setIsPrefix(isPrefix);
		re.setIsSuffix(isSuffix);
	}

	private String input;

	public RegEx parse()
	{
		return re;
	}

	/* Recursive descent parsing internals. */

	private char peek()
	{
		return input.charAt(position);
	}

	private void eat(char c)
	{
		char next = peek();
		if (next == c) position++;
		else throw new RuntimeException("Expected: " + c + "; got: " + next);
	}

	private char next()
	{
		char c = peek();
		eat(c);
		return c;
	}

	private boolean more()
	{
		return position < input.length();
	}

	/* Regular expression term types. */

	private RegEx regex()
	{
		RegEx term = term();
		if (more() && peek() == '|')
		{
			eat('|');
			RegEx regex = regex();
			return new Choice(term, regex);
		}
		else
		{
			return term;
		}
	}

	private RegEx term()
	{
		RegEx factor = RegEx.blank;
		while (more() && peek() != '|' && peek() != ')')
		{// term can't start with | or )
			RegEx nextFactor = factor();
			factor = new Sequence(factor, nextFactor);
		}
		return factor;
	}

	private RegEx factor()
	{
		RegEx base = base();
		while (more() && (peek() == '*' || peek() == '+' || peek() == '?'))
		{
			char c = peek();
			switch (c)
			{
				case '*':
					base = new StarRepetition(base);
					eat('*');
					break;
				case '+':
					base = new PlusRepetition(base);
					eat('+');
					break;
				case '?':
					base = new QuoraRepetition(base);
					eat('?');
					break;
				default:
					break;
			}
		}
		return base;
	}

	private RegEx base()
	{
		switch (peek())
		{
			case '(':
			{
				eat('(');
				RegEx r = regex();
				eat(')');
				return r;
			}
			case '\\':
			{
				eat('\\');
				char esc = next();
				return new SpecialChars(esc);
			}
			case '.':
			{
				eat('.');
				return new AnyChar();
			}
			case '[':
			{
				eat('[');
				RegEx re = multichoice();
				eat(']');
				return re;
			}
			default:
				return new Primitives(next());
		}
	}

	private RegEx multichoice()
	{
		boolean negative = false;
		if (peek() == '^')
		{
			negative = true;
			eat('^');
		}
		MultiChoice ans = new MultiChoice();
		while (more() && peek() != ']')
		{
			MultiChoice single = (MultiChoice) singlechoice();
			ans.or(single);
			while (peek() == '&')
			{
				eat('&');
				eat('&');
				MultiChoice second = (MultiChoice) andchoice();
				ans.and(second);
			}
		}
		if (negative) ans.reverse();
		return ans;
	}

	private RegEx singlechoice()
	{
		if (peek() == '[')
		{
			eat('[');
			RegEx re = multichoice();
			eat(']');
			return re;
		}
		char c1 = next();
		if (peek() == '-')
		{
			eat('-');
			char c2 = next();
			return new MultiChoice(c1, c2);
		}
		return new MultiChoice(c1, c1);
	}
	
	private RegEx andchoice()
	{
		MultiChoice ans=new MultiChoice();
		while(more()&&peek()!=']'&&peek()!='&')
		{
		 MultiChoice re=(MultiChoice)singlechoice();
		 ans.or(re);
		}
		return ans;
	}
}
