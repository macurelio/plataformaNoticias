// home.component.ts
import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  recentNews: any[] = [];

  constructor(private newsService: NewsService) { }

  ngOnInit(): void {
    this.newsService.getRecentNews().subscribe(news => this.recentNews = news);
  }

  addToFavorites(newsItem: any): void {
    this.newsService.addToFavorites(newsItem);
  }
}

