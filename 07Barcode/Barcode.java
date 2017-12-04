public class Barcode{
	private String zip;
	private String[] guide; 
	
	public Barcode(String zip){
		this.zip = zip + checkSum(zip); 
		guide = new String[] {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::" };
	}

	public int checkSum(String zip){
		int sum = 0;
		for (int i = 0; i < zip.length(); i++){
			sum += Integer.parseInt(zip.substring(i,i+1));
		}
		return sum;
	}

	private String numToBar(int num){
		return guide[num];
	}

	public String getZip(){
		return zip;
	}

	public String getCode(){
		String code = "|";
		for (int i = 0; i < zip.length(); i++){
			code += numToBar( Integer.parseInt( zip.substring(i,i+1) )  );
		}
		code += "|";
		return code; 
	}

	public String toString(){
		return getCode();
	}

}