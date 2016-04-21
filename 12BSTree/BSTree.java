import java.util.*;
public class BSTree<T extends Comparable<T>>{
    public int compareTo(Node tree){
	return Integer.compare(this.getData(), tree.getData());
    }
    
    private class Node{
	T data;
	Node right, left;

	public void setData(T d){ data = d; }
	public void setRight(Node r){ right = r; }
	public void setLeft(Node l){ left = l; }

	public T getData(){ return data; }
	public Node getRight(){ return right; }
	public Node getLeft(){ return left; }
	
	public Node(T value){
	    setData(value);
	}
	public Node(T value, Node right, Node left){
	    setData(value);
	    setRight(right);
	    setLeft(left);
	}
	
	public int height(){
	    return 0;
	}
	public void add(T value){
	    if(value.compareTo(data) < 0){
		setLeft(new Node(value));
	    }else{
		setRight(new Node(value));
	    }
	}
	public String toString(){
	    return "";
	}
	public boolean contains(T value){
	    return false;
	}
    }
    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
    
}
