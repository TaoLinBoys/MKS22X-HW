public class MyQueue<T>{
    private MyLinkedList<T> = data;
    public MyQueue(){
	data = new MyLinkedList<T>();
    }

    public void enqueue(T item){
	data.add(item);
    }

    public T dequeue(){
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

    private boolean isEmpty(){
	return size() == 0;
    }
}
