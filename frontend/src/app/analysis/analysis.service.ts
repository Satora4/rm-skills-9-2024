import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {handleError} from "../util/http.util";
import {Analysis} from "./analysis";

@Injectable({
  providedIn: 'root'
})
export class AnalysisService {

  private analysisUrl = 'api/analysis';

  constructor(private http: HttpClient) {}

  getAnalysis(): Observable<Analysis[]> {
    return this.http.get<Analysis[]>(this.analysisUrl).pipe(tap({ complete: () => console.log('fetched Analyses') }), catchError(handleError<Analysis[]>('getAllAnalysis', [])));
  }

  createAnalysis(analysis: Analysis): Observable<Analysis> {
    return this.http.post<Analysis>(this.analysisUrl, analysis).pipe(tap({ complete: () => console.log('created Analysis') }), catchError(handleError<Analysis>('createAnalysis')));
  }

}
