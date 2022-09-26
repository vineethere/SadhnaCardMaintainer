//package com.app.quizapp.data;
package com.example.quizapp.data;

import static com.example.quizapp.params.params.DB_NAME;
import static com.example.quizapp.params.params.DB_VERSION;
import static com.example.quizapp.params.params.KEY_DATE;
import static com.example.quizapp.params.params.KEY_Ques10;
import static com.example.quizapp.params.params.KEY_Ques11;
import static com.example.quizapp.params.params.KEY_Ques12;
import static com.example.quizapp.params.params.KEY_Ques13;
import static com.example.quizapp.params.params.KEY_Ques14;
import static com.example.quizapp.params.params.KEY_Ques15;
import static com.example.quizapp.params.params.KEY_Ques16;
import static com.example.quizapp.params.params.KEY_Ques17;
import static com.example.quizapp.params.params.KEY_Ques18;
import static com.example.quizapp.params.params.KEY_Ques19;
import static com.example.quizapp.params.params.KEY_Ques2;
import static com.example.quizapp.params.params.KEY_Ques20;
import static com.example.quizapp.params.params.KEY_Ques21;
import static com.example.quizapp.params.params.KEY_Ques22;
import static com.example.quizapp.params.params.KEY_Ques23;
import static com.example.quizapp.params.params.KEY_Ques24;
import static com.example.quizapp.params.params.KEY_Ques25;
import static com.example.quizapp.params.params.KEY_Ques26;
import static com.example.quizapp.params.params.KEY_Ques27;
import static com.example.quizapp.params.params.KEY_Ques28;
import static com.example.quizapp.params.params.KEY_Ques29;
import static com.example.quizapp.params.params.KEY_Ques3;
import static com.example.quizapp.params.params.KEY_Ques30;
import static com.example.quizapp.params.params.KEY_Ques4;
import static com.example.quizapp.params.params.KEY_Ques5;
import static com.example.quizapp.params.params.KEY_Ques6;
import static com.example.quizapp.params.params.KEY_Ques7;
import static com.example.quizapp.params.params.KEY_Ques8;
import static com.example.quizapp.params.params.KEY_Ques9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.quizapp.entry.row;
import com.example.quizapp.params.params;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String create=" CREATE TABLE "+params.DB_TABLE_NAME  + "("+params.KEY_DATE+
                " STRING PRIMARY KEY, "+params.KEY_Ques1+" TEXT, "+params.KEY_Ques2+" TEXT, "+
                params.KEY_Ques3+" TEXT ,"+params.KEY_Ques4+" TEXT ,"+params.KEY_Ques5+" TEXT ,"+params.KEY_Ques6+" TEXT ,"+
                params.KEY_Ques7+" TEXT ,"+params.KEY_Ques8+" TEXT ,"+params.KEY_Ques9+" TEXT ,"+params.KEY_Ques10+" TEXT ,"+
                params.KEY_Ques11+" TEXT ,"+params.KEY_Ques12+" TEXT ,"+params.KEY_Ques13+" TEXT ,"+params.KEY_Ques14+" TEXT ,"+
                KEY_Ques15+" TEXT ,"+ KEY_Ques16+" TEXT ,"+ KEY_Ques17+" TEXT ,"+ KEY_Ques18+" TEXT ,"+
                KEY_Ques19+" TEXT ,"+ KEY_Ques20+" TEXT ,"+ KEY_Ques21+" TEXT ,"+ KEY_Ques22+" TEXT ,"+
                KEY_Ques23+" TEXT ,"+ KEY_Ques24+" TEXT ,"+ KEY_Ques25+" TEXT ,"+ KEY_Ques26+" TEXT ,"+
                KEY_Ques27+" TEXT ,"+ KEY_Ques28+" TEXT ,"+ KEY_Ques29+" TEXT ,"+ KEY_Ques30+" TEXT "+
                ")";
        Log.d("creating table","Query being run is"+create);
        db.execSQL(create);
    }


    public void addrow(row contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_DATE,contact.getDate());
        values.put(params.KEY_Ques1,contact.getQues1());
        values.put(params.KEY_Ques2,contact.getQues2());
        values.put(params.KEY_Ques3,contact.getQues3());
        values.put(params.KEY_Ques4,contact.getQues4());
        values.put(params.KEY_Ques5,contact.getQues5());
        values.put(params.KEY_Ques6,contact.getQues6());
        values.put(params.KEY_Ques7,contact.getQues7());
        values.put(params.KEY_Ques8,contact.getQues8());
        values.put(params.KEY_Ques9,contact.getQues9());
        values.put(params.KEY_Ques10,contact.getQues10());

        values.put(params.KEY_Ques11,contact.getQues11());
        values.put(params.KEY_Ques12,contact.getQues12());
        values.put(params.KEY_Ques13,contact.getQues13());
        values.put(params.KEY_Ques14,contact.getQues14());
        values.put(KEY_Ques15,contact.getQues15());
        values.put(KEY_Ques16,contact.getQues16());
        values.put(KEY_Ques17,contact.getQues17());
        values.put(KEY_Ques18,contact.getQues18());
        values.put(KEY_Ques19,contact.getQues19());
        values.put(KEY_Ques20,contact.getQues20());

        values.put(KEY_Ques21,contact.getQues11());
        values.put(KEY_Ques22,contact.getQues12());
        values.put(KEY_Ques23,contact.getQues13());
        values.put(KEY_Ques24,contact.getQues14());
        values.put(KEY_Ques25,contact.getQues15());
        values.put(KEY_Ques26,contact.getQues16());
        values.put(KEY_Ques27,contact.getQues17());
        values.put(KEY_Ques28,contact.getQues18());
        values.put(KEY_Ques29,contact.getQues19());
        values.put(KEY_Ques30,contact.getQues20());

        db.insert(params.DB_TABLE_NAME,null,values);
        Log.d("checking to be done","successfully inserted is it ok?");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }






    public void update_ans1(String date, String ans1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(params.KEY_Ques1,ans1);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
        Log.d("This is first entry","haa yar bss v");
        db.close();
    }
    public void update_ans2(String date,String ans2){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques2,ans2);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
        Log.d("This is first entry","haa yar bss v");
        db.close();
    }
    public void update_ans3(String date,String ans3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques3,ans3);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans4(String date,String ans4){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques4,ans4);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans5(String date,String ans5){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques5,ans5);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans6(String date,String ans6){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques6,ans6);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans7(String date,String ans7){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques7,ans7);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans8(String date,String ans8){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques8,ans8);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans9(String date,String ans9){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques9,ans9);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans10(String date,String ans10){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques10,ans10);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans11(String date,String ans11){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques11,ans11);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans12(String date,String ans12){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques12,ans12);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans13(String date,String ans13){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques13,ans13);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans14(String date,String ans14){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques14,ans14);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans15(String date,String ans15){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques15,ans15);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans16(String date,String ans16){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques16,ans16);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans17(String date,String ans17){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques17,ans17);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans18(String date,String ans18){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques18,ans18);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans19(String date,String ans19){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques19,ans19);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans20(String date,String ans20){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques20,ans20);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans21(String date,String ans21){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques21,ans21);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans22(String date,String ans22) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques22, ans22);
        db.update(params.DB_TABLE_NAME, cv, "Date=?", new String[]{String.valueOf(date)});
    }

    public void update_ans23(String date,String ans23) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques23, ans23);
        db.update(params.DB_TABLE_NAME, cv, "Date=?", new String[]{String.valueOf(date)});
    }

    public void update_ans24(String date,String ans24){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques24,ans24);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans25(String date,String ans25){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques25,ans25);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans26(String date,String ans26){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques26,ans26);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans27(String date,String ans27){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques27,ans27);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans28(String date,String ans28){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques28,ans28);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public void update_ans29(String date,String ans29){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques29,ans29);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }

    public void update_ans30(String date,String ans30){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_Ques30,ans30);
        db.update(params.DB_TABLE_NAME,cv,"Date=?",new String[]{String.valueOf(date)});
    }
    public row getrow(String date){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+params.DB_TABLE_NAME +" WHERE Date = ?", new String[] {date});
        row r=new row();
        if(c.moveToFirst()) {
            r.setDate(c.getString(0));
            r.setQues1(c.getString(1));
            r.setQues2(c.getString(2));
            r.setQues3(c.getString(3));
            r.setQues4(c.getString(4));
            r.setQues5(c.getString(5));
            r.setQues6(c.getString(6));
            r.setQues7(c.getString(7));
            r.setQues8(c.getString(8));
            r.setQues9(c.getString(9));
            r.setQues10(c.getString(10));

            r.setQues11(c.getString(11));
            r.setQues12(c.getString(12));
            r.setQues13(c.getString(13));
            r.setQues14(c.getString(14));
            r.setQues15(c.getString(15));
            r.setQues16(c.getString(16));
            r.setQues17(c.getString(17));
            r.setQues18(c.getString(18));
            r.setQues19(c.getString(19));
            r.setQues20(c.getString(20));

            r.setQues21(c.getString(21));
            r.setQues22(c.getString(22));
            r.setQues23(c.getString(23));
            r.setQues24(c.getString(24));
            r.setQues25(c.getString(25));
            r.setQues26(c.getString(26));
            r.setQues27(c.getString(27));
            r.setQues28(c.getString(28));
            r.setQues29(c.getString(29));
            r.setQues30(c.getString(30));
            c.close();
        }
        return r;
    }

    public ArrayList getEntry(String date) {
        ArrayList<String> list = new ArrayList<> ();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+params.DB_TABLE_NAME +" WHERE Date = ?", new String[] {date});

        if(c.moveToFirst()) {
            list.add(c.getString(0));
            list.add(c.getString(1));
            list.add(c.getString(2));
            list.add(c.getString(3));
            list.add(c.getString(4));
            list.add(c.getString(5));
            list.add(c.getString(6));
            list.add(c.getString(7));
            list.add(c.getString(8));
            list.add(c.getString(9));
            list.add(c.getString(10));

            list.add(c.getString(11));
            list.add(c.getString(12));
            list.add(c.getString(13));
            list.add(c.getString(14));
            list.add(c.getString(15));
            list.add(c.getString(16));
            list.add(c.getString(17));
            list.add(c.getString(18));
            list.add(c.getString(19));
            list.add(c.getString(20));

            list.add(c.getString(21));
            list.add(c.getString(22));
            list.add(c.getString(23));
            list.add(c.getString(24));
            list.add(c.getString(25));
            list.add(c.getString(26));
            list.add(c.getString(27));
            list.add(c.getString(28));
            list.add(c.getString(29));
            list.add(c.getString(30));
            c.close();
        }
        return list;
    }

}
