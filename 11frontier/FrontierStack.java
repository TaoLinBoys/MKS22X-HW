public class FrontierStack<T> implements Frontier<T>{
    private MyStack<T> data;
    public void add(T element){
	data.push(element);
    }

    public T next(){
	return data.pop();
    }

    public boolean hasNext(){
	return data.peek() != null;
    }

}
