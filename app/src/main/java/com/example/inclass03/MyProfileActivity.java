package com.example.inclass03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MyProfileActivity extends AppCompatActivity {
    ImageView displayimage;
    TextView displayname,displaygender;
    Button editbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_profile);
        setTitle("Display Profile");
        displayimage=findViewById(R.id.profile_photo);
        displayname=findViewById(R.id.display_name);
        displaygender=findViewById(R.id.display_gender);
        editbutton=findViewById(R.id.editbtn);
        if(getIntent()!=null && getIntent().getExtras()!=null){
            User user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);
            if(user.getGender().equals("Female")){
                displayimage.setImageDrawable(getDrawable(R.drawable.female));
            }
            if(user.getGender().equals("Male")){
                displayimage.setImageDrawable(getDrawable(R.drawable.male));
            }

            displayname.setText(user.getFirstname() + " " +user.getLastname());
            displaygender.setText(user.getGender());
        }
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
