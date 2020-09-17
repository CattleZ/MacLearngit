package entity;

public class student {
public int sid ;
public String sname;
public String spwd;
public int classid;
public String sgender;
public int sage;
public String saddress;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSpwd() {
	return spwd;
}
public void setSpwd(String spwd) {
	this.spwd = spwd;
}
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public String getSgender() {
	return sgender;
}
public void setSgender(String sgender) {
	this.sgender = sgender;
}
public int getSage() {
	return sage;
}
public void setSage(int sage) {
	this.sage = sage;
}
public String getSaddress() {
	return saddress;
}
public void setSaddress(String saddress) {
	this.saddress = saddress;
}
public student(int sid, String sname, String spwd, int classid, String sgender, int sage, String saddress) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.spwd = spwd;
	this.classid = classid;
	this.sgender = sgender;
	this.sage = sage;
	this.saddress = saddress;
}
public student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "student [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd + ", classid=" + classid + ", sgender="
			+ sgender + ", sage=" + sage + ", saddress=" + saddress + "]";
}


	
	
}
