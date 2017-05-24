package com.example.user.bank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class saving extends AppCompatActivity {

    TextView s_ed1;
    String number_true;
    String cost_true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);

        s_ed1=(TextView) findViewById(R.id.s_ed1);

        Intent it = getIntent();
        number_true=it.getStringExtra("number");
        cost_true=it.getStringExtra("cost_item");
        s_ed1.setText(cost_true+" "+number_true);

    }

    public void op(View view){
        Intent it2 = new Intent(this,check.class);

        it2.putExtra("check_number", number_true);
        it2.putExtra("check_cost_item", cost_true);

        startActivity(it2);
    }
}
