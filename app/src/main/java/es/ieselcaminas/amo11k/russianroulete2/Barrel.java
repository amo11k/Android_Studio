package es.ieselcaminas.amo11k.russianroulete2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by alu53381650f on 28/09/15.
 */
public class Barrel extends LinearLayout{

    private int aciertos = 0;
    private int bullet;
    private Button[] buttons;
    public static final int NUM_BULLETS = 6;
    private FireListener fireListener;

    public void setFireFistener(FireListener f) {
        fireListener = f;
    }

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
        generateRandom();
        buttons = new Button[NUM_BULLETS];
        for(int i=1;i<=NUM_BULLETS;i++){
            buttons[i-1]=new Button(getContext(), null, android.R.attr.buttonStyleSmall);
            buttons[i-1].setText(""+i);
            buttons[i-1].setTag(i);
            buttons[i-1].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Integer) v.getTag() == bullet) {
                        fireListener.fire(true);
                    } else {
                        v.setEnabled(false);
                        aciertos++;
                        fireListener.fire(false);
                    }
                }
            });
            addView(buttons[i - 1]);
        }
    }

    public void reset(){
        for (int i=1;i<=NUM_BULLETS;i++){
            buttons[i-1].setEnabled(true);
        }
        generateRandom();
    }

    private void generateRandom(){
        bullet = (int) (Math.random()*NUM_BULLETS)+1;
    }
}
