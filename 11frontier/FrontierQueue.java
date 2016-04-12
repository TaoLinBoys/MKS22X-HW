public class FrontierQueue<T> implements Frontier<T>{
    private MyQueue<T> data;
    public FrontierQueue(){
	data = new MyQueue<T>();
    }
    public void add(T element){
	data.enqueue(element);
    }

    public T next(){
	return data.dequeue();
    }

    public boolean hasNext(){
	return data.peek() != null;
    }
}
