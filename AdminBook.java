package LibraryMgmt;

public class AdminBook {
	protected int bookid;
	protected String booktile;
	protected String bookauthor;
	protected String bookedition;
	protected String publicationyear;
	protected String publisher;
	protected String category;
	protected String branch;
	protected String status;
	protected String addedempid;
	protected String addedempname; 
	
public AdminBook() {
		
	}
public AdminBook(int bookid) {
	this.bookid = bookid;
}
	public AdminBook(String booktile, String bookauthor, String bookedition,String publicationyear, String publisher, String category, String branch, String status,
			String addempid, String addempname) {
		this.booktile = booktile;
		this.bookauthor = bookauthor;
		this.bookedition = bookedition;
		this.publicationyear = publicationyear;
		this.publisher = publisher;
		this.category = category;
		this.branch = branch;
		this.status = status;
		this.addedempid = addedempid;
		this.addedempname = addedempname;
	}
	public AdminBook(int bookid, String booktile, String bookauthor, String bookedition,String publicationyear, String publisher, String category, String branch, String status,
			String addedempid, String addedempname) {
		super();
		this.bookid = bookid;
		this.booktile = booktile;
		this.bookauthor = bookauthor;
		this.bookedition = bookedition;
		this.publicationyear = publicationyear;
		this.publisher = publisher;
		this.category = category;
		this.branch = branch;
		this.status = status;
		this.addedempid = addedempid;
		this.addedempname = addedempname;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBooktile() {
		return booktile;
	}

	public void setBooktile(String booktile) {
		this.booktile = booktile;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getPublicationyear() {
		return publicationyear;
	}

	public void setPublicationyear(String publicationyear) {
		this.publicationyear = publicationyear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddedempid() {
		return addedempid;
	}

	public void setAddedempid(String addedempid) {
		this.addedempid = addedempid;
	}

	public String getAddedempname() {
		return addedempname;
	}

	public void setAddempname(String addedempname) {
		this.addedempname = addedempname;
	}

	public String getBookedition() {
		return bookedition;
	}

	public void setBookedition(String bookedition) {
		this.bookedition = bookedition;
	}

	
}
