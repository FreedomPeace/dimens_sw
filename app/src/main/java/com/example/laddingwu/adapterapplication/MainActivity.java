package com.example.laddingwu.adapterapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv2,tv1,tv3,tv4;
    View view;
    static final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
         tv3 = findViewById(R.id.tv3);
         tv4 = findViewById(R.id.tv4);
        final TextView tv5 = findViewById(R.id.tv5);
        view = findViewById(R.id.view_show);

        tv1.postDelayed(new Runnable() {
            @Override
            public void run() {
               /* DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int width = Math.min(dm.widthPixels,dm.heightPixels);
                tv1.setText("dpi : "+dm.densityDpi +"   smallest width pixels : "+width);
                tv2.setText("计算出来的smallestWidth : "+width/(dm.densityDpi/160.0) +"dp");
//                tv3.setText("实际使用的smallestWidth :  "+getResources().getString(R.string.base_dpi));
                tv4.setText("当前手机： "+SystemUtil.getDeviceBrand()+"  "+SystemUtil.getSystemModel()+ " \n"+"当前系统： "+SystemUtil.getSystemVersion()+ " ");
                LinearLayout.LayoutParams p= (LinearLayout.LayoutParams) view.getLayoutParams();
                p.width = getResources().getDimensionPixelSize(R.dimen.qb_px_375);//490
                Toast.makeText(MainActivity.this, ""+p.width, Toast.LENGTH_SHORT).show();
                view.setLayoutParams(p);
                tv5.setText("scaledDensity : "+dm.scaledDensity +"\n"
                            +"  btn width:" + view.getLayoutParams().width+"\n"
                        +"屏幕的 landscape width: " + dm.widthPixels + "屏幕的landscape   height: " +dm.heightPixels);
                handler.sendEmptyMessage(1);*/
                tv3.setText("实际使用的smallestWidth :  "+getResources().getString(R.string.base_px));
                tv5.setText("  btn width:" + view.getLayoutParams().width);
            }
        },1000);
    }
}
