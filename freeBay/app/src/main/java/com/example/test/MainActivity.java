package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import dmax.dialog.SpotsDialog;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;

import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraView;

public class MainActivity extends AppCompatActivity {
    CameraView cameraView;
    Button btnDetect;
    AlertDialog waitingDialog;

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();

    }

    @Override
    protected void onPause (){
        super.onPause();
        cameraView.stop();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = (CameraView)findViewById(R.id.camera_view);
        btnDetect = (Button)findViewById(R.id.btn_detect);

        waitingDialog = new SpotsDialog.Builder().setMessage("Please waiting...")
                .setCancelable(false).build();

        cameraView.addCameraKitListener(){

            public void onImage(CameraKitImage cameraKitImage){
                waitingDialog.show();
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap,cameraView, cameraView.getWidth(),cameraView.getHeight(), false);
            }
        }
    }
}
