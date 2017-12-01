import java.util.Iterator; 
public class SuperArrayIterator implements Iterator<String>{
	private SuperArray array; 
	private int current; 

	public SuperArrayIterator(SuperArray array){
		this.array = array; 
		current = 0; 
	}

	public boolean hasNext(){
		return current < array.size();
	}

	public String next(){
		current++; 
		return array.get(current - 1);
	}



}