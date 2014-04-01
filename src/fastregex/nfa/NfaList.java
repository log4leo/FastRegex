package fastregex.nfa;

import java.util.ArrayList;
import java.util.Arrays;

public class NfaList
{
	State[] ss;
	public NfaList(ArrayList<State> states)
	{
		ss=states.toArray(new State[0]);
		Arrays.sort(ss);
	}
	@Override
	public int hashCode()
	{
		int ans=0;
		for(int i=0;i<ss.length;i++)
		{
			ans+=ss.hashCode();
		}
		return ans;
	}

	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof NfaList))
			return false;
		NfaList l2=(NfaList)o;
		if(ss.length!=l2.ss.length)
			return false;
		for(int i=0;i<ss.length;i++)
		{
			if(!ss[i].equals(l2.ss[i]))
				return false;
		}
		return true;
	}
}
