package com.myapplicationdev.android.demoimplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = findViewById(R.id.buttonEmail);
        editTextMessage = findViewById(R.id.editTextMessage);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());

                // This MIME type indicates email
                email.setType("message/rfc822");

                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

    }
}
