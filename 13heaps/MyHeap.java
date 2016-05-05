import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;

    public MyHeap(){
	data = (T[])(new Comparable[10]);
	size = 0;
    }
    public MyHeap(T[] array){
	data = array;
	heapify();
	size = array.length;
    }

    private void pushDown(int k){
	
    }

    private void pushUp(int k){

    }

    private void heapify(){
	
    }
    
    public T delete(){
	return data[0];
    }

    public void add(T x){
	
    }
    
    private void doubleSize(){

    }
    public String toString(){
	return "";
    }

    //do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

}
