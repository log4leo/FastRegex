FastRegex
=========

FastRegex is a <b>regular expression engine</b> written in Java with NFA theory, a little weeker but faster than JDK in most cases. It will compile regular expressions to NFA and use NFA to match string candidates. The general idea comes from [Thompson Construction](http://swtch.com/~rsc/regexp/regexp1.html).


How to get 
=========

<a href="https://github.com/log4leo/FastRegex/archive/master.zip">Download</a> zip files and jar files can be found in the zip package.


How to use
=========

FastRegex is easy to use, you just need to get a compiled Pattern object with a legal regular expression, then you can match strings with it everywhere:)


```java
//This regex is supposed to be matched
Pattern pattern2=Pattern.compile("^z+[1-5&&8940[3]]*(ab)(cd*)z+$");
System.out.println(pattern2.match("zzz34abczzz"));
```


Test
=========

FastRegex use the same [test cases](http://hg.openjdk.java.net/jdk7u/jdk7u6/jdk/file/8c2c5d63a17e/test/java/util/regex/) with JDK, FastRegex currently passes every test case FastRegex has support for. 

Both Junit test classes and test cases files can be found in the tests package.
License
=========
[MIT]()





