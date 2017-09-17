package justor.gry_onlinenews;

import java.util.Date;

/**
 * Created by Lenovo on 17.09.2017.
 */

public class Gry {
    public final String title;
    public final String link;
    public final String description;
    public final String author;
    public final Date date;
    public final String category;
    public final String guid;

    public Gry(String title, String link, String description, String author, Date date, String category, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.author = author;
        this.date = date;
        this.category = category;
        this.guid = guid;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            Gry gry = (Gry)o;
            return this.author.equals(gry.author) && this.date == gry.date && this.title.equals(gry.title) && this.link.equals(gry.link) && this.description.equals(gry.description) && this.category.equals(gry.category) && this.guid.equals(gry.guid);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.title.hashCode();
        result = 31 * result + this.link.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.author.hashCode();
        result = 31 * result + this.date.hashCode();
        result = 31 * result + this.category.hashCode();
        result = 31 * result + this.guid.hashCode();
        return result;
    }
}
