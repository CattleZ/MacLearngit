package entity;


public class teacher {
public int tid;
public String tname;
public String tuser;
public String tpwd;
public int tage;
public String tgender;
public int score;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTuser() {
	return tuser;
}
public void setTuser(String tuser) {
	this.tuser = tuser;
}
public String getTpwd() {
	return tpwd;
}
public void setTpwd(String tpwd) {
	this.tpwd = tpwd;
}
public int getTage() {
	return tage;
}
public void setTage(int tage) {
	this.tage = tage;
}
public String getTgender() {
	return tgender;
}
public void setTgender(String tgender) {
	this.tgender = tgender;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public teacher(int tid, String tname, String tuser, String tpwd, int tage, String tgender, int score) {
	super();
	this.tid = tid;
	this.tname = tname;
	this.tuser = tuser;
	this.tpwd = tpwd;
	this.tage = tage;
	this.tgender = tgender;
	this.score = score;
}
public teacher() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "teacher [tid=" + tid + ", tname=" + tname + ", tuser=" + tuser + ", tpwd=" + tpwd + ", tage=" + tage
			+ ", tgender=" + tgender + ", score=" + score + "]";
}

}
