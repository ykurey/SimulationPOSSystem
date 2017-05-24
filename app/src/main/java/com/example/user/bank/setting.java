package com.example.user.bank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setting extends AppCompatActivity {

    EditText setting_account,setting_passwd;
    Button setting_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setting_account=(EditText) findViewById(R.id.setting_account);
        setting_passwd=(EditText) findViewById(R.id.setting_passwd);
        setting_btn1=(Button) findViewById(R.id.setting_btn1);

        setting_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(setting.this,"更改成功",Toast.LENGTH_SHORT).show();

                Intent it=new Intent(setting.this,login.class);

                String new_account=setting_account.getText().toString().trim();
                String new_passwd=setting_passwd.getText().toString().trim();

                it.putExtra("new_account",new_account);
                it.putExtra("new_passwd",new_passwd);

                startActivity(it);
            }
        });

    }
}
