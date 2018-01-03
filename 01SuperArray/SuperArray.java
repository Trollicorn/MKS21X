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
		if (index != 0){
			if (index < 0 || index > size()){
				throw new IndexOutOfBoundsException();
			} 
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
				if(!s.get(i).equals(a.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public static void runTest01(int testID){
		if(testID<0){
			System.out.println("Error in driver usage!");
			System.exit(0);
		}

		SuperArray s1 = new SuperArray();
		ArrayList<String> s2 = new ArrayList<>();

		try{
			if(testID == 0 ){
			}

			if(testID == 1 ){
				s1.add("0");
				s2.add("0");
				s1.add("1");
				s2.add("1");
			}

			if(testID == 2 ){

				s1.add("0");
				s2.add("0");
				s1.add("1");
				s2.add("1");
				s1.add(1,"5");
				s2.add(1,"5");
				s1.add(0,"6");
				s2.add(0,"6");
				s1.add(s1.size()-1,"4");
				s2.add(s2.size()-1,"4");
			}

			if(testID == 3 ){
				s1.add("0");
				s2.add("0");
				s1.add("1");
				s2.add("1");
				s1.add(1,"5");
				s2.add(1,"5");
				s1.add(0,"6");
				s2.add(0,"6");
				s1.add(s1.size(),"4");
				s2.add(s2.size(),"4");
			}

			if(testID == 4 ){
				s1.add(0,"0");
				s2.add(0,"0");
			}

			if(testID == 5 ){
				s1.add("1");
				s2.add("1");
				for(int i = 0; i < 10; i ++){
					String v = ""+(int)(Math.random()*1000);
					int in = (int)(Math.random()*s2.size());
					s1.add(in,v);
					s2.add(in,v);
				}

			}

			if(testID == 6 ){
				try{
					s1.get(0);
				} catch(IndexOutOfBoundsException e){

				}
			}

			if(testID == 7 ){
				try{
					s1.set(0,"");
				} catch(IndexOutOfBoundsException e){

				}
			}

			if(testID == 8 ){
				try{
					s1.add(1,"");
				} catch(IndexOutOfBoundsException e){

				}
			}
			if(testID == 9 ){
				s1.add("1");
				s2.add("1");

				for(int i = 0; i < 1000;   i ++){
					String v = ""+(int)(Math.random()*1000);
					int in = (int)(Math.random()*s2.size());
					s1.add(in,v);
					s2.add(in,v);
				}
			}


		}
		catch(Exception f){
			s2.add("0");
    //f.printStackTrace();
		}


		System.out.println(s1);
		System.out.println(s2);

		if(equals(s1,s2)){
			System.out.println("Test "+testID+",PASS");
		}else{
			System.out.println("Test "+testID+",FAIL");
		}
	}

	public static void main(String[]args){
		for(int i = 0; i < 10; i++){
			runTest01(i);
		}
	}

}

