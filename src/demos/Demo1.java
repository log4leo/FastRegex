package demos;

import leo.fastregex.fa.Pattern;

public class Demo1
{
public static void main(String[] args)
{
	
	Pattern pattern2=new Pattern("^z+[1-5&&8940[3]]*(ab)(cd*)z+$");
	System.out.println(pattern2.match("zzz34abczzz"));
	//This regex is supposed to be matched
}
}
