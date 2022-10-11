package com.jnu.hw_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button buttonPrevious, buttonNext ;
    private ImageView imageViewFunny;
    private int[] imageIDArray = {R.drawable.funny_1, R.drawable.funny_2
            , R.drawable.funny_3, R.drawable.funny_4, R.drawable.funny_5
            , R.drawable.funny_6
    };
    private int imageIDArrayCurrentIndex;

    public MainActivity() {
        imageIDArrayCurrentIndex = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPrevious = (Button)findViewById(R.id.button_previous);
        buttonNext =(Button) findViewById(R.id.button_next);
        imageViewFunny = (ImageView)findViewById(R.id.image_view_funny);
        buttonPrevious.setOnClickListener(new MyButtonClickListener());
        buttonNext.setOnClickListener(new MyButtonClickListener());

    }

    private class MyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            if (((Button) view).getText().equals("下一个"))
            if(view==buttonNext){
                imageIDArrayCurrentIndex ++;
            } else {
                imageIDArrayCurrentIndex --;
            }
            if(imageIDArrayCurrentIndex<0) imageIDArrayCurrentIndex=imageIDArray.length-1;
            else if(imageIDArrayCurrentIndex>=imageIDArray.length) imageIDArrayCurrentIndex=0;
            imageViewFunny.setImageResource(imageIDArray[imageIDArrayCurrentIndex]);
        }
    }
}