package manhinhquanly.com;

import java.util.ArrayList;

import com.example.namdhpk00594_asm.R;
import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import model.com.ClassDB;
import model.com.Connect_DB;

public class MainActivity extends Activity {
	Button btnXemDS, btnQLSV, btnAboutMe;
	Connect_DB db;
	final ClassDB lop=new ClassDB();
	ListView listViewClass;
	ArrayList<ClassDB> danhsachlop=null;
	SimpleSideDrawer slide_me;
	View imgMenu;
	TextView txt1, txt2, txt3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		slide_me = new SimpleSideDrawer(this);
		slide_me.setLeftBehindContentView(R.layout.left_menu);
		
		imgMenu = findViewById(R.id.imgMenu);
		txt1 = (TextView) findViewById(R.id.txtSdt);
		txt2 = (TextView) findViewById(R.id.txt2);
		txt3 = (TextView) findViewById(R.id.txt3);
		btnXemDS = (Button)findViewById(R.id.btnXemDS);
		btnQLSV = (Button)findViewById(R.id.btnQLSV);
		btnAboutMe = (Button) findViewById(R.id.btnAboutMe);
		
		btnAboutMe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AboutMe.class);
				startActivity(intent);
				
			}
		});
		
		imgMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				slide_me.toggleLeftDrawer();
			}
		});
		txt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),DanhSachLop.class);
				startActivity(intent);
			}
		});
		txt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),QLSV.class);
				startActivity(intent);
			}
		});
		txt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AboutMe.class);
				startActivity(intent);			
			}
		});
		
		
		
		btnXemDS.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				Intent denTrangDanhSach = new Intent(MainActivity.this,DanhSachLop.class);
				startActivity(denTrangDanhSach);
			}
		});
		
		btnQLSV.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				Intent denQLSV = new Intent(MainActivity.this, QLSV.class);
				startActivity(denQLSV);
			}
		});
	}

	
}
