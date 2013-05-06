package com.rajesh.getselecteditem;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	Context ctx;
	LayoutInflater lInflater;
	ArrayList<Position> arraylist;

	ListAdapter(Context context, ArrayList<Position> products) {
		ctx = context;
		arraylist = products;
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return arraylist.size();
	}

	@Override
	public Object getItem(int position) {
		return arraylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.item, parent, false);
		}

		Position pos = getselectedposition(position);
		((TextView) view.findViewById(R.id.Textview1)).setText(pos.position);
		CheckBox chkbox = (CheckBox) view.findViewById(R.id.cbBox);
		chkbox.setOnCheckedChangeListener(myCheckChangList);
		chkbox.setTag(position);
		chkbox.setChecked(pos.ischeckedflag);
		return view;
	}

	Position getselectedposition(int position) {
		return ((Position) getItem(position));
	}

	ArrayList<Position> getcheckedposition() {
		ArrayList<Position> checkedposition = new ArrayList<Position>();
		for (Position p : arraylist) {
			if (p.ischeckedflag)
				checkedposition.add(p);
		}
		return checkedposition;
	}

	OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			getselectedposition((Integer) buttonView.getTag()).ischeckedflag = isChecked;
		}
	};
}