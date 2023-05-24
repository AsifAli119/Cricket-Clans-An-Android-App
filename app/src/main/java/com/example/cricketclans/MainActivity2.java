package com.example.cricketclans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    FirebaseAuth auth;
    Button logout;
    TextView userdetails;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.lgout);
        userdetails = findViewById(R.id.textView5);
        user = auth.getCurrentUser();
        if (user == null){
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            userdetails.setText(user.getEmail());
        }
       logout.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
             Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
              startActivity(intent);
             finish();
         }
       });
    }
}