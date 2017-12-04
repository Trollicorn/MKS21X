public class Barcode implements Comparable<Barcode>{
    private String zip;
    private String[] guide; 
    
    public Barcode(String zip){
	this.zip = zip; 
	guide = new String[] {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::" };
    }
    
    private int checkSum(String zip){
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
	for (int i = 0; i < 5; i++){
	    code += numToBar( Integer.parseInt( zip.substring(i,i+1) )  );
	    if (i == 4){
		code += numToBar (checkSum(zip));
	    }
	}
	code += "|";
	return code; 
    }
    
    public String toString(){
	return getCode();
    }
    
    public int compareTo(Barcode other){
	return Integer.parseInt(getZip()) - Integer.parseInt(other.getZip());
    }
    
}
