package entity;

public class Tclass {
	public int classid;
	public String classname;
	public int cteacherid;
	public int cmathid;
	public int cchinaid;
	public int cEnglishid;
	public int ctotal;
	public int did;
	public Tclass(int classid, String classname, int cteacherid, int cmathid, int cchinaid, int cEnglishid, int ctotal,
			int did) {
		super();
		this.classid = classid;
		this.classname = classname;
		this.cteacherid = cteacherid;
		this.cmathid = cmathid;
		this.cchinaid = cchinaid;
		this.cEnglishid = cEnglishid;
		this.ctotal = ctotal;
		this.did = did;
	}
	public Tclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tclass [classid=" + classid + ", classname=" + classname + ", cteacherid=" + cteacherid + ", cmathid="
				+ cmathid + ", cchinaid=" + cchinaid + ", cEnglishid=" + cEnglishid + ", ctotal=" + ctotal + ", did="
				+ did + "]";
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getCteacherid() {
		return cteacherid;
	}
	public void setCteacherid(int cteacherid) {
		this.cteacherid = cteacherid;
	}
	public int getCmathid() {
		return cmathid;
	}
	public void setCmathid(int cmathid) {
		this.cmathid = cmathid;
	}
	public int getCchinaid() {
		return cchinaid;
	}
	public void setCchinaid(int cchinaid) {
		this.cchinaid = cchinaid;
	}
	public int getcEnglishid() {
		return cEnglishid;
	}
	public void setcEnglishid(int cEnglishid) {
		this.cEnglishid = cEnglishid;
	}
	public int getCtotal() {
		return ctotal;
	}
	public void setCtotal(int ctotal) {
		this.ctotal = ctotal;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	

}
