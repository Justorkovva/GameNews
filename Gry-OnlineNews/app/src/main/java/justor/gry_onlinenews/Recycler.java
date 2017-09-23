package justor.gry_onlinenews;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import justor.gry_onlinenews.GryTask;

import static justor.gry_onlinenews.MainActivity.URL;
import static justor.gry_onlinenews.MainActivity.stat_title;

public class Recycler extends AppCompatActivity {

    private GryTask _task = null;

    private GryAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        Context context = Recycler.this;
        setTitle(stat_title);

        GryTask _task = null;

        GryAdapter _adapter;


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        _adapter = new GryAdapter(this, context);
        recyclerView.setAdapter(_adapter);

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        _adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                progress.setVisibility(View.GONE);
            }


        });


         _task = new GryTask(_adapter);
        _task.execute(URL);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
     //   _task.cancel(true);
    }


}
