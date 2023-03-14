package game;

public class SingleLinkedList {
	Node head;	
	
	public void add(Object data)
	{
		if(head==null)
		{
			Node newNode= new Node(data);
			head= newNode;
		}
		else
		{
			Node temp=head;
			while(temp.getLink()!=null)
			{
				temp=temp.getLink();
			}
			Node newNode=new Node(data);
			temp.setLink(newNode);
		}
	}
	public int size()
	{
		if(head==null)
			return 0;
		else
		{
			int count=0;
			Node temp=head;
			while(temp!=null)
			{
				temp=temp.getLink();
				count++;
			}
			return count;
		}
		
	}
	
	public void display()
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.print(temp.getData()+" ");
				temp=temp.getLink();
			}
		}
	}
	public String print()
	{
		String print=" ";
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				print=print+temp.getData()+" ";
				temp=temp.getLink();
			}
		}
		return print;
	}
	public int findMax()
	{
		if (head == null)
		{
			System.err.println("The Linked List is empty");
			return Integer.MIN_VALUE;
		}
		else
		{
		   int maxVal = Integer.MIN_VALUE;
			
		   Node temp = head;
			
		   while(temp != null)
		   {
			  if ((int) temp.getData() > maxVal)
			  {
				  maxVal = (int) temp.getData();
			  }			
			  temp = temp.getLink();
		}		
	      return maxVal;
		}
	}
	
	public int search(Object data)
	{
		int search_count=0;
		if(head==null)
			{
			System.out.println("List is empty");
			return 0;
			}
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				if((Integer)temp.getData()==(Integer)data)
				{
					search_count++;
				}
				temp=temp.getLink();
				
			}
			return search_count;
		}
		
	}
	
	public void remove(Object dataToDelete)
	{
		if(head==null)
		{
			System.out.println("List is empty");
			
		}
	    if(((Integer) head.getData()).compareTo((Integer)dataToDelete)==0)
        {
	      head=head.getLink();
        }
	    else
		{
			Node temp=head;
			Node previous=head;
			while(temp!=null)
			{
				if(((Integer) temp.getData()).compareTo((Integer)dataToDelete)==0)
				{
					previous.setLink(temp.getLink());
					temp=previous;
					break;
				}
				previous=temp;
				temp=temp.getLink();
				
			}
		}
	}
	public void removeStr(Object dataToDelete)
	{
		if(head==null)
		{
			System.out.println("List is empty");
			
		}
	    if(((String) head.getData()).compareTo((String)dataToDelete)==0)
        {
	      head=head.getLink();
        }
	    else
		{
			Node temp=head;
			Node previous=head;
			while(temp!=null)
			{
				if(((String) temp.getData()).compareTo((String)dataToDelete)==0)
				{
					previous.setLink(temp.getLink());
					temp=previous;
					break;
				}
				previous=temp;
				temp=temp.getLink();
				
			}
		}
	}

public SingleLinkedList sort(SingleLinkedList sll_n)
{
	SingleLinkedList HighScore_Table_final= new SingleLinkedList();
	Object temp=null;
	Object temp_n=null;
	if(head==null)
	{
		System.out.println("List is empty");
		
	}
	else
	{
		Node current=head;
		Node current_n=sll_n.head;
		
		while(current.getLink()!=null)
		{
			Node next=current.getLink();
			Node next_n=current_n.getLink();
			while(next!=null)
			{
			if((Integer)current.getData()<(Integer)next.getData())
			{
				temp=current.getData();
				current.setData( next.getData() );
				next.setData(temp);
				
				temp_n=current_n.getData();
				current_n.setData(next_n.getData());
				next_n.setData(temp_n);
				
			}
			next = next.getLink();
			next_n=next_n.getLink();
			}
			current= current.getLink();
			current_n=current_n.getLink();
		}
		current_n=sll_n.head;
		current=head;
		while(current_n.getLink()!=null)
		{
			HighScore_Table_final.add(current_n.getData());
			HighScore_Table_final.add(current.getData());
			HighScore_Table_final.add("\n");
			current_n=current_n.getLink();
			current=current.getLink();
			}
		
	}

	return HighScore_Table_final;
			
}

	

}
