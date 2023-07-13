package backendWeb.z01_vo;

public class Team {
	private String tname;
	private int win;
	private int def;
	public Team() {
		// TODO Auto-generated constructor stub
	}
	public Team(String tname, int win, int def) {
		this.tname = tname;
		this.win = win;
		this.def = def;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	
}
