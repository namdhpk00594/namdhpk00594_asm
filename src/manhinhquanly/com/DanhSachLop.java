package manhinhquanly.com;

import java.util.ArrayList;

import com.example.namdhpk00594_asm.R;

import Adapter.com.ClassAdapter;
import Adapter.com.StudentAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import model.com.ClassDB;
import model.com.Connect_DB;

public class DanhSachLop extends Activity {

	ListView listViewClass;
	ArrayList<ClassDB> danhsachlop=null;
	ClassAdapter classadpter;
	Connect_DB db;
	View imgThemLop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__danhsachlop);
		
		imgThemLop = findViewById(R.id.imgThemLop);
		
		imgThemLop.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				final Dialog dialog = new Dialog(DanhSachLop.this);
				dialog.setContentView(R.layout.dialog_themlop);
				dialog.setTitle("Thêm Lớp");
				
				final EditText txtMaLop = (EditText) dialog.findViewById(R.id.txtMaLop);
				final EditText txtTenLop = (EditText) dialog.findViewById(R.id.txtTenLop);
				Button btnAddClass = (Button) dialog.findViewById(R.id.btnAddClass);
				Button btnThoat = (Button) dialog.findViewById(R.id.btnThoat);
				
				btnAddClass.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {						
						//putExtra
						lop.setMaLop(txtMaLop.getText().toString());
						lop.setTenLop(txtTenLop.getText().toString());
						db.addClass(lop);
						danhsachlop=db.GetAllClassDB();
						classadpter = new ClassAdapter(getApplicationContext(),R.layout.item,danhsachlop);
						listViewClass.setAdapter(classadpter);
						Toast.makeText(DanhSachLop.this,"Thêm thành công", Toast.LENGTH_LONG).show();
						dialog.dismiss();
					}
				});
				
				btnThoat.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});	
				dialog.show();
			}
		});
	        db=new Connect_DB(this);
			listViewClass = (ListView) findViewById(R.id.listViewClass);
				final ClassDB lop = new ClassDB();
				Bundle bundle = getIntent().getExtras();
				if(bundle!=null){
					String malop = bundle.getString("maLop");
					String tenlop = bundle.getString("tenLop");
					lop.setMaLop(malop);
					lop.setTenLop(tenlop);
					db.addClass(lop);
				}
				danhsachlop=db.GetAllClassDB();
				classadpter = new ClassAdapter(getApplicationContext(), R.layout.item, danhsachlop); 
				listViewClass.setAdapter(classadpter);
				
				listViewClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						alertDialog(danhsachlop.get(arg2).getID());
					}
				});
			
			listViewClass.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					deleteDialog(danhsachlop.get(arg2).getID());
					return false;
				}
			});
	}
	
	public void deleteDialog(int id){
		AlertDialog.Builder del = new AlertDialog.Builder(DanhSachLop.this);
		del.setTitle("Thông báo");
		del.setMessage("Bạn có muốn xóa thật không?");
		lop.setID(id);
		del.setPositiveButton("Có", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				deleteClass(arg1);
				arg0.cancel();
			}
		});
		del.setNegativeButton("Không", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		del.show();
	}
	
	ClassDB lop=new ClassDB();
	Dialog dialogSua;
	public void alertDialog(final int id){
		dialogSua = new Dialog(DanhSachLop.this);
		dialogSua.setContentView(R.layout.dialog_sua);
		dialogSua.setTitle("Sửa lớp");
		lop.setID(id);
		final	EditText txtSuaMaLop = (EditText) dialogSua.findViewById(R.id.txtSuaMaSV);
		final	EditText txtSuaTenLop = (EditText) dialogSua.findViewById(R.id.txtSuaTenSV);
		Button btnOKSua = (Button) dialogSua.findViewById(R.id.btnOKSuaSV);
		Button btnThoatSua = (Button) dialogSua.findViewById(R.id.btnThoatSuaSV);
		
		btnOKSua.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lop.setMaLop(txtSuaMaLop.getText().toString());
				lop.setTenLop(txtSuaTenLop.getText().toString());
				db.updateClass(lop);
				danhsachlop=db.GetAllClassDB();
				classadpter.reloadlist(danhsachlop);
				Toast.makeText(DanhSachLop.this, "Sửa Thành Công", Toast.LENGTH_LONG).show();
				dialogSua.dismiss();
			}
		});
		btnThoatSua.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dialogSua.dismiss();
			}
		});
		
		dialogSua.show();
	}
	
	public void deleteClass(int id){
		db.deleteClass(lop);
		danhsachlop=db.GetAllClassDB();
		classadpter = new ClassAdapter(getApplicationContext(), R.layout.item, danhsachlop);
		listViewClass.setAdapter(classadpter);
		Toast.makeText(DanhSachLop.this, "�?ã xóa", Toast.LENGTH_LONG).show();
	}
	
}
