public class Recursion{
	public String name(){
		return "Lin,Tao";
	}
	
	public double sqrt(double n){
		if (n<0) throw new IllegalArgumentException();
		return sqrtH(n,n/2);		
	}
	
	public double sqrtH(double n, double guess){
		if (PE(guess*guess, n) < 5) return guess;
		double newguess = ((n/guess)+guess)/2;
		return sqrtH(n,newguess);
	}
	
	public double PE(double measured, double actual){
		return ((actual - measured)/actual)*100;
	}

}