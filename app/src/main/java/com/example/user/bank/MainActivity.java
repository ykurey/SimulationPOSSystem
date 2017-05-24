package com.example.user.bank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean login=false;
    private Spinner spnPrefer;
    String[] cost = new String[]{"支出","收入"};
    Button btn1,btn2;
    EditText ed1;
    String sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!login){
            Intent intent=new Intent(MainActivity.this,login.class);
            startActivity(intent);
        }


        spnPrefer = (Spinner) findViewById(R.id.spinner);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        ed1=(EditText) findViewById(R.id.ed1);

        ArrayAdapter<String> adaptercost = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cost);
        adaptercost.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnPrefer.setAdapter(adaptercost);
        spnPrefer.setOnItemSelectedListener(spnPreferListener);
    }

    private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            sel = adapterView.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    public void opensecond(View v){
        Intent it = new Intent(this,saving.class);
        Intent it2 = new Intent(this,check.class);

        String str=ed1.getText().toString().trim();

        if(  /*  "".equals(str)  */  str.matches("")  /*   str.length()==0   */  ){
            Toast toast= Toast.makeText(MainActivity.this,"請輸入數字",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            int j = Integer.parseInt(ed1.getText().toString().trim());

            if(sel == "支出") {

                if (j >= 1000) {
                    Toast toast = Toast.makeText(MainActivity.this, "支出不能超過1000", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    it.putExtra("number", ed1.getText().toString());
                    it.putExtra("cost_item", sel);

                    it2.putExtra("check_number", ed1.getText().toString());
                    it2.putExtra("check_cost_item", sel);
                    startActivity(it);
                }
            }else{

                it.putExtra("number", ed1.getText().toString());
                it.putExtra("cost_item", sel);

                it2.putExtra("check_number", ed1.getText().toString());
                it2.putExtra("check_cost_item", sel);

                startActivity(it);
            }

        }

    }

    public void tesr(View v){
        Intent it = new Intent(this,selection.class);

        startActivity(it);
    }

    public void ol(View view){
        Intent it2 = new Intent(this,check.class);

        String str=ed1.getText().toString().trim();


        if(  /*  "".equals(str)  */  str.matches("")  /*   str.length()==0   */  ){
            Toast toast= Toast.makeText(MainActivity.this,"請輸入數字",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            int j = Integer.parseInt(ed1.getText().toString().trim());

            if(sel == "支出") {

                if (j >= 1000) {
                    Toast toast = Toast.makeText(MainActivity.this, "支出不能超過1000", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    it2.putExtra("number", ed1.getText().toString());
                    it2.putExtra("cost_item", sel);

                    it2.putExtra("check_number", ed1.getText().toString());
                    it2.putExtra("check_cost_item", sel);
                    startActivity(it2);
                }
            }else{

                it2.putExtra("number", ed1.getText().toString());
                it2.putExtra("cost_item", sel);

                it2.putExtra("check_number", ed1.getText().toString());
                it2.putExtra("check_cost_item", sel);

                startActivity(it2);
            }

        }
    }

}
