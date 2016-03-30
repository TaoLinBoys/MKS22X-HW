public class ParenDemo{
    public static boolean isMatching(String s){
	MyStack<Character> parens = new MyStack<Character>();
        for(int i = 0; i < s.length(); i++){
	    if(s.charAt(i) == '(' ||
	       s.charAt(i) == '{' ||
	       s.charAt(i) == '[' ||
	       s.charAt(i) == '<'){
		parens.push(s.charAt(i));
	    }
	    if(s.charAt(i) == ')' && parens.peek() == '('){
		parens.pop();
	    }
	    if(s.charAt(i) == '}' && parens.peek() == '{'){
		parens.pop();
	    }
	    if(s.charAt(i) == ']' && parens.peek() == '['){
		parens.pop();
	    }
	    if(s.charAt(i) == '>' && parens.peek() == '<'){
		parens.pop();
	    }
	}
	return parens.isEmpty();
    }


    public static void main(String[]args){
	String input = "()";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
