package com.eror.project8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	
	public static String DB_NAME = "ContactDetails.db";
	public static String CONTACT = "contact";
	public static String COLUMN_NAME = "name";
	public static String COLUMN_ID = "id";
	public static String COLLUMN_ADDRESS = "address";
	public static String COLUMN_Email = "email";
	
	
	public static String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS "
											+ CONTACT
											+ " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
											+ "name TEXT, "
											+ "address TEXT, "
											+ "email TEXT);";
	
	
	public DatabaseOpenHelper(Context context)
	{
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		
		database.execSQL(CREATE_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}

}
