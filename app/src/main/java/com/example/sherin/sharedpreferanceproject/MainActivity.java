package com.example.sherin.sharedpreferanceproject;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    //---our parent_layout is relative
    RelativeLayout relativeLayout;
    private int pic1=R.drawable.akru;
    private int pic2=R.drawable.and;
    private int pic3=R.drawable.andro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       loadData();
       }

 private void loadData() {
        SharedPreferences preferences = getSharedPreferences("db", MODE_PRIVATE);
        int selectedimg=preferences.getInt("picture1",pic1);
        relativeLayout.setBackgroundResource(selectedimg);

    }
        private void initView() {
        btn1=findViewById(R.id.imgbtn1Id);
        btn2=findViewById(R.id.imgbtn2Id);
        btn3=findViewById(R.id.imgbtn3Id);
        relativeLayout=findViewById(R.id.parent_layout);

    }

    public void btnClick(View view) {

        if (view.getId() == R.id.imgbtn1Id) {

            relativeLayout.setBackgroundResource(pic1);
              saveScore(pic1);
               }
            else if (view.getId() == R.id.imgbtn2Id) {

            relativeLayout.setBackgroundResource(pic2);
           saveScore(pic2);
            }
            else  if(view.getId()==R.id.imgbtn3Id)
        {
            relativeLayout.setBackgroundResource(pic3);
            saveScore(pic3);

        }
    }

 private void saveScore(int score) {

        SharedPreferences preferences = getSharedPreferences("db", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("picture1", score);

         editor.commit();

    }
}



