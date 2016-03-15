public class MyLinkedList{

    public class LNode{
	private int val;
	private LNode next;
	public LNode(int newval){
	    val = newval;
	}
	public int getval(){return val;}
	public LNode getNext(){return next;}
	public void setval(int newval){val = newval;}
	public void setNext(LNode newNext){next = newNext;}	
    }

    private LNode start;
    private int size;
    
    public boolean add(int value){
	if(start== null){
	    start = new LNode(value);
	    return true;
	}else{
	    LNode current = start;
	    while(current.getNext() != null){
		current = current.getNext();
	    }
	    current = new LNode(value);
	    return true;
	}
    }

    public String toString(){
	String list = "[";
	LNode current = start;
	while(current.getNext() != null){
	    list += current.getval() + ", ";
	}
	list += current.getval() + "]";
	return list;
    }

    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	for(int i = 0; i < 5; i++){
	    int rand = (int)(Math.random()*50);
	    test.add(rand);
	    System.out.println(test.toString());
	}
    }


}
