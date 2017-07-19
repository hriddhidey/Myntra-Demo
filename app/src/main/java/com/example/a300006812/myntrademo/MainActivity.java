package com.example.a300006812.myntrademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText query;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.go_button);
        query = (EditText) findViewById(R.id.tv_search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListScreen.class);
                String queryVal = query.getText().toString();

                if ( !queryVal.isEmpty()  ) {
                    intent.putExtra("QUERY", queryVal);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Kindly enter search query.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
