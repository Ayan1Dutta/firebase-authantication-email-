package com.example.lastlogin;

import  androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    TextView emailhome,uidhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        emailhome=(TextView) findViewById(R.id.email_home);
        uidhome=(TextView) findViewById(R.id.uidhome);
        emailhome.setText(getIntent().getStringExtra("email").toString());
        uidhome.setText("UID :"+getIntent().getStringExtra("uid").toString());
    }

    public void logoutprocess(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(),"Successfully logged out",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(dashboard.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }
}