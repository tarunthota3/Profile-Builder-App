/*
Assignment: In Class Assignment 03
File name: MainActivity.java
Full name:
Akhil Madhamshetty-801165622
Tarun thota-801164383
 */

package com.example.inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button savebtn;
    ImageView imageView;
    EditText firstname,lastname;
    public static String USER_KEY="user";
    private static final int REQ_CODE=0x001;
    String gen="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");
        savebtn=findViewById(R.id.save_btn);
        firstname=findViewById(R.id.firstName);
        lastname=findViewById(R.id.lastName);
        imageView=findViewById(R.id.avatar_create);
        if(firstname.getText().toString()=="")
            firstname.setError("Can't be Empty");
        if(lastname.getText().toString()=="")
            lastname.setError("Can't be Empty");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSelectAvatar= new Intent(MainActivity.this,selectAvatarActivity.class);
                startActivityForResult(toSelectAvatar,REQ_CODE);

            }
        });
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayprofile = new Intent(MainActivity.this,MyProfileActivity.class);

                User user=new User(gen,firstname.getText().toString(),lastname.getText().toString());
                if(firstname.getText().toString().equals("") ||  !firstname.getText().toString().matches("[a-zA-Z_]+")){
                    firstname.setError("Enter the valid first name");
                    return;
                }
                if(lastname.getText().toString().equals("") || !lastname.getText().toString().matches("[a-zA-Z_]+") ){
                    lastname.setError("Enter the valid last name");
                    return;
                }
                if(user.getGender().equals("")) {
                    Toast.makeText(getBaseContext(),"Please select Gender",Toast.LENGTH_SHORT).show();
                    return;

                }
                displayprofile.putExtra(USER_KEY,user);
                startActivity(displayprofile);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK && data != null) {
            String gender = data.getExtras().getString(selectAvatarActivity.GENDER);

            if (gender.equals("female")) {
                imageView.setImageDrawable(getDrawable(R.drawable.female));
                gen="Female";
            } else {
                imageView.setImageDrawable(getDrawable(R.drawable.male));
                gen="Male";
            }
        }
    }
}
