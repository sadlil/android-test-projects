package com.eror.project8;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowAllContacts extends ListActivity {

	DatabaseAdapter dbadapter;
	ArrayList<Contacts> contacts;
	ListView listView;
	MyArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_list_layout);
		
		
		
		dbadapter = new DatabaseAdapter(getApplicationContext());
		dbadapter.open();
		contacts = dbadapter.getContacts();
		dbadapter.close();
		
		listView = (ListView) findViewById(R.id.listView);
		adapter = new MyArrayAdapter(getApplicationContext(), R.layout.list_row, R.id.tvName, contacts);
		setListAdapter(adapter);
		
	}
	
	

public class MyArrayAdapter extends ArrayAdapter<Contacts> {

	ArrayList<Contacts> lists;
	Context context;
	
	public MyArrayAdapter(Context context, int resource, int textViewResourceId, ArrayList<Contacts> objects) {
	
		super(context, resource, textViewResourceId, objects);
		this.lists = objects;
		this.context = context;	
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		
		if(convertView == null)
			{
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
				v = inflater.inflate(R.layout.list_row, parent, false);
			}
		
		TextView tvName = (TextView) v.findViewById(R.id.tvName);
		TextView tvEmail = (TextView) v.findViewById(R.id.tvEmail);
		TextView tvContact = (TextView) v.findViewById(R.id.tvContact);
		
		Contacts c = (Contacts) this.lists.get(position);
		tvName.setText(c.getName());
		tvEmail.setText(c.getEmail());
		tvName.setText(c.getAddress());
		
		return v;
	}
}

	
	
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		String s = getListAdapter().getItem(position).toString();
		Toast.makeText(getApplicationContext(), "You Selected : " + s, Toast.LENGTH_LONG).show();
		
	}




	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);
		
		
	}
	
	
	

}
