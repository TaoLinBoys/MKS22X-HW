public class Driver{
    public static void main(String[]args){
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	for(int i = 0; i < 10; i++){
	    int rand = (int)(Math.random()*100) - 20;
	    test.add(rand);
	}
	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.get(0));
	System.out.println(test.set(5,420));
	System.out.println(test);
        test.add(3,420);
	System.out.println(test);
	System.out.println(test.remove(10));
	System.out.println(test);
	System.out.println(test.indexOf(420));
    }
}
