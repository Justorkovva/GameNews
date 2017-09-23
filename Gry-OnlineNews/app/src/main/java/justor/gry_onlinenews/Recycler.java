package justor.gry_onlinenews;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        //set title in navigation bar
        setTitle(stat_title);

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

    //refresh activity
    public void refresh(View v) {
        recreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(_task != null)
        _task.cancel(true);
    }
}
