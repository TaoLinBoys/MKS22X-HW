public class FrontierStack<T> implements Frontier<T>{
    private MyStack<T> data;
    public void add(T element){
	data.push(element);
    }

    public T next(){
	data.pop();
    }

    public boolean hasNext(){
	data.peek() != null;
    }

}
