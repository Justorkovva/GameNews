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

public class Recycler extends AppCompatActivity {

    private GryTask _task = null;
    private GryAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        Context context = Recycler.this;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        _adapter = new GryAdapter(this, context);
        recyclerView.setAdapter(_adapter);
        loadNext();

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        _adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                progress.setVisibility(View.GONE);
            }
        });
    }

    public void loadNext() {
        if (_task != null && _task.getStatus() != AsyncTask.Status.FINISHED)
            return;

        _task = new GryTask(_adapter, URL);
        _task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _task.cancel(true);
    }
}
