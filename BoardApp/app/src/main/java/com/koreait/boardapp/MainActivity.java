package com.koreait.boardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    HttpManager httpManager;
    ListView listView;
    BoardAdapter adapter;

    @Override //servlet의 init과 비슷함
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //인플레이션 됨!!

        listView = this.findViewById(R.id.listView);

        //뷰는 MVC에서 View 즉 디자인에 해당하므로, 실제 데이터를 처리 및 관리하는
        //객체는 모델이며, 이 모델과 디자인인 View를 연결해주는 역할을 Controller가 한다
        //JTable에서 TableModel 이 있듯, 안드로이드에서는 Adapter가 지원된다.
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);//배열, 리스트 등 아이템이 단일한 경우에 최적화됨
        adapter = new BoardAdapter(this);
        listView.setAdapter(adapter);

        httpManager = new HttpManager(this);
    }

    public void regist(View view){

    }

    public void getList(View view){
        Thread thread = new Thread(){
            public void run() {
                httpManager.requestByGet("http://172.30.1.1:8888/rest/board");
            }
        };
        thread.start();
    }
}