package com.uee.riyasewana.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uee.riyasewana.model.Vehicle;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "riyasewana.db";
    public static final String TABLE = "vehicle";
    public static final String imageDrawable = "IMAGE_DRAWABLE";
    public static final String imageWideDrawable = "IMAGE_WIDE_DRAWABLE";
    public static final String id = "ID";
    public static final String name = "NAME";
    public static final String price = "PRICE";
    public static final String location = "LOCATION";
    public static final String telephone = "TELEPHONE";
    public static final String email = "EMAIL";
    public static final String description = "DESCRIPTION";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + name + " TEXT, " + price + " TEXT, " + location + " TEXT, " + email + " TEXT, " + telephone + " TEXT, " + imageDrawable + " INTEGER, " + imageWideDrawable + " INTEGER," + description + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insert(Vehicle vehicle) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(imageDrawable, vehicle.getImageDrawable());
        contentValues.put(imageWideDrawable, vehicle.getImageWideDrawable());
        contentValues.put(name, vehicle.getName());
        contentValues.put(price, vehicle.getPrice());
        contentValues.put(location, vehicle.getLocation());
        contentValues.put(email, vehicle.getEmail());
        contentValues.put(description, vehicle.getDescription());
        contentValues.put(telephone, vehicle.getTelephone());

        return db.insert(TABLE, null, contentValues) != -1;

    }

    public ArrayList<Vehicle> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE, null);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        while (result.moveToNext()) {

            Vehicle vehicle = new Vehicle();

            vehicle.setId(result.getInt(result.getColumnIndex(id)));
            vehicle.setImageDrawable(result.getInt(result.getColumnIndex(imageDrawable)));
            vehicle.setImageWideDrawable(result.getInt(result.getColumnIndex(imageWideDrawable)));
            vehicle.setName(result.getString(result.getColumnIndex(name)));
            vehicle.setEmail(result.getString(result.getColumnIndex(email)));
            vehicle.setDescription(result.getString(result.getColumnIndex(description)));
            vehicle.setPrice(result.getString(result.getColumnIndex(price)));
            vehicle.setLocation(result.getString(result.getColumnIndex(location)));
            vehicle.setTelephone(result.getString(result.getColumnIndex(telephone)));

            vehicles.add(vehicle);

        }

        result.close();
        return vehicles;

    }

}
