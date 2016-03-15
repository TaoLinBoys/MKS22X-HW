public class MyLinkedList{

    public class LNode{
	private int val;
	private LNode next;
	public LNode(int newval){
	    val = newVal;
	}
	public getval()return val;
	public getNext()return next;
	public setval(int newval)val = newval;
	public setNext(LNode newNext)next = newNext;	
    }

    private LNode start;
    private int size;
    
    public boolean add(int value){
	if(start.getNext == null){
	    start = new LNode(value);
	}else{
	    LNode current = start;
	    while(current.getNext != null){
		current = current.getNext();
	    }
	    current = new LNode(value);
	}
    }


}
