package justor.gry_onlinenews;

/**
 * Created by Lenovo on 17.09.2017.
 */

import justor.gry_onlinenews.Gry;

import java.util.List;

public interface GryCallback {
    void onArticlesReceived(List<Gry> var1, boolean var2);
}
