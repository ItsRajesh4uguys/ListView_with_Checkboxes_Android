package com.rajesh.getselecteditem;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<Position> listitems = new ArrayList<Position>();
	ListAdapter listAdapter;
    ListView lvMain ;
	Button buttoncheckall,buttonuncheckall;
	  /** Called when the activity is first created. */
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	     lvMain = (ListView) findViewById(R.id.listview);
	    buttoncheckall=(Button)findViewById(R.id.buttoncheckall); 
		 buttonuncheckall=(Button)findViewById(R.id.buttonuncheckall);    
		 
		 buttonuncheckall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				for(int i=0; i < lvMain.getChildCount(); i++){
					LinearLayout itemLayout = (LinearLayout)lvMain.getChildAt(i);
				    CheckBox cb = (CheckBox)itemLayout.findViewById(R.id.cbBox);
				    cb.setChecked(false);
				}
				
				
				
			}  
		});
		 buttoncheckall.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					for(int i=0; i < lvMain.getChildCount(); i++){
						LinearLayout itemLayout = (LinearLayout)lvMain.getChildAt(i);
					    CheckBox cb = (CheckBox)itemLayout.findViewById(R.id.cbBox);
					    cb.setChecked(true);
					}
					
					
					
					
				}
			});
		 
		 

	    arraylistvalueadding();
	    listAdapter = new ListAdapter(this, listitems);

	    
	    lvMain.setAdapter(listAdapter);
	  }

	  void arraylistvalueadding() {
	    for (int i = 1; i <= 20; i++) {
	    	listitems.add(new Position(i,false));
	    }
	  }

	  public void GetSelectedPositions(View v) {
	    String result = "Selected Position is";
	   // result += "\n" + p.position;
	    for (Position p : listAdapter.getcheckedposition()) {
	      if (p.ischeckedflag){
	  // int pp= p.position;
	    	  result += "," + p.position;
	  
	        
	      }
	    }
	    Toast.makeText(this, result, 500).show();
	  }
	}