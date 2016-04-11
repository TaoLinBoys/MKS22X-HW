public class FrontierStack<T> implements Frontier<T>{
    private MyStack<T> data;
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
