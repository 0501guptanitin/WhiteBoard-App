package com.example.whiteboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {
   private DrawableView drawableView;
  private DrawableViewConfig config = new DrawableViewConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }
    private void initUi(){
        drawableView = (DrawableView) findViewById(R.id.paintView);
      Button buttonUp = (Button)findViewById(R.id.buttonUp);
        Button buttonDown = (Button)findViewById(R.id.buttonDown);
        Button buttonColor = (Button)findViewById(R.id.buttonColor);
        Button buttonUndo = (Button)findViewById(R.id.buttonUndo);

        config.setStrokeColor(getResources().getColor(android.R.color.black));
       // config.setShowCanvasBounds(false);
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1920);
        config.setCanvasWidth(1920);

        drawableView.setConfig(config);

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() + 10);

            }
        });

        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth() - 10);
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                config.setStrokeColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            }
        });
         buttonUndo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 drawableView.undo();
             }
         });
    }
}