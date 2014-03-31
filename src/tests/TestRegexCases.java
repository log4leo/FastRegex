package tests;

import java.io.File;
import java.util.Scanner;

import leo.fastregex.fa.Pattern;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestRegexCases
{
	@Test
	public void thisAlwaysPasses() throws Exception
	{
		int line=0;
		int count=0;
		Scanner sc=new Scanner(new File("src\\tests\\TestCases"));
		while(sc.hasNextLine())
		{	
			String p=sc.nextLine();
			if(p.startsWith("//")||p.length()==0)
				{
				line++;
				continue;
				}
			count++;
			Pattern pattern=new Pattern(p);
			String s=sc.nextLine();
			String ret=sc.nextLine();
			boolean ans=ret.split(" ")[0].equals("true");
			org.junit.Assert.assertEquals("Case"+count+" line"+line+",pattern:"+p+",source: "+s,ans,pattern.match(s));
			//sc.nextLine();
			line=line+3;
		}
		sc.close();
	}

	@Test
	@Ignore
	public void thisIsIgnored()
	{
	}
}
