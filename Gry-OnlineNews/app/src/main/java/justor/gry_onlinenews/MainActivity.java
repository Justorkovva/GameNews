package justor.gry_onlinenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static String URL;
    public static CharSequence stat_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b1=(Button) findViewById(R.id.button1);
       final Button b2=(Button) findViewById(R.id.button2);
        final Button b3=(Button) findViewById(R.id.button3);
        final Button b4=(Button) findViewById(R.id.button4);
        final Button b5=(Button) findViewById(R.id.button5);
        final Button b6=(Button) findViewById(R.id.button6);
        final  Button b7=(Button) findViewById(R.id.button7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/news.xml";
                stat_title=b1.getText();
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/poradniki.xml";
                stat_title=b2.getText();
            }});
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/teksty.xml";
                stat_title=b3.getText();
            }});
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/pliki.xml";
                stat_title=b4.getText();
            }});
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/kody.xml";
                stat_title=b5.getText();
            }});
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/video.xml";
                stat_title=b6.getText();
            }});
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recycler.class);
                startActivity(myIntent);
                URL="http://www.gry-online.pl/rss/galerie.xml";
                stat_title=b7.getText();
            }});

        //zrobic to samo dla pozostałych buttonów





    }
}
