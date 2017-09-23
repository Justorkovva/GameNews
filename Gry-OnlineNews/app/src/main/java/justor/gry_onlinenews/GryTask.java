package justor.gry_onlinenews;

import android.os.AsyncTask;
import android.util.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;


public class GryTask extends AsyncTask<String, Void, Document> {

    interface DocumentConsumer {
        void setXMLDocument(Document document);}

    private DocumentConsumer _consumer;

    public GryTask(DocumentConsumer consumer) {_consumer=consumer;}

    @Override
    protected Document doInBackground(String... params)
    {
        try{
        Thread.sleep(3000);

        URL url = new URL(params[0]);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            try {
                return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);
            }
            finally {
                stream.close();
            }
    }
    catch (Exception ex) {
        Log.e("XMLAsyncTask", "Exception while downloading", ex);
        throw new RuntimeException(ex);
    }}

    @Override
    protected void onPostExecute(Document result) {
        Log.e("XMLAsyncTask", "Finished");
        _consumer.setXMLDocument(result);
    }
    }