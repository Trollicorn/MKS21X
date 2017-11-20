public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
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
    
    
    
    
}

