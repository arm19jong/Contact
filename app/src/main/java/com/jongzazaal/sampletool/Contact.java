package com.jongzazaal.sampletool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jongzazaal on 7/10/2559.
 */

public class Contact extends AppCompatActivity {
    TextView contactName;
    //private String sContactName;
    ImageView imageView;

    TextView phoneView;
    TextView emailView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        contactName = (TextView) findViewById(R.id.contact_name);
        imageView = (ImageView) findViewById(R.id.contact_image);
        phoneView = (TextView) findViewById(R.id.contact_phone);
        emailView = (TextView) findViewById(R.id.contact_email);


        Intent i = getIntent();
        String sContactName = i.getStringExtra("contact_name");
        contactName.setText(sContactName);
        Integer sPic = i.getIntExtra("contact_pic", 0);
        imageView.setImageResource(sPic);
        phoneView.setText(i.getStringExtra("contact_phone"));
        emailView.setText(i.getStringExtra("contact_email"));
        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneView.getText().toString()));
                startActivity(intent);
            }
        });

    }

}
