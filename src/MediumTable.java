import java.util.Calendar;

public class MediumTable {
	
	NewNode head;
	NewNode tail;
	NewNode prev;
	
	public MediumTable()
	{
		head=null;
		tail=null;
		prev=null;
	}
	
	public void addReservation(String name, int time, int people)
	{
		NewNode temp=new NewNode(name,time,people,null);
		if(head==null)
		{
			head=temp;
			tail=temp;
			head.setNext(null);
		}
		else
		{
			tail.setNext(temp);
			tail=temp;
			tail.setNext(null);
		}
	}
	
	public void deleteReservation(String name)
	{
		if(head==null)
		{
			System.out.println("List is empty");
			
		}
		else
		{
			
			NewNode temp=head;
			prev=head;
			
			while(temp!=null)
			{
				if(temp.getName().equals(name))
				{
					if(temp==head)
					{
						head=temp.getNext();
					}
					else if(temp.getNext()!=null)
					{
						prev.setNext(temp.getNext());
					}
					else if(temp.getNext()==null)
					{
						prev.setNext(null);
						tail=prev;
					}
				}
				prev=temp;
				temp=temp.getNext();
			}
		}
	}
	
	public void printReservation()
	{
		NewNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.getName()+" at "+temp.getTime());
			temp=temp.getNext();
		}
		
	}
	
	public boolean checkAvailability(int time)
	{
		MediumTable a=new MediumTable();
		Calendar now = Calendar.getInstance();
		NewNode temp=head;
		if(time>23||time<10)
		{
			return false;
		}
		while(temp!=null)
		{
			if(now.get(Calendar.HOUR_OF_DAY)>temp.getTime()+1)
			{
				a.deleteReservation(temp.getName());
			}
			temp=temp.getNext();
		}
		temp=head;
		while(temp!=null)
		{
			if(temp.getTime()==time)
			{
				return false;
			}
			temp=temp.getNext();
		}
		return true;
	}
}

