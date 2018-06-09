package com.pc.googleauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class Profile extends AppCompatActivity {
    ImageView userimg;
    TextView username,useremail;
    Button logout;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userimg = findViewById(R.id.userimg);
        username = findViewById(R.id.username);
        useremail = findViewById(R.id.email);
        logout = findViewById(R.id.btnlogout);
        username.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        useremail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        userimg.setImageURI(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                auth.signOut();
                finish();
            }
        });

        Picasso.with(getBaseContext())
                .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl())
                .into(userimg);

    }
}
