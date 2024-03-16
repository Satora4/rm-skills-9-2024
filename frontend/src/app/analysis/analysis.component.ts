import {Component, OnInit} from '@angular/core';
import {AnalysisService} from './analysis.service';
import {Analysis} from "./analysis";
import {ModalComponent} from "../modal/modal.component";

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrl: './analysis.component.scss'
})
export class AnalysisComponent implements OnInit{

  public analyses: Analysis[] = [];

  constructor(private analysisService: AnalysisService) {
  }

  ngOnInit(): void {
    this.analysisService.getAnalysis().subscribe((users) => {
      this.analyses = users;
    });
  }

}
