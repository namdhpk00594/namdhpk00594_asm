package model.com;

public class ClassDB {
	private int ID;
	private String MaLop;
	private String TenLop;
	
	public ClassDB() {
		super();
	}
	
	public ClassDB( String maLop, String tenLop) {
		super();
		MaLop = maLop;
		TenLop = tenLop;
	}
	
	public ClassDB(int iD, String maLop, String tenLop) {
		super();
		ID = iD;
		MaLop = maLop;
		TenLop = tenLop;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	
	

}
