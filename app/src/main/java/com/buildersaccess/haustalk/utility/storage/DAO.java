package com.buildersaccess.haustalk.utility.storage;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.buildersaccess.haustalk.model.entity.Login;
import com.buildersaccess.haustalk.model.entity.Req_login;

/**
 * Created by pangg_000 on 1/27/2016.
 */
public class DAO {
/*

    public static void createDB(Activity activity) {
        // 创建了一个DatabaseHelper对象，只执行这句话是不会创建或打开连接的
        SQLiteHelper dbHelper = new SQLiteHelper(activity, "Haustalk_db");
        // 只有调用了DatabaseHelper的getWritableDatabase()方法或者getReadableDatabase()方法之后，才会创建或打开一个连接
        SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
    }
*/

    public static void saveAccount(Activity activity,Req_login req_login) {
        // 创建一个DatabaseHelper对象
        SQLiteHelper dbHelper = new SQLiteHelper(activity,
                "Haustalk_db", 2);
        // 得到一个可写的SQLiteDatabase对象
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        // 创建一个ContentValues对象
        ContentValues values = new ContentValues();
        values.put("id", 0);
        values.put("email", req_login.getEmail());
        values.put("password", req_login.getPassword());
        // 调用update方法
        // 第一个参数String：表名
        // 第二个参数ContentValues：ContentValues对象
        // 第三个参数String：where字句，相当于sql语句where后面的语句，？号是占位符
        // 第四个参数String[]：占位符的值
        try {
            sqliteDatabase.update("Account", values, "id=?", new String[]{"0"});
        }catch (Exception e){
            Log.v("SQLite", e.getMessage());
        }
    }

    public static void cleanPassword(Activity activity ) {
        String email=null;
        // 创建一个DatabaseHelper对象
        SQLiteHelper dbHelper = new SQLiteHelper(activity,
                "Haustalk_db", 2);
        // 得到一个可写的SQLiteDatabase对象
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        try {
            Cursor cursor = sqliteDatabase.query("Account", new String[]{"id",
                    "email"}, "id=?", new String[]{"0"}, null, null, null);
            // 将光标移动到下一行，从而判断该结果集是否还有下一条数据，如果有则返回true，没有则返回false
            while (cursor.moveToNext()) {
                email = cursor.getString(cursor.getColumnIndex("email"));
            }

            // 创建一个ContentValues对象
            ContentValues values = new ContentValues();
            values.put("email", email);
            values.put("password", "");
            // 调用update方法
            // 第一个参数String：表名
            // 第二个参数ContentValues：ContentValues对象
            // 第三个参数String：where字句，相当于sql语句where后面的语句，？号是占位符
            // 第四个参数String[]：占位符的值
            sqliteDatabase.update("Account", values, "id=?", new String[]{"0"});
        }catch (Exception e){
            Log.v("SQLite", e.getMessage());
        }
    }


    public static Req_login getAccount(Activity activity){
        Req_login req_login = new Req_login();
        //String id = null;
        String email = "";
        String password="";
        //创建DatabaseHelper对象
        SQLiteHelper dbHelper = new SQLiteHelper(activity,"Haustalk_db", 2);
        // 得到一个只读的SQLiteDatabase对象
        SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
        // 调用SQLiteDatabase对象的query方法进行查询，返回一个Cursor对象：由数据库查询返回的结果集对象
        // 第一个参数String：表名
        // 第二个参数String[]:要查询的列名
        // 第三个参数String：查询条件
        // 第四个参数String[]：查询条件的参数
        // 第五个参数String:对查询的结果进行分组
        // 第六个参数String：对分组的结果进行限制
        // 第七个参数String：对查询的结果进行排序
        try {
            Cursor cursor = sqliteDatabase.query("Account", new String[]{"id",
                    "email", "password"}, "id=?", new String[]{"0"}, null, null, null);
            // 将光标移动到下一行，从而判断该结果集是否还有下一条数据，如果有则返回true，没有则返回false
            while (cursor.moveToNext()) {
                //id = cursor.getString(cursor.getColumnIndex("id"));
                email = cursor.getString(cursor.getColumnIndex("email"));
                password = cursor.getString(cursor.getColumnIndex("password"));
            }
        }catch (Exception e){
            Log.v("SQLite", e.getMessage());
        }
        if(email!=null ){
            req_login.setEmail(email);
        }
        if(password!=null){
            req_login.setPassword(password);
        }

        return req_login;
    }
}


