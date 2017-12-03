public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
    	setAuthor(author);
    	setTitle(title);
    	setISBN(ISBN);
    	setCallNumber(callNumber);
    	currentHolder = "";
    	dueDate = ""; 
    }

    public String getCurrentHolder(){
    	return currentHolder;
    }

    public String getDueDate(){
    	return dueDate;
    }

    public void setCurrentHolder(String currentHolder){
    	this.currentHolder = currentHolder;
    }

    public void setDueDate(String dueDate){
    	this.dueDate = dueDate;
    }

    public void checkout(String patron, String due){
    	setCurrentHolder(patron);
    	setDueDate(due);
    }

    public void returned(){
    	setCurrentHolder("");
    	setDueDate("");
    }

    public String circulationStatus(){
    	if (getCurrentHolder().length() == 0){
    		return "book available on shelves";
    	}
    	return "Current Holder: " + getCurrentHolder() + "\nDue: " + getDueDate();
    }

    public String toString(){
    	String gather = super.toString();
    	if (getCurrentHolder().length() != 0){
    		gather += "\n" + circulationStatus();
    	}
    	return gather;
    }

}

