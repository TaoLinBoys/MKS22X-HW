import java.util.*;
public class BSTree<T extends Comparable<T>>{
    /*public int compareTo(Node tree){
	return Math.signum(this.getData() - tree.getData());
	}*/
    
    private class Node{
	T data;
	Node right, left;
	boolean DEBUG = true;
	
	public void debug(String i){System.out.println(i);}

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
	    String Tree = "";
	    if(right == null && left == null){
		Tree += data + "__";
	    }
	    if(right != null && left == null){
		Tree += data + "_" + right.toString();
	    }
	    if(left != null && right == null){
	        Tree += data + left.toString() + "_";
	    }
	    if(left != null && right != null){
		Tree += data + left.toString() + right.toString();
	    }
	    return Tree;
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
	if(root == null){
	    root = new Node(value);
	}else{
	    root.add(value);
	}
    }
    public String toString(){
	//check for empty before you do things with root.
        return root.toString();
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
    
}