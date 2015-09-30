package es.ieselcaminas.amo11k.russianroulete2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FireListener{
    private Barrel barrel;
    FrameLayout color;
    TextView text;
    Button buttonReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barrel = (Barrel) findViewById(R.id.barrelLayout);
        barrel.setFireFistener((FireListener) this);

        buttonReload = (Button) findViewById(R.id.bReload);
        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barrel.reset();
                color = (FrameLayout) findViewById(R.id.coloLayout);
                text = (TextView) findViewById(R.id.bangText);
                color.setBackgroundColor(Color.CYAN);
                text.setVisibility(View.INVISIBLE);
                v.setEnabled(false);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void fire(boolean bang) {
        color = (FrameLayout) findViewById(R.id.coloLayout);
        text = (TextView) findViewById(R.id.bangText);
        if(bang){
            color.setBackgroundColor(Color.RED);
            text.setText("BANG!");
            text.setVisibility(View.VISIBLE);
            buttonReload.setEnabled(true);
        }
    }
}
