import java.util.Arrays;
public class Sorts{

	public static String name(){
		return "09.Uddin.Mohammed";
	}

	/**Selection sort of an int array.
	*Upon completion, the elements of the array will be in increasing order. 
	@param data    the elements to be sorted 
	*/
	public static void selectionSort(int[] data){ 
		int toFill = 0; 
		for (int i = 0; i < data.length; i++){
			int minIndex = toFill;
			for (int j = minIndex; j < data.length; j++){
				if (data[minIndex] > data[j]){
					minIndex = j;
				}
			}
			int temp = data[toFill];
			data[toFill] = data[minIndex];
			data[minIndex] = temp; 
			toFill += 1;
		}
	}

    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i++){
	    for (int j = i; j > 0 && data[j] < data[j-1]; j--){
		swap(data, j, j-1);
	    }

	}


    }

	private static void swap(int[] ary, int a, int b){
	    int c = ary[a];
	    ary[a] = ary[b];
	    ary[b] = c;
	}


    

	public static void main(String[] args){
		int[] test = new int[100000];
		for (int i = 0; i < test.length; i++){
		    test[i] = (int)(Math.random() * 100);
		}
		System.out.println( Arrays.toString(test)); 

	/*	System.out.println("Selection Sort");
		selectionSort(test);
       	*/	System.out.println( Arrays.toString(test));
       	
		System.out.println("Insertion Sort");
		insertionSort(test);
		System.out.println( Arrays.toString(test));
       
	}


}
