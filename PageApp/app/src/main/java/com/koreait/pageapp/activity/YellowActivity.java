package com.koreait.pageapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.koreait.pageapp.R;

public class YellowActivity extends AppCompatActivity {
    String TAG = this.getClass().getName();
    //생명주기 메서드가 있다

    //액티비티의 인스턴스 생성직후 초기화를 위한 메서드(서블릿의 init과 목적이 동일)
    protected void onCreate(Bundle savedInstanceState) {
        //여기서 보여질 뷰 선택 등...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yellow);   //xml에 명시한 객체들을 인스턴스화 시킴! (inflation)
    }

    public void showPage(View view){
        Log.d(TAG, "당신이 클릭한 버튼은 "+view.getId());
        String msg = null;
        Intent intent =null;
        switch (view.getId()){
            case R.id.bt_blue:
                msg="Blue";
                //파란 액티비티 호출! (주의 : 액티비티는 개발자가 new 해서는 안된다. 시스템이 생명주기 관리하므로)
                //개발자의 의지, 의도, 계획을 시스템에게 알려줘야 한다... I intent to~
                intent = new Intent(this, BlueActivity.class);
                break;
            case R.id.bt_red:
                msg="Red";
                intent = new Intent(this, RedActivity.class);
                break;
        }
        this.startActivity(intent);
        Log.d(TAG, msg);
    }
}
