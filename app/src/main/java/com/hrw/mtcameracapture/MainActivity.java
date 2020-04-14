package com.hrw.mtcameracapture;

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
                CameraHelper.captureRecord(this, 30, 15000);
                break;
            case R.id.btn_take_photo:
                CameraHelper.capturePhoto(this, 20);
                break;
            case R.id.btn_take_photo_video:
                break;
        }
    }
}
