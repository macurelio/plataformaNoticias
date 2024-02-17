package Controller;


import Model.News;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private List<News> newsList = new ArrayList<>();

    @GetMapping
    public List<News> getNews() {
        // Devuelve todas las noticias
        return newsList;
    }

    @PostMapping
    public void addNews(@RequestBody News news) {
        // Añade una nueva noticia
        newsList.add(news);
    }

    @GetMapping("/favorites")
    public List<News> getFavoriteNews() {
        // Devuelve las noticias marcadas como favoritas
        List<News> favorites = new ArrayList<>();
        for (News news : newsList) {
            if (news.isFavorite()) {
                favorites.add(news);
            }
        }
        return favorites;
    }

    @PostMapping("/{newsId}/favorite")
    public void addToFavorites(@PathVariable("newsId") int newsId) {
        // Marca una noticia como favorita
        newsList.get(newsId).setFavorite(true);
        newsList.get(newsId).setFavoriteDate(new Date());
    }
}
