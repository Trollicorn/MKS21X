public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	
    }

    public Book(String author,String title,String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(){
	this.author = author;
    }

    public void setTitle(){
	this.title = title;
    }

    public void setISBN(){
	this.ISBN = ISBN;
    }

    public String toString(){
	return getTitle() + " by " + getAuthor() + "\nISBN: " + getISBN();
    }
}
