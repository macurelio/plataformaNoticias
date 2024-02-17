package Model;

import java.util.Date;


public class News {
    private int id;
    private String title;
    private String description;
    private String summary;
    private Date publicationDate;
    private boolean isFavorite;
    private Date favoriteDate;

    public void setFavorite(boolean favorite) {
    }

    public void setFavoriteDate(Date date) {
    }

    public boolean isFavorite() { return false;
    }
}
