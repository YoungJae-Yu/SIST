package backWeb.saram_vo;

public class Resume {
    private int resumeld;
    private int memberld;
    private String memUny;
    private String memCareer;
    private String memCertif;
    private String memLang;
    private String memMilitary;
    private int hopeSal;
    private String hopeArea;
    private String hopeWorktype;
    
    public Resume(int resumeld, int memberld, String memUny, String memCareer, String memCertif,
                  String memLang, String memMilitary, int hopeSal, String hopeArea, String hopeWorktype) {
        this.resumeld = resumeld;
        this.memberld = memberld;
        this.memUny = memUny;
        this.memCareer = memCareer;
        this.memCertif = memCertif;
        this.memLang = memLang;
        this.memMilitary = memMilitary;
        this.hopeSal = hopeSal;
        this.hopeArea = hopeArea;
        this.hopeWorktype = hopeWorktype;
    }
    public Resume(String memCareer, String hopeArea) {
		super();
		this.memCareer = memCareer;
		this.hopeArea = hopeArea;
	}
	public Resume(String hopeArea) {
	super();
	this.hopeArea = hopeArea;
    }
	public int getResumeld() {
        return resumeld;
    }

    public void setResumeld(int resumeld) {
        this.resumeld = resumeld;
    }

    public int getMemberld() {
        return memberld;
    }

    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }

    public String getMemUny() {
        return memUny;
    }

    public void setMemUny(String memUny) {
        this.memUny = memUny;
    }

    public String getMemCareer() {
        return memCareer;
    }

    public void setMemCareer(String memCareer) {
        this.memCareer = memCareer;
    }

    public String getMemCertif() {
        return memCertif;
    }

    public void setMemCertif(String memCertif) {
        this.memCertif = memCertif;
    }

    public String getMemLang() {
        return memLang;
    }

    public void setMemLang(String memLang) {
        this.memLang = memLang;
    }

    public String getMemMilitary() {
        return memMilitary;
    }

    public void setMemMilitary(String memMilitary) {
        this.memMilitary = memMilitary;
    }

    public int getHopeSal() {
        return hopeSal;
    }

    public void setHopeSal(int hopeSal) {
        this.hopeSal = hopeSal;
    }

    public String getHopeArea() {
        return hopeArea;
    }

    public void setHopeArea(String hopeArea) {
        this.hopeArea = hopeArea;
    }

    public String getHopeWorktype() {
        return hopeWorktype;
    }

    public void setHopeWorktype(String hopeWorktype) {
        this.hopeWorktype = hopeWorktype;
    }
}
