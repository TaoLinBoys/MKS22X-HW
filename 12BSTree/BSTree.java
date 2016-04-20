import java.util.*;
public class BSTree<T extends Comparable<T>>{
    public int compareTo(T tree){
	return Integer.compare(this.getValue(), tree.getValue());
    }
    
    private class Node{
	T data;
	Node right, left;
	
    }
}
