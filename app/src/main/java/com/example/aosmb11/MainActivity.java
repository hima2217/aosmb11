package com.example.aosmb11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Fragment fragment2;
    private Fragment fragment1;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView my_animated_view = findViewById(R.id.my_animated_view);

        my_animated_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                animateView(my_animated_view);
            }
        });


        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right);
//	ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

//        ft.replace(R.id.fragCont, fragment1);
//        ft.addToBackStack(null);

        ft.commit();

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                if(fragment1.isVisible()){
                    ft.replace(R.id.fragCont, fragment2);
                }else{
                    ft.replace(R.id.fragCont, fragment1);
                }
                ft.commit();
            }
    });
}

    private void animateView(ImageView view) {
        Drawable drawable = view.getDrawable();
        if (drawable instanceof AnimatedVectorDrawableCompat) {
            ((AnimatedVectorDrawableCompat) drawable).start();
        } else if (drawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawable).start();
        }
        }
    }
