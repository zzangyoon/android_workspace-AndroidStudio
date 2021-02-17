package com.koreait.actionbarapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ExamActivity extends AppCompatActivity {
    ViewPager viewPager;
    ExamViewPagerAdapter examViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        examViewPagerAdapter = new ExamViewPagerAdapter(this.getSupportFragmentManager(),0);
        viewPager.setAdapter(examViewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.exam_navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = null;

        switch (item.getItemId()){
            case R.id.yellow:showPage(0);break;
            case R.id.red:showPage(1);break;
            case R.id.blue:showPage(2);break;
        }
        return true;
    }

    public void showPage(int position){
        viewPager.setCurrentItem(position, true);
    }
}