import java.util.*;
public class RunningMedian{
    private MyHeap<Integer> SmallValue, BigValue; 
    private double median;

    private boolean DEBUG = true;
    public void debug(String i){
	if(DEBUG)System.out.println(i);
    }
    
    
    public RunningMedian(){
	SmallValue = new MyHeap<Integer>(); //maxheap
	BigValue = new MyHeap<Integer>(false);  //minheap
    }

    public double getMedian(){
        if(SmallValue.size() == 0 && BigValue.size() == 0){
	    throw new NoSuchElementException();
	}

	if(SmallValue.size() > BigValue.size()){
	    median = (double)SmallValue.peek();
	}else if(SmallValue.size() < BigValue.size()){
	    median = (double) BigValue.peek();
	}else{
	    Integer small = SmallValue.peek();
	    Integer big = BigValue.peek();
	    median = (small + big)/2.0;
	}
	return median;
    }

    public void add(Integer x){
	if(x < median){
	    SmallValue.add(x);
	}else{
	    BigValue.add(x);
	}

	
	debug(SmallValue.toString());
	debug(BigValue.toString());
	debug(" ");

	
	balance();
	getMedian(); //sets the median
    }

    private void balance(){
	if(SmallValue.size() > BigValue.size() + 1){
	    Integer removed = SmallValue.delete();
	    BigValue.add(removed);
	}else if(SmallValue.size() + 1 < BigValue.size()){
	    Integer removed = BigValue.delete();
	    SmallValue.add(removed);
	}
    }

    public String toString(){
	return "Small Values: " + SmallValue.toString() +
	    "\nBig Values: " + BigValue.toString();
    }

    public static void main(String[]args){
	RunningMedian test = new RunningMedian();
	test.add(5);
	test.add(7);
	test.add(9);
	test.add(10);
	System.out.println(test);
	System.out.println(test.getMedian());
    }
}
