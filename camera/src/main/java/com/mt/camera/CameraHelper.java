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

    // 压缩后的文件路径
    public static final String DATA = "DATA";
    // 原文件路径
    public static final String DATA_ORIGIN = "DATA_ORIGIN";
    public static final String DATA_REAL_DURATION = "DATA_REAL_DURATION";

    /**
     * 拍照
     *
     * @param activity
     * @param requestCode
     */
    public static final void capturePhoto(Activity activity, int requestCode) {
        Intent intent = capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_CAPTURE, 15000);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 录像
     *
     * @param activity
     * @param requestCode
     * @param duration
     */
    public static final void captureRecord(Activity activity, int requestCode, long duration) {
        Intent intent = capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_RECORD, duration);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 拍照+录像
     *
     * @param activity
     * @param requestCode
     * @param duration
     */
    public static final void capturePhoto2Record(Activity activity, int requestCode, long duration) {
        Intent intent = capturePhoto2Record(activity, requestCode, CaptureButton.Mode.MODE_CAPTURE_RECORD, duration);
        activity.startActivityForResult(intent, requestCode);
    }


    /**
     * 录音
     *
     * @param activity
     * @param funAudioRecordListener
     */
    public static final void captureAudioRecord(AppCompatActivity activity, AudioRecordListener funAudioRecordListener) {
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
    private static final Intent capturePhoto2Record(Activity activity, int requestCode, int mode, long duration) {
        Intent intent = new Intent(activity, CameraCaptureActivity.class);
        intent.putExtra(CameraCaptureActivity.MODE, mode);
        intent.putExtra(CameraCaptureActivity.DURATION, duration);
        return intent;
    }
}
