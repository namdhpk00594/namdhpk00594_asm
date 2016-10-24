package Adapter.com;

import java.util.ArrayList;
import java.util.List;

import com.example.namdhpk00594_asm.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import model.com.ClassDB;
import model.com.StudentDB;

public class StudentAdapter extends ArrayAdapter<StudentDB>{

	List<StudentDB> list;
	public StudentAdapter(Context context, int resource, List<StudentDB> objects) {
		super(context, resource, objects);
		list=objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View viewSv = convertView;
		LayoutInflater inflater =LayoutInflater.from(getContext());
		viewSv = inflater.inflate(R.layout.row_student, null);
		
		StudentDB row_student = new StudentDB();
		row_student=list.get(position);
		
		TextView MaSV = (TextView)viewSv.findViewById(R.id.textViewMaSV);
		TextView TenSV = (TextView)viewSv.findViewById(R.id.textViewTenSV);
		TextView NganhHoc = (TextView)viewSv.findViewById(R.id.textViewNganhHoc);
		TextView LopHoc = (TextView)viewSv.findViewById(R.id.textViewTenLopsv);
		TextView NgaySinh = (TextView)viewSv.findViewById(R.id.textViewNgaySinh);
		TextView GioiTinh = (TextView)viewSv.findViewById(R.id.textViewGioiTinh);
		
		MaSV.setText(row_student.getMaSV());
		TenSV.setText(row_student.getTenSV());
		NganhHoc.setText(row_student.getNganhHoc());
		LopHoc.setText(row_student.getTenLop());
		NgaySinh.setText(row_student.getNgaySinh());
		GioiTinh.setText(row_student.getGioiTinh());
		
		return viewSv;
	}
	public void reloadlistSV(ArrayList<StudentDB> newlist){
		list=newlist;
		notifyDataSetChanged();
	}
	
}
