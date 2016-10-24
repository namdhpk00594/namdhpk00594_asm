package Adapter.com;

import java.util.ArrayList;
import java.util.List;

import com.example.namdhpk00594_asm.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import model.com.ClassDB;

public class ClassAdapter extends ArrayAdapter<ClassDB>{
	List<ClassDB> ar;
	public ClassAdapter(Context context, int resource, List<ClassDB> objects) {
		super(context, resource, objects);
		ar=objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		LayoutInflater inflater =LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item, null);
		
		ClassDB item = new ClassDB();
		 item = ar.get(position);
		 TextView textViewMaLop = (TextView) view.findViewById(R.id.textViewMaLop);
		 TextView textViewTenLop = (TextView) view.findViewById(R.id.textViewQL);
		 
		 textViewMaLop.setText(item.getMaLop());
		 textViewTenLop.setText(item.getTenLop());
		return view;
	}
	public void reloadlist(ArrayList<ClassDB> newlist){
		ar=newlist;
		notifyDataSetChanged();
	}

	
}
