package justor.gry_onlinenews;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import justor.gry_onlinenews.Gry;
import justor.gry_onlinenews.GryCallback;

public class GryTask extends AsyncTask<Void, Void, GryTask.GryList> {

    private static final DateFormat _dateParser;
    private final GryCallback _callback;
    private final String url;
    //private final int button;

    public GryTask(GryCallback callback, String url) {
        this._callback = callback;
        this.url = url;
        //this.button = button;
    }

    protected GryTask.GryList doInBackground(Void... params) {
        try {
            Thread.sleep((long)((new SecureRandom()).nextInt(2000) + 2000));
            URL e = new URL(url);
            HttpURLConnection con = (HttpURLConnection)e.openConnection();
            JSONObject json = new JSONObject(this._toString(con.getInputStream()));
            GryTask.GryList list = new GryTask.GryList(json.getBoolean("has_more_items"));
            JSONArray items = json.getJSONArray("items");

            for(int i = 0; i < items.length(); ++i) {
                JSONObject item = items.getJSONObject(i);
                list.gra.add(new Gry(item.getString("title"), item.getString("link"), item.getString("description"), item.getString("author"), _dateParser.parse(item.getString("date")), item.getString("category"), item.getString("guid")));
            }

            return list;
        } catch (IOException var9) {
            throw new RuntimeException(var9);
        } catch (JSONException var10) {
            throw new RuntimeException(var10);
        } catch (ParseException var11) {
            throw new RuntimeException(var11);
        } catch (InterruptedException var12) {
            return null;
        }
    }

    private String _toString(InputStream stream) throws IOException {
        InputStreamReader reader = new InputStreamReader(stream);
        StringBuilder str = new StringBuilder();
        CharBuffer buf = CharBuffer.allocate(2048);

        while(reader.read(buf) != -1) {
            buf.flip();
            str.append(buf);
            buf.clear();
        }

        return str.toString();
    }

    protected void onPostExecute(GryTask.GryList result) {
        if(result != null) {
            this._callback.GryReceived(result.gra, result.hasMore);
        }

    }

    static {_dateParser = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);}

    public static class GryList {
        public final List<Gry> gra = new ArrayList();
        public final boolean hasMore;

        public GryList(boolean hasMore) {
            this.hasMore = hasMore;
        }
    }
}