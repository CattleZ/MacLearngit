package entity;

public class Score {
public int sid;
public String scient;
public int term1;
public int term2;
public int term3;
public int term4;
public int term5;
public int term6;
public int term7;
public int term8;
public int term9;
public int term10;
public String others;
public Score() {
	super();
	// TODO Auto-generated constructor stub
}

public Score(int sid, String scient, int term1, int term2, int term3, int term4, int term5, int term6, int term7,
		int term8, int term9, int term10, String others) {
	super();
	this.sid = sid;
	this.scient = scient;
	this.term1 = term1;
	this.term2 = term2;
	this.term3 = term3;
	this.term4 = term4;
	this.term5 = term5;
	this.term6 = term6;
	this.term7 = term7;
	this.term8 = term8;
	this.term9 = term9;
	this.term10 = term10;
	this.others = others;
}

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getScient() {
	return scient;
}
public void setScient(String scient) {
	this.scient = scient;
}
public int getTerm1() {
	return term1;
}
public void setTerm1(int term1) {
	this.term1 = term1;
}
public int getTerm2() {
	return term2;
}
public void setTerm2(int term2) {
	this.term2 = term2;
}
public int getTerm3() {
	return term3;
}
public void setTerm3(int term3) {
	this.term3 = term3;
}
public int getTerm4() {
	return term4;
}
public void setTerm4(int term4) {
	this.term4 = term4;
}
public int getTerm5() {
	return term5;
}
public void setTerm5(int term5) {
	this.term5 = term5;
}
public int getTerm6() {
	return term6;
}
public void setTerm6(int term6) {
	this.term6 = term6;
}
public int getTerm7() {
	return term7;
}
public void setTerm7(int term7) {
	this.term7 = term7;
}
public int getTerm8() {
	return term8;
}
public void setTerm8(int term8) {
	this.term8 = term8;
}
public int getTerm9() {
	return term9;
}
public void setTerm9(int term9) {
	this.term9 = term9;
}
public int getTerm10() {
	return term10;
}
public void setTerm10(int term10) {
	this.term10 = term10;
}
public String getOthers() {
	return others;
}
public void setOthers(String others) {
	this.others = others;
}
@Override
public String toString() {
	return "Score [sid=" + sid + ", scient=" + scient + ", term1=" + term1 + ", term2=" + term2 + ", term3=" + term3
			+ ", term4=" + term4 + ", term5=" + term5 + ", term6=" + term6 + ", term7=" + term7 + ", term8=" + term8
			+ ", term9=" + term9 + ", term10=" + term10 + ", others=" + others + "]";
}


}
