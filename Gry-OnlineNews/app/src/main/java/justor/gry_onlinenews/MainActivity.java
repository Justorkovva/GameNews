package justor.gry_onlinenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.button1);
        Button b2=(Button) findViewById(R.id.button2);
        Button b3=(Button) findViewById(R.id.button3);
        Button b4=(Button) findViewById(R.id.button4);
        Button b5=(Button) findViewById(R.id.button5);
        Button b6=(Button) findViewById(R.id.button6);
        Button b7=(Button) findViewById(R.id.button7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/news.xml";
            }});





    }
}
