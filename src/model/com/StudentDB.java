package model.com;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.icu.text.DateFormat;

public class StudentDB {

	private int ID_SV;
	private String MaSV;
	private String TenSV;
	private String NganhHoc;
	private String GioiTinh;
	private String NgaySinh;
	private int ID_Lop;
	private String TenLop;
	
	
	public StudentDB(){		
	}

	public StudentDB(String maSV, String tenSV, String nganhHoc, String tenLop,String ngaySinh, int iD_Lop,
			String gioiTinh) {
		super();
		MaSV = maSV;
		TenSV = tenSV;
		NganhHoc = nganhHoc;
		GioiTinh = gioiTinh;
		NgaySinh=ngaySinh;
		ID_Lop = iD_Lop;
		TenLop = tenLop;
	}
	
	public int getID_SV() {
		return ID_SV;
	}

	public void setID_SV(int iD_SV) {
		ID_SV = iD_SV;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public String getNganhHoc() {
		return NganhHoc;
	}

	public void setNganhHoc(String nganhHoc) {
		NganhHoc = nganhHoc;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}
	public String getStringNgaySinh(){
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public void setNgaySinhString (String stringNgaySinh){
		try{
			NgaySinh= stringNgaySinh;		
		}catch(Exception e){
			
		}
	}
	
	public int getID_Lop() {
		return ID_Lop;
	}

	public void setID_Lop(int iD_Lop) {
		ID_Lop = iD_Lop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	
}
