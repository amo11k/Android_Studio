package es.ieselcaminas.amo11k.russianroulete2;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by alu53381650f on 28/09/15.
 */
public class Barrel extends LinearLayout{


    private int bullet;
    private Button[] buttons;
    public static final int NUM_BULLETS = 6;


    public Barrel(Context context) {
        super(context);
        create();
    }

    public Barrel(Context context, AttributeSet attrs) {
        super(context, attrs);
        create();
    }

    public Barrel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create();
    }

    private void create(){
        bullet = (int) (Math.random()*NUM_BULLETS)+1;
        buttons = new Button[NUM_BULLETS];
        for(int i=1;i<=NUM_BULLETS;i++){
            buttons[i-1]=new Button(getContext(), null, android.R.attr.buttonStyleSmall);
            buttons[i-1].setText(""+i);
            buttons[i-1].setTag(i);
            buttons[i-1].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Integer) v.getTag() == bullet) {
                        FrameLayout color = (FrameLayout) findViewById(R.id.coloLayout);
                        color.setBackgroundColor(Color.RED);
                        TextView text = (TextView) findViewById(R.id.bangText);
                        text.setText("BANG!");
                        text.setVisibility(VISIBLE);
                    } else {
                        v.setEnabled(false);
                    }
                }
            });
            addView(buttons[i - 1]);
        }
    }
}
