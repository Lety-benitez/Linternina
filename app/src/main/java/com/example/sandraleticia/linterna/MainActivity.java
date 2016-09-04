package com.example.sandraleticia.linterna;

import android.graphics.Camera;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private Camera camera;
    private Torch torch;
    private PowerManager.WakeLock wakeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton button = (ToggleButton) findViewById(R.id.button_on_off);

        // Enseder el flash7
         torch = new Torch();
        //  for (int i = 0; i < 100; i++){
        //      torch.on();
        //      torch.off();
        //  }
        torch.on();

        setContentView(R.layout.activity_main);
        ToggleButton botton = (ToggleButton) findViewById(R.id.button_on_off);
        button.setOnClickListener(this);



        PowerManager powerManager =
                (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(
                PowerManager.PARTIAL_WAKE_LOCK,"Linterna");
        wakeLock.setReferenceCounted(false);
        if (!wakeLock.isHeld()) {
            wakeLock.acquire();
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        // Apagar el flash
        torch.release();
        wakeLock.release();
    }

    @Override
    public void onClick(View view) {
        if (torch.isOn()){
            torch.off();
        }else{
            torch.on();
        }
    }
    }

