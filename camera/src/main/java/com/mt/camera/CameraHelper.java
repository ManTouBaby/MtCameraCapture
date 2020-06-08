package com.mt.camera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.mt.camera.audio.AudioDialogFragment;
import com.mt.camera.audio.AudioRecordListener;
import com.mt.camera.p2v.CameraCaptureActivity;
import com.mt.camera.widget.CaptureButton;

/**
 * Description:
 */
public class CameraHelper {
    public static final String DATA = "DATA";   // 压缩后的文件路径
    public static final String DATA_ORIGIN = "DATA_ORIGIN";  // 原文件路径
    public static final String DATA_REAL_DURATION = "DATA_REAL_DURATION";
    public static String mFileDir;
    private static CameraHelper mCameraHelper;

    private CameraHelper(String fileDir) {
        mFileDir = fileDir;
    }

    public static CameraHelper getInstance(String fileDir) {
        if (mCameraHelper == null) {
            synchronized (CameraHelper.class) {
                if (mCameraHelper == null) {
                    mCameraHelper = new CameraHelper(fileDir);
                }
            }
        }
        return mCameraHelper;
    }

    public static CameraHelper getInstance() {
        return getInstance(null);
    }


    /**
     * 拍照
     *
     * @param activity
     * @param requestCode
     */
    public void capturePhoto(Activity activity, int requestCode) {
        capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_CAPTURE, 15000);
    }


    /**
     * 录像
     *
     * @param activity
     * @param requestCode
     * @param duration
     */
    public void captureRecord(Activity activity, int requestCode, long duration) {
        capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_RECORD, duration);
    }


    /**
     * 拍照+录像
     *
     * @param activity
     * @param requestCode
     * @param duration
     */
    public void capturePhoto2Record(Activity activity, int requestCode, long duration) {
        capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_CAPTURE_RECORD, duration);
    }

    /**
     * 录音
     *
     * @param activity
     * @param funAudioRecordListener
     */
    public void captureAudioRecord(AppCompatActivity activity, AudioRecordListener funAudioRecordListener) {
        AudioDialogFragment funAudioDialogFragment = AudioDialogFragment.newInstance();
        funAudioDialogFragment.setAudioRecordListener(funAudioRecordListener);
        funAudioDialogFragment.show(activity.getSupportFragmentManager(), "AudioDialogFragment");
    }


    // —————————————————————————————————————————————————————————————————————————————————————————————

    /**
     * @param activity
     * @param mode     模式
     * @param duration 拍摄时长 单位毫秒
     */
    private void capturePhoto2Record(Activity activity, int requestCode, int mode, long duration) {
        Intent intent = new Intent(activity, CameraCaptureActivity.class);
        intent.putExtra(CameraCaptureActivity.MODE, mode);
        intent.putExtra(CameraCaptureActivity.DURATION, duration);
        activity.startActivityForResult(intent, requestCode);
    }
}
