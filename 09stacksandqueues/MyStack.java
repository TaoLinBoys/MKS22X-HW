import java.util.*;

public class MyStack<T>{
    private MyLinkedList<T> data;
    public MyStack(){
	data = new MyLinkedList<T>();
    }

    public void push(T item){
	data.add(0,item);
    }

    public T pop(){
	if(isEmpty()){
	  throw new NoSuchElementException();
	}
	return data.remove(0);
    }

    public T peek(){
	if(isEmpty()){
	  throw new NoSuchElementException();
	}
	return data.get(0);
    }

    public int size(){
	return data.size();
    }

    public boolean isEmpty(){
	return size() == 0;
    }
    
    public static void main(String[]args){
	MyStack<Integer> test = new MyStack<Integer>();
	for(int i = 0; i < 10; i++){
	    test.push((int)(Math.random()*1));
	}
	System.out.println(test.pop());
	System.out.println(test.pop());
	System.out.println(test.pop());
	System.out.println(test.pop());
    }
}
