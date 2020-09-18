package LibraryMgmt;

import java.io.Serializable;

//program of java Bean class
public class MemberCreation implements Serializable{

	private  String memberID;
	private  String membername;
	private  String memberaddress;
	private  String membercontact;
	private  String memberUsername;
	private  String memberpassword;
	private String memberEmail;
	private  String createdEmpid;
	private  String createdEmpname;
	private String RegisteredDate;
	
	public MemberCreation() {
		super();
	}
	public MemberCreation(String memberID, String membername, String memberaddress, String membercontact,String RegisteredDate,
			String memberUsername, String memberpassword, String createdEmpid, String createdEmpname, String memberEmail)
	{
		super();
		this.memberID = memberID;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.membercontact = membercontact;
		this.memberUsername = memberUsername;
		this.memberpassword = memberpassword;
		this.createdEmpid = createdEmpid;
		this.createdEmpname = createdEmpname;
		this.memberEmail = memberEmail;
		this.RegisteredDate = RegisteredDate;
	}
	public String getRegisteredDate() {
		return RegisteredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		RegisteredDate = registeredDate;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public String getMembercontact() {
		return membercontact;
	}
	public void setMembercontact(String membercontact) {
		this.membercontact = membercontact;
	}
	public String getMemberUsername() {
		return memberUsername;
	}
	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}
	public String getMemberpassword() {
		return memberpassword;
	}
	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}
	public String getCreatedEmpid() {
		return createdEmpid;
	}
	public void setCreatedEmpid(String createdEmpid) {
		this.createdEmpid = createdEmpid;
	}
	public String getmemberEmail() {
		return memberEmail;
	}
	public void setmemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getCreatedEmpname() {
		return createdEmpname;
	}
	public void setCreatedEmpname(String createdEmpname) {
		this.createdEmpname = createdEmpname;
	}
	
}
