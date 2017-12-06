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

	public static void main(String[] args){
		int[] test = {64,25,12,22,11};
		System.out.println( Arrays.toString(test)); 

		System.out.println("Selection Sort");
		selectionSort(test);
		System.out.println( Arrays.toString(test));
	}


}