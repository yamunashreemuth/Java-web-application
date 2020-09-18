package LibraryMgmt;

public class UserPage {
	protected String issueid;
	protected String issuebookid;
	protected String issuemembid;
	protected String isssuebooktitle;
	protected String issuebookauthor;
	protected String issuecategory;
	protected String issuedate;
	protected String noofrenewal;
	protected String issueadminid;
	protected String issueadminname;
	protected String returnstatus; 
		
	public UserPage() {
		super();
	}

	
	public UserPage(String issueid) {
		super();
		this.issueid = issueid;
	}


	public UserPage(String issueid, String issuebookid, String issuemembid, String isssuebooktitle, String issuebookauthor,
			String issuecategory, String issuedate, String noofrenewal, String issueadminid, String issueadminname, String returnstatus) {
		super();
		this.issueid = issueid;
		this.issuebookid = issuebookid;
		this.issuemembid = issuemembid;
		this.isssuebooktitle = isssuebooktitle;
		this.issuebookauthor = issuebookauthor;
		this.issuecategory = issuecategory;
		this.issuedate = issuedate;
		this.noofrenewal = noofrenewal;
		this.issueadminid = issueadminid;
		this.issueadminname = issueadminname;
		this.returnstatus = returnstatus;
	}

	public String getReturnstatus() {
		return returnstatus;
	}


	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}


	public String getIssueid() {
		return issueid;
	}

	public void setIssueid(String issueid) {
		this.issueid = issueid;
	}

	public String getIssuebookid() {
		return issuebookid;
	}

	public void setIssuebookid(String issuebookid) {
		this.issuebookid = issuebookid;
	}

	public String getIssuemembid() {
		return issuemembid;
	}

	public void setIssuemembid(String issuemembid) {
		this.issuemembid = issuemembid;
	}

	public String getIsssuebooktitle() {
		return isssuebooktitle;
	}

	public void setIsssuebooktitle(String isssuebooktitle) {
		this.isssuebooktitle = isssuebooktitle;
	}

	public String getIssuebookauthor() {
		return issuebookauthor;
	}

	public void setIssuebookauthor(String issuebookauthor) {
		this.issuebookauthor = issuebookauthor;
	}

	public String getIssuecategory() {
		return issuecategory;
	}

	public void setIssuecategory(String issuecategory) {
		this.issuecategory = issuecategory;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getNoofrenewal() {
		return noofrenewal;
	}

	public void setNoofrenewal(String noofrenewal) {
		this.noofrenewal = noofrenewal;
	}

	public String getIssueadminid() {
		return issueadminid;
	}

	public void setIssueadminid(String issueadminid) {
		this.issueadminid = issueadminid;
	}

	public String getIssueadminname() {
		return issueadminname;
	}

	public void setIssueadminname(String issueadminname) {
		this.issueadminname = issueadminname;
	} 
	
}
