// news.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private apiUrl = 'https://api.spaceflightnewsapi.net/v4/articles';
  private favoriteNews: any[] = [];

  constructor(private http: HttpClient) { }

  getRecentNews(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl, { params: new HttpParams().set('_limit', '10') });
  }

  addToFavorites(newsItem: any): void {
    newsItem.favoriteDate = new Date();
    this.favoriteNews.push(newsItem);
  }

  getFavoriteNews(): any[] {
    return this.favoriteNews;
  }
}



