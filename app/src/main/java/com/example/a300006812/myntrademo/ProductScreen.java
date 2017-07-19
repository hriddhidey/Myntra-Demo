package com.example.a300006812.myntrademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_price = (TextView) findViewById(R.id.tv_price);
        TextView tv_description = (TextView) findViewById(R.id.tv_description);
        ImageView mIvPdpImage = (ImageView) findViewById(R.id.iv_pdp_image);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String price = intent.getStringExtra("PRICE");
        String imageUrl = intent.getStringExtra("IMAGE");

        Glide.with(this)
                .load(imageUrl)
                .into(mIvPdpImage);


        tv_name.setText( tv_name.getText() +  name );
        tv_price.setText( tv_price.getText() +  price );
        tv_description.setText( tv_description.getText() + "It's available on Myntra." );

    }
}
