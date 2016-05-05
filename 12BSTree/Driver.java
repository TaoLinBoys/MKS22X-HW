public class Driver{
    public static void main(String[]args){
	BSTree<Integer> test = new BSTree<Integer>();
        test.add(5);
	//System.out.println(test);
	test.add(2);
	//System.out.println(test);
	test.add(1);
	//System.out.println(test);
	test.add(3);
	System.out.println(test);


	/*
	System.out.println(test.contains(5));
	System.out.println(test.contains(2));
	System.out.println(test.contains(1));
	System.out.println(test.contains(3));
	System.out.println(test.contains(70000));
	*/

	System.out.println(test.getHeight());

    }
}
