package com.eror.project8;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {
	
	SQLiteDatabase database;
	DatabaseOpenHelper dbHelper;
	
	public DatabaseAdapter(Context context)
	{
		dbHelper = new DatabaseOpenHelper(context);
	}
	
	public void open()
	{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close()
	{
		database.close();
	}
	
	
	public long insertContact(String name, String email, String contact)
	{
		ContentValues cv = new ContentValues();
		cv.put(DatabaseOpenHelper.COLUMN_NAME, name);
		cv.put(DatabaseOpenHelper.COLUMN_Email, email);
		cv.put(DatabaseOpenHelper.COLLUMN_ADDRESS, contact);
		
		return database.insert(DatabaseOpenHelper.CONTACT, "", cv);
		
	}

	public ArrayList<Contacts> getContacts() {
		
		ArrayList<Contacts> contacts = new ArrayList<Contacts>();
		String columns[] = {DatabaseOpenHelper.COLUMN_NAME,
				DatabaseOpenHelper.COLLUMN_ADDRESS,
				DatabaseOpenHelper.COLUMN_Email};
		
		Cursor cursor = database.query(DatabaseOpenHelper.DB_NAME, columns, null, null, null, null, null);
		if(cursor.getCount() > 0)
		{
			cursor.moveToFirst();
			
			
			for(int i=0; i<cursor.getCount(); i++)
			{
				String id = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.COLUMN_ID));
				String name = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.COLUMN_NAME));
				String address = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.COLLUMN_ADDRESS));
				String email = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.COLUMN_Email));
			
				Contacts c = new Contacts(name, address, email);
				contacts.add(c);
				cursor.moveToNext();
			}
		}
		cursor.close();
		
		
		return contacts;		
	}
	
	
}
