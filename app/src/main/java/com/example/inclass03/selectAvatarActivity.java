package com.example.inclass03;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class selectAvatarActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String GENDER="";
    ImageView iv_male,iv_female;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_avatar);
        setTitle("Select Avatar");
        iv_female=findViewById(R.id.avatar_female);
        iv_male=findViewById(R.id.avatar_male);
        iv_male.setOnClickListener(this);
        iv_female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == iv_female){
            Intent returnedData=new Intent();
            returnedData.putExtra(GENDER, "female");
            setResult(RESULT_OK,returnedData);
            finish();
        }
        if(v == iv_male){
            Intent returnedData=new Intent();
            returnedData.putExtra(GENDER, "male");
            setResult(RESULT_OK,returnedData);
            finish();
        }
    }
}
