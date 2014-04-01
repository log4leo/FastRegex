package demos;

import java.util.regex.Matcher;

import fastregex.nfa.Pattern;

public class Demo1
{
	public static void main(String[] args)
	{
		testJDK(28);
	}

	private static void testJDK(int n)
	{

		StringBuilder sb = new StringBuilder();
		StringBuilder matcher = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			sb.append("a?");
		}
		for (int i = 0; i < n; i++)
		{
			sb.append("a");
			matcher.append("a");
		}
		System.out.println("pattern:" + sb.toString());
		System.out.println("input:" + matcher.toString());

		long start = System.currentTimeMillis();
		Pattern fastPattern = Pattern.compile(sb.toString());
		boolean ret2 = fastPattern.match(matcher.toString());
		long end = System.currentTimeMillis();
		System.out.println("FastRegex time with " + n + " : " + (end - start)
				/ 1000 + " seconds,result: " + ret2);

		start = System.currentTimeMillis();
		java.util.regex.Pattern jdkPattern = java.util.regex.Pattern.compile(sb
				.toString());
		Matcher m = jdkPattern.matcher(matcher);
		boolean ret1 = m.matches();
		end = System.currentTimeMillis();
		System.out.println("JDK time with " + n + " : " + (end - start) / 1000
				+ " seconds,result: " + ret1);

	}
}
