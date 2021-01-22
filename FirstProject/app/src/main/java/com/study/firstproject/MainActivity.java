package com.study.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //화면에 버튼 나오게 하자~
        //import 는 Alt + Enter
        Button bt = new Button(this);
        bt.setText("나의 첫 버튼");

        //화면에 부착
        //this.setContentView(bt);
        this.setContentView(R.layout.linear);  //레이아웃 xml의 경로 및 아이디

        //결론 : 응용 어플리케이션에서는 화면 배치가 중요하다~

    }
}