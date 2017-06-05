package com.example.user.bank;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {

    Button login_btn1;
    EditText ed1,ed2;
    private String uid;
    private String pw;
    String login_new_account;
    String login_new_passwd;

    String aa_name = "aa_acount";
    String login_test = "aa_passwd";
    SQLiteDatabase aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ed1=(EditText) findViewById(R.id.login_account);
        ed2=(EditText) findViewById(R.id.login_password);
        login_btn1=(Button) findViewById(R.id.login_btn1);

        Intent it = getIntent();
        login_new_account=it.getStringExtra("new_account");
        login_new_passwd=it.getStringExtra("new_passwd");



        aa = openOrCreateDatabase(aa_name, Context.MODE_PRIVATE, null); //aa.close();

        String createTable = "CREATE TABLE IF NOT EXISTS " + login_test + "(user TEXT,passwd TEXT)";
        aa.execSQL(createTable);

        if(login_new_account!=null && login_new_passwd!=null ){
            ContentValues ca = new ContentValues(2);
            ca.put("user", login_new_account);
            ca.put("passwd", login_new_passwd);
            aa.insert(login_test, null  , ca);
        }

        aa.close();



        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uid = ed1.getText().toString();
                pw = ed2.getText().toString();

                String test_account;
                String test_passwd;

                aa = openOrCreateDatabase(aa_name, Context.MODE_PRIVATE, null);
                Cursor c = aa.rawQuery("Select * from " + login_test, null);


                if(login_new_account==null && login_new_passwd==null ) {

                    test_account = "admin";
                    test_passwd = "admin";

                    if( uid.equals(test_account) && pw.equals(test_passwd) ){
                        Toast.makeText(login.this,"登入成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        new AlertDialog.Builder(login.this)
                                .setTitle("bank")
                                .setMessage("登入失敗")
                                .setPositiveButton("OK",null)
                                .show();
                    }

                }else{

                    c.moveToFirst();

                    if( uid.equals( c.getString(0))  && pw.equals( c.getString(1) )  ){
                        Toast.makeText(login.this,"登入成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        new AlertDialog.Builder(login.this)
                                .setTitle("bank")
                                .setMessage("登入失敗")
                                .setPositiveButton("OK",null)
                                .show();
                    }


                }
                aa.close();
            }
        });






    }
}
