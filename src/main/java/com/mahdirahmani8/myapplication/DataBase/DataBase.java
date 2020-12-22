package com.mahdirahmani8.myapplication.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.Model.Book;
import com.mahdirahmani8.myapplication.Model.Item;
import com.mahdirahmani8.myapplication.Model.Novel;
import com.mahdirahmani8.myapplication.Model.Setting;
import com.mahdirahmani8.myapplication.Model.ar;
import com.mahdirahmani8.myapplication.Model.fa;
import com.mahdirahmani8.myapplication.Model.gr;
import com.mahdirahmani8.myapplication.Model.sp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    private Context context;
    String val = "";
    int size = 0;
    int color = 0;

    public DataBase(Context context) {
        super(context, info_db.DATABASE_NAME, null, info_db.DATABASE_VERSION);
        this.context = context;
        isDataBase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void isDataBase() {
        File check = new File(info_db.PACKAGE);
        if (check.exists()) {

        } else {
            check.mkdir();
        }
        check = context.getDatabasePath(info_db.DATABASE_NAME);
        if (check.exists()) {

        } else {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(info_db.DATABASE_SOURCE);

        String outFileName = info_db.PACKAGE + info_db.DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }


    public List<Item> getItems (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM item";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();

                item.setId(cursor.getInt(cursor.getColumnIndex(info_db.ITEM_ID)));
                item.setName(cursor.getString(cursor.getColumnIndex(info_db.ITEM_NAME)));

                itemList.add(item);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return itemList;
    }

    public List<fa> getFA (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<fa> itemList = new ArrayList<>();
        String query = "SELECT * FROM fa";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                fa item = new fa();

                item.setId(cursor.getInt(cursor.getColumnIndex(info_db.FA_ID)));
                item.setFa(cursor.getString(cursor.getColumnIndex(info_db.FA)));

                itemList.add(item);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return itemList;
    }

    public List<sp> getSP (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<sp> itemList = new ArrayList<>();
        String query = "SELECT * FROM sp";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                sp item = new sp();

                item.setId(cursor.getInt(cursor.getColumnIndex(info_db.SP_ID)));
                item.setSp(cursor.getString(cursor.getColumnIndex(info_db.SP)));

                itemList.add(item);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return itemList;
    }

    public List<gr> getGR (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<gr> itemList = new ArrayList<>();
        String query = "SELECT * FROM gr";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                gr item = new gr();

                item.setId(cursor.getInt(cursor.getColumnIndex(info_db.GR_ID)));
                item.setGr(cursor.getString(cursor.getColumnIndex(info_db.GR)));

                itemList.add(item);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return itemList;
    }

    public List<ar> getAR (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<ar> itemList = new ArrayList<>();
        String query = "SELECT * FROM ar";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                ar item = new ar();

                item.setId(cursor.getInt(cursor.getColumnIndex(info_db.AR_ID)));
                item.setAr(cursor.getString(cursor.getColumnIndex(info_db.AR)));

                itemList.add(item);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return itemList;
    }

    public List<Book> getBooks (int id ,String Lan){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM book WHERE (part = '" + id + "' AND lan = '" + Lan + "');" ;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_ID)));
                book.setName(cursor.getString(cursor.getColumnIndex(info_db.BOOK_NAME)));
                book.setDisc(cursor.getString(cursor.getColumnIndex(info_db.BOOK_DISC)));
                book.setFav(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_FAV)));
                book.setImage(cursor.getString(cursor.getColumnIndex(info_db.BOOK_IMAGE)));
                book.setLan(cursor.getString(cursor.getColumnIndex(info_db.BOOK_LAN)));
                book.setPart(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_PART)));

                bookList.add(book);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return bookList;
    }

    public List<Book> getBooks (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM book ";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_ID)));
                book.setName(cursor.getString(cursor.getColumnIndex(info_db.BOOK_NAME)));
                book.setDisc(cursor.getString(cursor.getColumnIndex(info_db.BOOK_DISC)));
                book.setFav(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_FAV)));
                book.setImage(cursor.getString(cursor.getColumnIndex(info_db.BOOK_IMAGE)));
                book.setLan(cursor.getString(cursor.getColumnIndex(info_db.BOOK_LAN)));
                book.setPart(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_PART)));

                bookList.add(book);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return bookList;
    }




    public List<Novel> getNovel (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Novel> novelList = new ArrayList<>();
        String query = "SELECT * FROM novelBook";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Novel book = new Novel();
                book.setId(cursor.getInt(cursor.getColumnIndex(info_db.NOVEL_ID)));
                book.setIsone(cursor.getString(cursor.getColumnIndex(info_db.NOVEL_ISONE)));
                book.setDisc(cursor.getString(cursor.getColumnIndex(info_db.NOVEL_DISC)));
                book.setFav(cursor.getInt(cursor.getColumnIndex(info_db.NOVEL_FAV)));
                book.setName(cursor.getString(cursor.getColumnIndex(info_db.NOVEL_NAME)));
                book.setImage(cursor.getString(cursor.getColumnIndex(info_db.NOVEL_IMAGE)));

                novelList.add(book);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return novelList;
    }


    public List<Audio> getAudio (){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Audio> audioList = new ArrayList<>();
        String query = "SELECT * FROM audio";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Audio audio = new Audio();
                audio.setId(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_ID)));
                audio.setIsone(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_ISONE)));
                audio.setDisc(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_DISC)));
                audio.setFav(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_FAV)));
                audio.setName(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_NAME)));
                audio.setImage(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_IMAGE)));
                audio.setLan(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_LAN)));
                audio.setPart(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_PART)));

                audioList.add(audio);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return audioList;
    }


    public List<Audio> getAudio (int id , String Lan){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Audio> audioList = new ArrayList<>();
        String query = "SELECT * FROM audio WHERE (part = '" + id + "' AND lan = '" + Lan + "');" ;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Audio audio = new Audio();
                audio.setId(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_ID)));
                audio.setIsone(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_ISONE)));
                audio.setDisc(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_DISC)));
                audio.setFav(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_FAV)));
                audio.setName(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_NAME)));
                audio.setImage(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_IMAGE)));
                audio.setLan(cursor.getString(cursor.getColumnIndex(info_db.AUDIO_LAN)));
                audio.setPart(cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_PART)));

                audioList.add(audio);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return audioList;
    }

    //  Setting
    public List<Setting> getSetting() {

        SQLiteDatabase db = this.getReadableDatabase();
        List<Setting> data = new ArrayList<>();
        String query = "SELECT * FROM setting";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                Setting setting = new Setting();

                setting.setFont(cursor.getInt(cursor.getColumnIndex(info_db.SETTING_FONT)));
                setting.setSize(cursor.getInt(cursor.getColumnIndex(info_db.SETTING_SIZE)));
                setting.setBackground(cursor.getInt(cursor.getColumnIndex(info_db.SETTING_BACKGROUND)));
                setting.setScroll(cursor.getInt(cursor.getColumnIndex(info_db.SETTING_COLOR)));
                setting.setLan(cursor.getString(cursor.getColumnIndex(info_db.SETTING_LAN)));

                data.add(setting);
            } while (cursor.moveToNext());

        }

            cursor.close();
            db.close();

            return data;

    }



    public List<Book> getFav () {

        SQLiteDatabase db = this.getReadableDatabase();
        List<Book> data = new ArrayList<>();
        String query = "SELECT * FROM book WHERE fav = 1";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Book part = new Book();
                part.setId(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_ID)));
//                part.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                part.setName(cursor.getString(cursor.getColumnIndex(info_db.BOOK_NAME)));
//                part.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                part.setDisc(cursor.getString(cursor.getColumnIndex(info_db.BOOK_DISC)));
                part.setImage(cursor.getString(cursor.getColumnIndex(info_db.BOOK_IMAGE)));
                part.setFav(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_FAV)));

                data.add(part);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return data;
    }

    public List<Audio> getAudioFav () {

        SQLiteDatabase db = this.getReadableDatabase();
        List<Audio> data = new ArrayList<>();
        String query = "SELECT * FROM audio WHERE fav = 1";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Audio part = new Audio();
                part.setId(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_ID)));
//                part.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                part.setName(cursor.getString(cursor.getColumnIndex(info_db.BOOK_NAME)));
//                part.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                part.setDisc(cursor.getString(cursor.getColumnIndex(info_db.BOOK_DISC)));
                part.setImage(cursor.getString(cursor.getColumnIndex(info_db.BOOK_IMAGE)));
                part.setFav(cursor.getInt(cursor.getColumnIndex(info_db.BOOK_FAV)));

                data.add(part);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return data;
    }


    public int fav_value(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.BOOK_FAV + " FROM book WHERE " + info_db.BOOK_ID + "=" + id +"";
        int value =0;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            value = cursor.getInt(cursor.getColumnIndex(info_db.BOOK_FAV));

            do {

            }while (cursor.moveToNext());
        }
        db.close();
        return value;
    }



    public int fav_value_Audio(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.AUDIO_FAV + " FROM audio WHERE " + info_db.AUDIO_ID + "=" + id +"";
        int value =0;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            value = cursor.getInt(cursor.getColumnIndex(info_db.AUDIO_FAV));

            do {

            }while (cursor.moveToNext());
        }
        db.close();
        return value;
    }




    public void fav (int status , int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "UPDATE book SET " + info_db.BOOK_FAV + "=" + status + " WHERE " + info_db.BOOK_ID + "=" + id + "";
        db.execSQL(query);
        db.close();
    }

    public void fav_Audio (int status , int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "UPDATE audio SET " + info_db.AUDIO_FAV + "=" + status + " WHERE " + info_db.AUDIO_ID + "=" + id + "";
        db.execSQL(query);
        db.close();
    }

    public int setLan( String lanNew ){
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("UPDATE setting SET "+ info_db.SETTING_LAN.trim() + "= '" + lanNew + "' WHERE " + info_db.SETTING_ID + "=" + "'1'" + "");
        db.close();

        return 1;
    }

    public String lanValue(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.SETTING_LAN + " FROM setting WHERE " + info_db.AUDIO_ID + "='" + 1 +"'";

        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            val = cursor.getString(cursor.getColumnIndex(info_db.SETTING_LAN));

            do {

            }while (cursor.moveToNext());
        }
        db.close();

        return val;
    }

    public void sizeValue( int newSize){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE setting SET " + info_db.SETTING_SIZE + "= '" + newSize +"'WHERE " + info_db.SETTING_ID+"='1'" +"");
        db.close();
    }

    public int sizeValue(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.SETTING_SIZE + " FROM setting WHERE " + info_db.SETTING_ID + "='" + 1 +"'";

        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            size = cursor.getInt(cursor.getColumnIndex(info_db.SETTING_SIZE));

            do {

            }while (cursor.moveToNext());
        }
        db.close();

        return size;
    }

    public void ColorValue( int color){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE setting SET " + info_db.SETTING_COLOR + "= '" + color +"'WHERE " + info_db.SETTING_ID+"='1'" +"");
        db.close();
    }

    public int getColor(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.SETTING_COLOR + " FROM setting WHERE " + info_db.SETTING_ID + "='" + 1 +"'";

        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            color = cursor.getInt(cursor.getColumnIndex(info_db.SETTING_COLOR));

            do {

            }while (cursor.moveToNext());
        }
        db.close();

        return color;
    }

    public void setFont( int font){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE setting SET " + info_db.SETTING_FONT + "= '" + font +"'WHERE " + info_db.SETTING_ID+"='1'" +"");
        db.close();
    }

    int font;
    public int getFont(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.SETTING_FONT + " FROM setting WHERE " + info_db.SETTING_ID + "='" + 1 +"'";

        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            font = cursor.getInt(cursor.getColumnIndex(info_db.SETTING_FONT));

            do {

            }while (cursor.moveToNext());
        }
        db.close();

        return font;
    }

    int bg;
    public void setBG( int bg){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE setting SET " + info_db.SETTING_BACKGROUND + "= '" + bg +"'WHERE " + info_db.SETTING_ID+"='1'" +"");
        db.close();
    }

    public int getBg(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+ info_db.SETTING_BACKGROUND + " FROM setting WHERE " + info_db.SETTING_ID + "='" + 1 +"'";

        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            bg = cursor.getInt(cursor.getColumnIndex(info_db.SETTING_BACKGROUND));

            do {

            }while (cursor.moveToNext());
        }
        db.close();

        return bg;
    }

}
