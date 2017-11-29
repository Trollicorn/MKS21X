public class ReferenceBook extends LibraryBook{
    private String collection;

    
	
	public ReferenceBook(String author, String title, String ISBN, String callNumber){
    	super(author,title,ISBN,callNumber);
	}

    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
    	setAuthor(author);
    	setTitle(title);
    	setISBN(ISBN);
    	setCallNumber(callNumber);
    	this.collection = collection;
    }

    public String getCollection(){
    	return collection;
    }

    public void setCollection(String collection){
    	this.collection = collection;
    }

    public void checkout(String patron, String due){
    	System.out.println("cannot check out a reference book");
    }

    public void returned(){
    	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
    	return "non-circulating reference book";
    } 

    public String toString(){
    	return super.toString() + "\n Collection: " + getCollection();
    }

}
