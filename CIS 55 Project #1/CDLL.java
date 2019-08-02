public class CDLL
{

    private Node head = null;
    private Node current;
    private int size = 0;


    /* 
    * Insert creates a new node and puts in front of the current Node
    * The new node inserted becomes the list’s “current” Node
    */

    public void insert(int data)
    {
    	if(head == null)
    	{
    		head = new Node(data);
    		head.previous = head;
    		head.next = head;
    	}
    	else if(size == 1)
    	{
    		Node newNode = new Node(data);
    		newNode.next = head;
    		newNode.previous = head;
    		head.previous = newNode;
    		head.next = newNode;
    		head = newNode;
    	}
    	else
    	{
    		Node newNode = new Node(data);
    		newNode.next = head;
    		newNode.previous = head.previous;
    		head.previous.next = newNode;
    		head.previous = newNode;
    		head = newNode;
    	}
	
	size ++;
    }


    /* 
    * Search starts from the current location and looks
    * for the given data value. If the Node is found, it
    * returns the Node. Otherwise, it returns null
    */

    public Node search(int data)
    {
    	Node newNode = new Node(data);
    	
    	current = head;

   		int i = 0;
   		while(current.data != newNode.data && i < size)
   		{
   			current = current.next;
   			i++;
   		}
   		if(current.data == newNode.data)
   		{
   			head = current;
   	   		return current;	
   		}
   		else
   		{
   			return null;
   		}
    	
    	
    }


    /* 
    * Update searches for the given oldData value.
    * If the Node is found, it changes the node value to
    * newValue and returns true. Otherwise, it returns false
    * If the node is found, that node also becomes
    * the current Node
    */

    public boolean update(int oldValue, int newValue)
    {
    	current = search(oldValue);
    	
    	if (current == null)
    	{
    		return false;
    	}
    	current.data = newValue;
    	
    	return true;
    }

    /* 
    * Delete searches for the given data value. 
    * If the Node is found, it removes the node 
    * from the list and returns true. Otherwise, it 
    * returns false. If a node is removed, the 
    * next node becomes the current Node
     
    */

    public boolean delete(int data)
    {
    	
    	if (size == 0)
    	{
    		return false;
    	}
    	else if(size == 1)
    	{
    		current = search(data);
    		if(current.data == data);
    		{
    			head = null;
        		size--;
        		return true;
    		}
       	}
    	else
    	{
    		current = search(data);
    		if (current == null)
    		{
    			return false;
    		}
    		else
    		{
    			if(current == head)
    			{
    				head = current.next;
    			}
    			current.previous.next = current.next;
    			current.next.previous = current.previous;
    			size--;
    			return true;
    		}
    		
    	}
    }


    /* 
    * getCurrent returns the current Node in the list
    * If the list is empty, it returns null
    */

    public Node getCurrent()
    
    {
    	return current;
    }

    

    /* 
    * print displays all Nodes in order from the current
    * node in the list using the “next” node pointers 
    * of each node
     
    */
    
    public void print()
    {
	if(size == 0)
	{
	    System.out.println();
	    return;
	}
	Node current = head;
	do
	{
	    System.out.println(current.data);
	    current = current.next;
	}
	while(current != head);

    }


    /* 
    * print displays all Nodes in order from the current 
    * node in the list using the “previous” node pointers
    * of each node
    */

    public void printReverse()
    {    	
    	if(size ==0)
    	{
    		System.out.println();
    		return;
    	}
    	Node current = head.previous;
    	do
    	{
    		System.out.println(current.data);
    		current = current.previous;
    	}
    	while(current != head.previous);
    	
    }
    
}
