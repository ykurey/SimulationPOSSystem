package com.example.user.bank;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class check extends AppCompatActivity {

    TextView ch_txv;

    String db_name = "DBCost";
    String tb_name = "BestCost";
    SQLiteDatabase db;
    int sum=0;
    TextView check_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        check_sum=(TextView) findViewById(R.id.check_sum);

        Intent it2 = getIntent();
        String number_true=it2.getStringExtra("check_number");
        String cost_true=it2.getStringExtra("check_cost_item");

        //資料庫開啟----------------------------------------------------------------------------------------------------------------------------
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null); //db.close();

        String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name + "(check_user TEXT,check_cost TEXT)";
        db.execSQL(createTable);

        ContentValues cv = new ContentValues(2);
        cv.put("check_user", cost_true);
        cv.put("check_cost", number_true);
        db.insert(tb_name, null, cv);
        db.close();
        //資料庫關閉----------------------------------------------------------------------------------------------------------------------------


        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("Select * from " + tb_name, null);
        String str = "";
        String a="收入";
        String b="支出";
        if (c.getCount() != 0){
            c.moveToFirst();
            do{
                if("收入".equals(c.getString(0))) {
                    sum += c.getInt(1);
                }else if("支出".equals(c.getString(0))){
                    sum -= c.getInt(1);
                }
                str += c.getString(0)+" "+c.getString(1)+"元\n";

            } while(c.moveToNext());
        }
        ch_txv = (TextView) findViewById(R.id.ch_txv);
        ch_txv.setText(str);
        db.close();

        check_sum.setText("總計:"+sum);

    }

}
