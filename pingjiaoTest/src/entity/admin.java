package entity;

public class admin {
private int admin_count;
private int admin_id;
private String admin_name;
private String admin_pwd;
public admin() {
	super();
	// TODO Auto-generated constructor stub
}
public admin(int admin_count, int admin_id, String admin_name, String admin_pwd) {
	super();
	this.admin_count = admin_count;
	this.admin_id = admin_id;
	this.admin_name = admin_name;
	this.admin_pwd = admin_pwd;
}
public int getAdmin_count() {
	return admin_count;
}
public void setAdmin_count(int admin_count) {
	this.admin_count = admin_count;
}
public int getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(int admin_id) {
	this.admin_id = admin_id;
}
public String getAdmin_name() {
	return admin_name;
}
public void setAdmin_name(String admin_name) {
	this.admin_name = admin_name;
}
public String getAdmin_pwd() {
	return admin_pwd;
}
public void setAdmin_pwd(String admin_pwd) {
	this.admin_pwd = admin_pwd;
}
@Override
public String toString() {
	return "admin [admin_count=" + admin_count + ", admin_id=" + admin_id + ", admin_name=" + admin_name
			+ ", admin_pwd=" + admin_pwd + "]";
}
}
