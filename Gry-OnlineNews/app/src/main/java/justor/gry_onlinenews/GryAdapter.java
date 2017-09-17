package justor.gry_onlinenews;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import justor.gry_onlinenews.Gry;
import justor.gry_onlinenews.GryCallback;
import java.util.ArrayList;
import java.util.List;

public class GryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements GryCallback {

    private static Context _context;
    private Recycler _recycler;


    public GryAdapter(Recycler recycler, Context context) {
        _recycler = recycler;
        this._context = context;
    }

    public GryAdapter() {
    }

    private static final int VIEW_TYPE_ARTICLE = 0;
    private static final int VIEW_TYPE_PROGRESS = 1;

    private final List<Gry> _gra = new ArrayList<Gry>();

    private boolean _hasMore = false;

    @Override
    public void GryReceived(List<Gry> articles, boolean hasMore) {
        _gra.addAll(articles);
        _hasMore = hasMore;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return _gra.size() + (_hasMore ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (position < _gra.size())
            return VIEW_TYPE_ARTICLE;
        else
            return VIEW_TYPE_PROGRESS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_ARTICLE: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new GryViewHolder(view);
            }
            case VIEW_TYPE_PROGRESS: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_progress, parent, false);
                return new ProgressViewHolder(view);
            }
            default:
                throw new IllegalStateException("Unknown type" + viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof GryViewHolder)
            ((GryViewHolder) holder).bind(_gra.get(position));
        else if (holder instanceof ProgressViewHolder) {
            _recycler.loadNext();
        }
    }

    public static class GryViewHolder extends RecyclerView.ViewHolder {

        private final TextView _title;
        public String url;
        public String send_title;

        public GryViewHolder(final View itemView) {
            super(itemView);

            _title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(_context, Article.class);
                    myIntent.putExtra("url", url);
                    myIntent.putExtra("title", send_title);
                    _context.startActivity(myIntent);
                }
            });
        }

        public void bind(Gry _gry) {
            _title.setText(_gry.title);
            url = _gry.link;
            send_title = _gry.title;
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }
}