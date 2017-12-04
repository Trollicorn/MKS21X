import java.lang.IllegalArgumentException;

public class Barcode implements Comparable<Barcode>{
    private String zip;
    private String[] guide; 
    
    public Barcode(String zip){
	if (zip.length() != 5 ){
	    throw new IllegalArgumentException();
	}
	try {
	    Integer.parseInt(zip);
	}
	catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
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

    private int barToNum(String bar){
	for (int i = 0; i < 10; i++){
	    if (bar.equals(guide[i])){
		return i;
	    }
	}
	return -1;
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

    public static String toCode(String zip){
	Barcode temp = new Barcode(zip);
	return temp.getCode();
    }

    public String toZip(String code){
	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	code = code.substring(1,31);
	String zip = "";
	for (int i = 0; i < 30; i+=5){
	    int temp = barToNum(code.substring(i,i+5));
	    if (temp == -1){
		throw new IllegalArgumentException();
	    }
	    zip += temp;
	}
	int checkSum = Integer.parseInt(zip.substring(5,6));
	if (checkSum != checkSum(zip.substring(0,5))){
	    throw new IllegalArgumentException();
	}
	return zip;
    }
    
}
