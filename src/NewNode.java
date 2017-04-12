
public class NewNode {
	String name;
	int time;
	int people;
	NewNode next;
	
	public NewNode()
	{
		name=null;
		time=0;
		people=0;
	}
	
	public NewNode(String name,int time,int people,NewNode next)
	{
		this.name=name;
		this.time=time;
		this.people=people;
		this.next=next;
	}
	
	public String getName()
	{
		return name;
	}
	public int getTime()
	{
		return time;
	}
	public int getPeople()
	{
		return people;
	}
	public NewNode getNext()
	{
		return next;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setTime(int time)
	{
		this.time=time;
	}
	public void setPeople(int people)
	{
		this.people=people;
	}
	public void setNext(NewNode next)
	{
		this.next=next;
	}
}
