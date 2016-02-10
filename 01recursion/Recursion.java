public class Recursion{
    public String name(){
	return "Lin,Tao";
    }
	
    public double sqrt(double n){
	if (n<0) throw new IllegalArgumentException();
	if (n==0) return 0;
	return sqrtH(n,1);		
    }
	
    private double sqrtH(double n, double guess){
	/*
	System.out.println(guess);
	System.out.println(PE(guess*guess, n));
	System.out.println("loop done");
	*/
	if (PE(guess*guess, n) < .0001) return guess;
	double newguess = ((n/guess)+guess)/2;
	return sqrtH(n,newguess);
    }
	
    public double PE(double measured, double actual){
	return (Math.abs((actual - measured))/actual)*100;
    }

}
