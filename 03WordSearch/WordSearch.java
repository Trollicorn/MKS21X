import java.util.Random; 
import java.util.Scanner; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.FileNotFoundException; 


public class WordSearch{

    private char[][]data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;
    private int seed;
    private String solution;

    public WordSearch(int rows, int cols, String filename){
	this(rows, cols, filename, (int)(Math.random()*100000));
    }

    public WordSearch(int rows, int cols, String filename, int seed){
	data = new char[rows][cols];
	this.seed = seed;
	randgen = new Random(seed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	clear();
	readFile(rows,cols,filename);
	addAllWords();
	storeSolution();
	fill();
    }

    private void readFile(int rows, int cols, String filename){
	try{
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    while(scan.hasNext()){
		String word = scan.next().toUpperCase();
		if(word.length() < rows+1 || word.length()+1 < cols){
		    wordsToAdd.add(word);
		    // System.out.println(word);
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
    }
	


    private void clear(){
	for (int row = 0; row < data.length; row++){
	    for (int col = 0; col < data[row].length; col++){
		data[row][col] = '_';
	    }
	}	
    } 	
    
    public String toString(){
	String gather = ""; 
	gather += "Seed: " + getSeed() + "\n";
	for (int row = 0; row < data.length; row++){
	    for (int col = 0; col < data[row].length; col++){
		gather += data[row][col] + " ";
	    }
	    gather += "\n";
	}
	gather += "\nWords: \n"; 
	int counter = 1;
	for (int i = 0; i < wordsAdded.size(); i++){
		gather += wordsAdded.get(i) + " ";
		if (counter % 4 == 0){
			gather += "\n";
		}
		counter++;
	}
	return gather;	
    }

    public int getSeed(){
	return seed;
    }

    private void storeSolution(){
	solution = "" + toString();
    } 

    public String getSolution(){
	return solution;
    }

    public String getWordsAdded(){
    	String gather = "";
    	for (int i = 0; i < wordsAdded.size(); i++){
    		gather += wordsAdded.get(i) + " ";
    	}
    	return gather;
    }
    
    private boolean willFit(String word, int row, int col, int rinc, int cinc){
    	try{
    		for (int i = 0; i < word.length(); i++){
    			if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
    				return false;
    			}
    			row += rinc;
    			col += cinc;
    		}
    		return true;
    	}
    	catch (ArrayIndexOutOfBoundsException e){  
    		return false; 
    	}
    }

    private boolean addWord(String word, int row, int col, int rinc, int cinc){
    	if (! willFit(word,row,col,rinc,cinc)){
    		return false;
    	}
    	for (int i = 0; i < word.length(); i++){
	    data[row][col] = word.charAt(i);
	    row += rinc;
	    col += cinc;
    	}
    	return true;
    }
    
    private boolean addAllWords(){;
	for (int i = 0; i < 1000; i++){
	    int row = randgen.nextInt() % data.length; 
	    if (row < 0 ){               //stupid negative remainders
	    	row += data.length;         
	    }
	    int col = randgen.nextInt() % data[0].length;
	    if (col < 0){                //stupid negative remainders
	    	row += data.length;
	    }
	    int rinc = randgen.nextInt() % 3;
	    if (rinc < 0){
	    	rinc += 3;
	    } 
	    rinc = 1 - rinc; 

	    int cinc = (randgen.nextInt() % 3); 
	    if (cinc < 0){
	    	cinc += 3;
	    } 
	    cinc = 1 - cinc; 
	    if (rinc == 0 && cinc == 0){
		continue;
	    }
	    if (wordsToAdd.size() == 0){
	    	return true;
	    }
	    int index = randgen.nextInt() % wordsToAdd.size();
	    if (index < 0){
	    	index += wordsToAdd.size();
	    }
	    String word = wordsToAdd.get(index);
	    if (addWord(word,row,col,rinc,cinc)){
		wordsToAdd.remove(word);
		wordsAdded.add(word);
	    }
	}
	return true;	
    }

    private void fill(){
	for (int i = 0; i < data.length; i++){
	    for (int j = 0; j < data[0].length; j++){
		if (data[i][j] == '_'){
			int number = randgen.nextInt() % 26;
			if (number < 0){
				number += 26;
			}
		    data[i][j] = (char) ('A' + number);
		}
	    }
	}
    }

    private static String directions(){
	String directions = "Please input the parameters in the follwing order: \n" 
				      + "the first parameter is a positive integer \n"
                      + "the second parameter is a positive integer \n"
                      + "the third parameter is the name of a textfile \n"
                      + "the optional fourth parameter is the seed of a specific Word Search \n"
                      + "the optional fifth parameter can either be \"key\" or empty \n" 
                      + "if the fifth parameter is \"key\", the solution will be shown instead of the search"; 
	return directions;
    }
    
    public static void main(String[] args){
	try{ 
	    if (args.length == 3){
		WordSearch search = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
		System.out.println(search); 
	    }
	    else if (args.length == 4){
		WordSearch search = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		System.out.println(search);
	    }
	    else if (args.length == 5 && args[4].equals("key")){
		WordSearch search = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		System.out.println(search.getSolution());
	    }
	    else {
		System.out.println( directions() );
	    }
	}
	catch(NumberFormatException e){
	    System.out.println( directions() );
	}
    }
}
