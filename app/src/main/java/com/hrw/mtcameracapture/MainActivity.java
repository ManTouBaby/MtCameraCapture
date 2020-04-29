package com.hrw.mtcameracapture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mt.camera.CameraHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cameraClick(View view) {
        switch (view.getId()) {
            case R.id.btn_take_video:
                CameraHelper.getInstance(getPackageName()).captureRecord(this, 30, 15000);
                break;
            case R.id.btn_take_photo:
                CameraHelper.getInstance(getPackageName()).capturePhoto(this, 20);
                break;
            case R.id.btn_take_photo_video:
                CameraHelper.getInstance(getPackageName()).capturePhoto2Record(this, 10, 15000);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String path = data.getStringExtra(CameraHelper.DATA);
            long realDuration = data.getLongExtra(CameraHelper.DATA_REAL_DURATION, (long) 0F);
            String pathOrigin = data.getStringExtra(CameraHelper.DATA_ORIGIN);
            System.out.println("录制时长:" + realDuration);
        }
    }
}
