import java.util.*;
public class MyStack<T>{
    MyLinkedList<T> data;
    public MyStack(){
	data = new MyLinkedList<T>();
    }

    public void push(T item){
	data.add(item);
    }

    public T pop(){
	//if (data.size() == 0){
	//  throw new NoSuchElementExpection();
	//}
	return data.remove(0);
    }

    public T peek(){
	return data.get(0);
    }

    public int size(){
	return data.size();
    }

    public boolean isEmpty(){
	return size() == 0;
    }
    
}
