package com.example.sandraleticia.linterna;

/**
 * Created by Sandra Leticia on 02/09/2016.
 */
public class Torch {
    private android.hardware.Camera camera;
    private android.hardware.Camera.Parameters parameters;
    private boolean on;

    Torch(){
        camera= android.hardware.Camera.open();
        parameters = camera.getParameters();
        on=false;

    }
    public void on(){
        if (!on){
            on=true;
            parameters.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
        }
    }
    public void off(){
        if (on){
            on=false;
            parameters.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
        }
    }
    public void release(){
        camera.stopPreview();
        camera.release();
    }
    public boolean isOn(){

        // return (parameters.getFlashMode()== android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
        return on;
    }



}
