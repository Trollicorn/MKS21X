import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class OrderedSuperArray extends SuperArray{

	public OrderedSuperArray(){
		super();
	}
	public OrderedSuperArray(int startingCapacity){
		super(startingCapacity);
	}

	public OrderedSuperArray(String[] arr){
		super(arr.length);
		for (int i = 0; i < arr.length; i++){
			add(arr[i]);
		}
	}

	public String set(int index, String element){
		throw new UnsupportedOperationException();
	}

	public void add(int index, String value){
		add(value);
	}

    //whoops i forgot a binary search program

	public boolean add(String value){
		if ( size() == 0){
			super.add(value);
			return true;
		}
		if ( size() == 1){
			if (value.compareTo(get(0)) < 0){
				super.add(0,value);
				return true;
			}
			else{
				super.add(value);
				return true;
			}
		}
		int begin = 0; 
		int end = size();
		int average = 0;
		for (int i = 0; i < 2 * size();  i++){
			average = (end + begin) / 2; 
			if (value.compareTo(get(average)) < 0){
				end = average;
			}
			if (value.compareTo(get(average)) > 0){
				begin = average;
			}
			if (value.compareTo(get(average)) == 0){
				super.add(average,value);
				return true;
			}
			if (begin+1 == end){
				if (value.compareTo(get(begin)) < 0){
					super.add(begin,value);
					return true;
				}
				else{
					super.add(begin+1,value);
					return true;
				}
			}	
		}
		return false;
	} 

	public static void runTest02(int testID){

		if(testID<0){
			System.out.println("Error in driver usage!");
			System.exit(0);
		}

		OrderedSuperArray s1 = new OrderedSuperArray();
		ArrayList<String> s2 = new ArrayList<>();

		try{
			if(testID == 0 ){
			}

			if(testID == 1 ){
				s1.add("4");
				s2.add("4");
				s1.add("1");
				s2.add("1");
				s1.add("0");
				s2.add("0");
			}

			if(testID == 2 ){
				s1.add("3");
				s2.add("3");
				s1.add("1");
				s2.add("1");
				s1.add("5");
				s2.add("5");
				s1.add("0");
				s2.add("0");
			}

			if(testID == 3 ){
				s1.add("1");
				s2.add("1");
				for(int i = 0; i < 10; i ++){
					String v = ""+(int)(Math.random()*1000);
					int in = (int)(Math.random()*s2.size());
					s1.add(in,v);
					s2.add(in,v);
				}
			}

			if(testID == 4 ){
				s1.add("1");
				s2.add("1");
				try{
					s1.set(0,"");
				} catch(UnsupportedOperationException e){

				}
			}

			if(testID == 5 ){
				try{
					s1.set(0,"");
				} catch(UnsupportedOperationException e){

				}
			}

			if(testID == 6 ){
				String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
				s1 = new OrderedSuperArray(x);
				s2.addAll(Arrays.asList(x));
			}
			if(testID == 7 ){
				s1.add("1");
				s2.add("1");

				for(int i = 0; i < 30;   i ++){
					String v = ""+(int)(Math.random()*1000);
					s1.add(v);
					s2.add(v);
				}
			}

		}catch(Exception f){
			s2.add("0");
			f.printStackTrace();
		}

		Collections.sort(s2);


//		System.out.println(s1);
//		System.out.println(s2);

	//	System.out.println(s1);
	//	System.out.println(s2);

		if(equals(s1,s2)){
			System.out.println("Test "+testID+",PASS");
		}else{
  			System.out.println("Test "+testID+",FAIL!" + "+s1+"!="+s2");
  		}
  	}

  	public static void main(String[] args) {
  	/*	for (int i = 0; i < 8; i++){
  			runTest02(i);
  		}*/
  		runTest02(7);
  	}


  }

