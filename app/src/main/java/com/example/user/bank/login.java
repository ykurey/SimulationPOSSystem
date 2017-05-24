package com.example.user.bank;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button login_btn1;
    EditText ed1,ed2;
    private String uid;
    private String pw;
    String login_new_account;
    String login_new_passwd;


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


        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uid = ed1.getText().toString();
                pw = ed2.getText().toString();

                String test_account="515";
                String test_passwd="515";

                if(login_new_account==null && login_new_passwd==null) {
                    test_account = "admin";
                    test_passwd = "admin";
                }

                if(uid.equals(login_new_account) && pw.equals(login_new_passwd)){
                    Toast.makeText(login.this,"登入成功",Toast.LENGTH_SHORT).show();
                    finish();
                }else if( uid.equals(test_account) && pw.equals(test_passwd) ){
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



            /*
                uid = ed1.getText().toString();
                pw = ed2.getText().toString();

                if(uid.equals("admin") && pw.equals("admin")){

                    Toast.makeText(login.this,"登入成功",Toast.LENGTH_SHORT).show();
                    finish();

                }else{
                    new AlertDialog.Builder(login.this)
                            .setTitle("bank")
                            .setMessage("登入失敗")
                            .setPositiveButton("OK",null)
                            .show();
                }
                */
            }
        });






    }
}
