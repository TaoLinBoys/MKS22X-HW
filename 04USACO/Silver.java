public class Silver{
    char[][]farm;

    public Silver(String filename){
	File fileN = new File(filename);
	Scanner whole = new Scanner(fileN);

	int rows = 0;
	while(whole.hasNextLine()){rows++;}
	
	int cols = 0;
	Scanner line = new Scanner(whole.nextLine());
	
    }
}
