import {Injectable} from '@angular/core';
import {HttpClient, HttpStatusCode} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {handleError} from "../util/http.util";
import {Analysis} from "./analysis";
import {RenameAnalysis} from "./renameAnalysis";

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

  renameAnalysis(names: RenameAnalysis): Observable<string> {
    return this.http.put<string>(this.analysisUrl, names).pipe(tap({ complete: () => console.log('renamed Analysis') }), catchError(handleError<string>('renamedAnalysis')));
  }

  deleteAnalysis(name: string): Observable<string> {
    return this.http.put<string>(this.analysisUrl + "/delete", name).pipe(tap({ complete: () => console.log('deleted Analysis') }), catchError(handleError<string>('deleteAnalysis')));
  }
}
