public class ReverseCharSequence implements CharSequence{

	private String reverse;
	private String original; 

	public ReverseCharSequence(String str){
		original = str; 
		reverse = "";
		for (int i = 0; i < str.length(); i++){
			reverse += str.charAt(i);
		}
	}

	public char charAt(int index){
		char ok = 'a';
		for (int i = 0; i < reverse.length(); i++){
			if (i == index){
				ok = reverse.charAt(i);
			}
		}
		return ok;
	}

	public int length(){
		return reverse.length();
	}
	
	public ReverseCharSequence subSequence(int start, int end){
		ReverseCharSequence gather = new  ReverseCharSequence( original.substring(start,end));
		return gather;
	}

	public String toString(){
		return reverse;
	}
	
}
