package org.goclib.android.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.goclib.android.utils.cons.SQLiteConst;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SampleSQLiteHelper extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	private String name="";
	private String path="";
	private Context context=null;
	
	public SampleSQLiteHelper(Context context, String name, CursorFactory factory,String path) {
		super(context, name, null, SQLiteConst.VERSION);
		this.setName(name);
		this.setPath(path);
		this.context=context;
		// TODO Auto-generated constructor stub
	}
	public SampleSQLiteHelper(Context context,String name,CursorFactory factory){
		this(context,name,factory,ApplicationUtils.getApplicationDBPath(context));
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
	public void createDB() throws IOException {
		boolean exist;
	}
	
	public boolean checkDB(){
		try{
			db=SQLiteDatabase.openDatabase(getPath()+getName(), null, SQLiteDatabase.OPEN_READONLY);
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(db!=null)
			db.close();
		return db!=null;
	}
	public void copyDB(InputStream input) throws IOException{
		if(input==null)
			throw new NullPointerException("input stream");
		try{
			FileOutputStream fos = new FileOutputStream(getPath()+getName());
			try{
				int count=0;
				byte[] buffer = new byte[1024];
				while((count = input.read(buffer))>0){
					fos.write(buffer);
				}
			}finally{
				fos.close();
			}
		}finally{
			input.close();
		}
		//String 
	}
	public synchronized void close(){
		if(db!=null)
			db.close();
		super.close();
	}
	public void openDB()throws SQLException{
		 String myPath = getPath()+getName();
	     db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
