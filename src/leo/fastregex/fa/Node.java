package leo.fastregex.fa;

import java.util.ArrayList;
import java.util.Iterator;

enum NodeType
{
	OrNode, ParenNode, NormalNode, StarNode, PlusNode, QuoraNode, Empty,
}

@Deprecated
public abstract class Node implements Iterable<Node>
{
	// ArrayList<Node> children=new ArrayList<>();
	@Override
	public abstract Iterator<Node> iterator();
}

class EmptyNode extends Node
{
	@Override
	public Iterator<Node> iterator()
	{
		// TODO Auto-generated method stub
		return new Iterator<Node>()
		{

			@Override
			public boolean hasNext()
			{
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Node next()
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove()
			{
				// TODO Auto-generated method stub

			}
		};
	}
}

class ParenNode extends Node
{
	ArrayList<Node> children = new ArrayList<>();

	public void add(Node n)
	{
		children.add(n);
	}

	@Override
	public Iterator<Node> iterator()
	{

		// TODO Auto-generated method stub
		return new Iterator<Node>()
		{
			int i = 0;

			@Override
			public boolean hasNext()
			{
				// TODO Auto-generated method stub
				return i < children.size();
			}

			@Override
			public Node next()
			{
				// TODO Auto-generated method stub
				return children.get(i++);
			}

			@Override
			public void remove()
			{
				// TODO Auto-generated method stub
				// children.remove(i);
			}
		};
	}

}

class OrNode extends Node
{
	Node first;
	Node second;

	public OrNode(Node f, Node s)
	{
		first = f;
		second = s;
	}

	@Override
	public Iterator<Node> iterator()
	{
		// TODO Auto-generated method stub
		return new Iterator<Node>()
		{
			Node cur = first;

			@Override
			public boolean hasNext()
			{
				// TODO Auto-generated method stub
				return cur == null;
			}

			@Override
			public Node next()
			{
				// TODO Auto-generated method stub
				Node tmp = cur;
				cur = cur == first ? second : null;
				return tmp;

			}

			@Override
			public void remove()
			{
				// TODO Auto-generated method stub
			}
		};
	}
}

class NormalNode extends Node
{
	char c;

	public NormalNode(char c)
	{
		this.c = c;
	}

	@Override
	public Iterator<Node> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
