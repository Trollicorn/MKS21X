import java.util.ArrayList;

public class SuperArray{

	private String[] data; 
	private int size;  

	public SuperArray(){
		data = new String[10];
		size = 0;
	}

	public SuperArray(int startingCapacity){
		data = new String[startingCapacity];
		size = 0;
	}


	public void clear(){
		data = new String[10];
		size = 0; 
	}

	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public String toString(){
		if (size() == 0){
			return "[]";
		}
		else{
			String gather = "[" + data[0];
			for (int i = 1; i < size; i++){
				gather += ", " + data[i];
			}
			gather += "]";
			return gather;
		}
	}
	
	public boolean add(String element){
		if (size >= data.length){
			resize();
		}
		data[size] = element;
		size ++; 
		return true;
	} 

	public String get(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}
	
	public String set(int index, String element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		String temp = data[index];
		data[index] = element; 
		return temp; 
	}
	

	private void resize(){
		String[] temp = new String[data.length * 2];
		for (int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp; 
	}


	public boolean contains(String element){
		for (int i = 0; i < size; i++){
			if (data[i].equals(element)){
				return true;
			}
		}
		return false;
	}

	public int indexOf(String element){
		for (int i = 0; i < size; i++){
			if (data[i].equals(element)){
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(String element){
		for (int i = size - 1; i > -1; i--){
			if (data[i].equals(element)){
				return i;
			}
		}
		return -1;
	}


	public void add(int index, String element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		} 
		if (size >= data.length){
			resize();
		}
		for (int i = size + 1; i > index; i--){
			data[i] = data[i-1];
		}
		data[index] = element;
		size ++;
	}
	
	public String remove(int index){
		if (index < 0 || index >= size()){
			System.out.println("Error: Index out of range");
			return "null";
		}
		String temp = data[index];
		for (int i = index; i < size + 1; i++){
			data[i] = data[i+1];
		}
		size --;
		return temp;
	}

	public boolean remove(String element){
		int target = indexOf(element);
		if (target == -1){
			return false;
		}
		remove(target);
		return true;
	}

	public static boolean equals(SuperArray s, ArrayList<String> a){
		if(s.size() == a.size()){
			for(int i = 0; i < s.size(); i++){
				if(s.get(i) != a.get(i)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
