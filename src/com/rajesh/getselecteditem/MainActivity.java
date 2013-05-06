package com.rajesh.getselecteditem;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<Position> listitems = new ArrayList<Position>();
	ListAdapter listAdapter;

	  /** Called when the activity is first created. */
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    arraylistvalueadding();
	    listAdapter = new ListAdapter(this, listitems);

	    ListView lvMain = (ListView) findViewById(R.id.listview);
	    lvMain.setAdapter(listAdapter);
	  }

	  void arraylistvalueadding() {
	    for (int i = 1; i <= 20; i++) {
	    	listitems.add(new Position("Position " + i,false));
	    }
	  }

	  public void GetSelectedPositions(View v) {
	    String result = "Selected Position is";
	   
	    for (Position p : listAdapter.getcheckedposition()) {
	      if (p.ischeckedflag){
	        result += "\n" + p.position;
	        
	      }
	    }
	    Toast.makeText(this, result+"\n", Toast.LENGTH_LONG).show();
	  }
	}