package com.example.namdhpk00594_asm;

import java.util.ArrayList;

import Adapter.com.StudentAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import model.com.Connect_DB;
import model.com.StudentDB;

public class QLSV extends Activity {
	View imgThemSV;
	ListView listViewStudent;
	ArrayList<StudentDB> danhsachsv = null;
	StudentAdapter studentadapter;
	Connect_DB dbsv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__qlsv);
			dbsv=new Connect_DB(this);
			listViewStudent = (ListView) findViewById(R.id.listViewSV);	
//			dbsv.addStudent(new StudentDB("maSV", "tenSV", "nganhHoc", "tenLop", "ngaySinh", 1, "Nam"));
			danhsachsv = dbsv.GetAllStudentDB();
			studentadapter = new StudentAdapter(getApplicationContext(),R.layout.row_student,danhsachsv);
			listViewStudent.setAdapter(studentadapter);
		
			imgThemSV = findViewById(R.id.imgThemSV);
			
			imgThemSV.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					dialogThemSV();
				}
			});
			
			listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					dialogSuaSV(danhsachsv.get(arg2).getID_SV());
				}
			});
			
			listViewStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					dialogXoaSV(danhsachsv.get(arg2).getID_SV());
					return false;
				}
			});
	}
	
	StudentDB sv = new StudentDB(); 
	Dialog dialogSuaSV;
	public void dialogSuaSV(final int id){
		dialogSuaSV = new Dialog(QLSV.this);
		dialogSuaSV.setTitle("Sửa thông tin sinh viên");
		dialogSuaSV.setContentView(R.layout.dialog_suasv);
		sv.setID_SV(id);
		final EditText txtSuaMaSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaMaSV);
		final EditText txtSuaTenSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaTenSV);
		final EditText txtSuaNganhHoc = (EditText) dialogSuaSV.findViewById(R.id.txtSuaNganhHoc);
		final EditText txtSuaTenLopSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaLopHoc);
		final EditText txtSuaNgaySinh = (EditText) dialogSuaSV.findViewById(R.id.txtSuaNgaySinh);
		final EditText txtSuaGioiTinh = (EditText) dialogSuaSV.findViewById(R.id.txtSuaGioiTinh);
		
		Button btnOKSuaSV = (Button)dialogSuaSV.findViewById(R.id.btnOKSuaSV);
		Button btnThoatSuaSV = (Button)dialogSuaSV.findViewById(R.id.btnThoatSuaSV);
		
		btnOKSuaSV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				sv.setMaSV(txtSuaMaSV.getText().toString());
				sv.setTenSV(txtSuaTenSV.getText().toString());
				sv.setNganhHoc(txtSuaNganhHoc.getText().toString());
				sv.setTenLop(txtSuaTenLopSV.getText().toString());
				sv.setNgaySinh(txtSuaNgaySinh.getText().toString());
				sv.setGioiTinh(txtSuaGioiTinh.getText().toString());
				dbsv.updateStudent(sv);
				danhsachsv=dbsv.GetAllStudentDB();
				studentadapter.reloadlistSV(danhsachsv);
				listViewStudent.setAdapter(studentadapter);
				Toast.makeText(QLSV.this,"Sửa Thành Công", Toast.LENGTH_LONG).show();
				dialogSuaSV.dismiss();
			}
		});
		
		btnThoatSuaSV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialogSuaSV.dismiss();
			}
		});
		dialogSuaSV.show();
	}
	
	public void dialogXoaSV(final int id){
		AlertDialog.Builder delSV = new AlertDialog.Builder(QLSV.this);
		delSV.setTitle("Thông báo");
		delSV.setMessage("Bạn có muốn xóa không?");
		sv.setID_SV(id);
		delSV.setPositiveButton("Có", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				deleteSV(which);
				dialog.cancel();
			}
		});
		delSV.setNegativeButton("Không", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();
			}
		});
		delSV.show();
	}
	
	public void dialogThemSV(){
		dialogSuaSV = new Dialog(QLSV.this);
		dialogSuaSV.setTitle("Thêm sinh viên");
		dialogSuaSV.setContentView(R.layout.dialog_suasv);
		final EditText txtSuaMaSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaMaSV);
		final EditText txtSuaTenSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaTenSV);
		final EditText txtSuaNganhHoc = (EditText) dialogSuaSV.findViewById(R.id.txtSuaNganhHoc);
		final EditText txtSuaTenLopSV = (EditText) dialogSuaSV.findViewById(R.id.txtSuaLopHoc);
		final EditText txtSuaNgaySinh = (EditText) dialogSuaSV.findViewById(R.id.txtSuaNgaySinh);
		final EditText txtSuaGioiTinh = (EditText) dialogSuaSV.findViewById(R.id.txtSuaGioiTinh);
		
		Button btnOKSuaSV = (Button)dialogSuaSV.findViewById(R.id.btnOKSuaSV);
		Button btnThoatSuaSV = (Button)dialogSuaSV.findViewById(R.id.btnThoatSuaSV);
		
		btnOKSuaSV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				sv.setMaSV(txtSuaMaSV.getText().toString());
				sv.setTenSV(txtSuaTenSV.getText().toString());
				sv.setNganhHoc(txtSuaNganhHoc.getText().toString());
				sv.setTenLop(txtSuaTenLopSV.getText().toString());
				sv.setNgaySinh(txtSuaNgaySinh.getText().toString());
				sv.setGioiTinh(txtSuaGioiTinh.getText().toString());
				dbsv.addStudent(sv);
				danhsachsv=dbsv.GetAllStudentDB();
				studentadapter = new StudentAdapter(getApplicationContext(),R.layout.row_student,danhsachsv);
				listViewStudent.setAdapter(studentadapter);
				Toast.makeText(QLSV.this,"Thêm Thành Công", Toast.LENGTH_LONG).show();
				dialogSuaSV.dismiss();
			}
		});
		
		btnThoatSuaSV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialogSuaSV.dismiss();
			}
		});
		dialogSuaSV.show();
	}
	
	public void deleteSV(int id){
		dbsv.deleteStudent(sv);
		danhsachsv=dbsv.GetAllStudentDB();
		studentadapter = new StudentAdapter(getApplicationContext(),R.layout.row_student,danhsachsv);
		listViewStudent.setAdapter(studentadapter);
		Toast.makeText(QLSV.this,"Đã xóa", Toast.LENGTH_LONG).show();
	}

}
