package com.koreait.actionbarapp.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koreait.actionbarapp.MainActivity;
import com.koreait.actionbarapp.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//리소스에 있는 자원 이용... 네트워크 http 요청? socket 요청?
//기술학습 순서 : 안드로이드보다 앞서서 순수한 자바로 URL이미지 가져오기를 할줄 알아야 함..
public class GalleryAdapter extends BaseAdapter {
    String TAG = this.getClass().getName();
    MainActivity mainActivity;
    ArrayList<Gallery> galleryList = new ArrayList<Gallery>();
    LayoutInflater layoutInflater;


    public GalleryAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        layoutInflater = mainActivity.getLayoutInflater();  //액티비티를 통해 인플레이터 얻기
    }

    @Override
    public int getCount() {
        return galleryList.size();
    }

    @Override
    public Object getItem(int position) {
        return galleryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;  //이 메서드에서 최종 반환할 뷰

        if(convertView == null){   //레이아웃 뷰가 존재하지 않는다면... 인플레이션 시킴
            //false의 의미 : 지정한 parent에 부착하지 않고, 인플레이션 대상 xml의 최상위를 반환
            view = layoutInflater.inflate(R.layout.item_gallery, parent, false);
        }else{  //이미 존재한다면, 기존 뷰 그대로 재사용함
            view = convertView;
        }
        //결정된 뷰로부터 하위 자식들 접근하기
        //ImageView에 자바코드로 이미지 대입해보기
        //리스트에 들어있는 position 번째 Gallery 추출
        Gallery gallery = galleryList.get(position);

        ImageView img = view.findViewById(R.id.img);
        TextView t_title = view.findViewById(R.id.t_title);

        img.setImageBitmap(gallery.getBitmap());
        t_title.setText(gallery.getTitle());

        view.setOnClickListener(e->{
            Toast.makeText(mainActivity, gallery.getGallery_id()+"선택했어?", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
    /*
    public void loadTest(ImageView img){
        //Bitmap 객체는 스트림을 통해서도 인스턴스를 얻을 수 있기 때문에
        //우리의 경우 원격지에 떨어진 웹서버로부터 요청을 통해 얻을 수 있는 스트림을 이용하려고...
        try {
            URL url = new URL("http://172.30.1.40:7777/images/bg.jpg");

            Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
            img.setImageBitmap(bitmap);
            Log.d(TAG, "bitmap"+bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
