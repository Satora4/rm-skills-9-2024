import { Component } from '@angular/core';
import {AnalysisService} from "../analysis/analysis.service";

@Component({
  selector: 'delete-modal',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.scss']
})
export class ConfirmComponent {
  modalOpen: boolean = false;
  name: string = '';

  constructor(private analysisService: AnalysisService) {
  }

  openModal() {
    this.modalOpen = true;
  }

  closeModal() {
    this.modalOpen = false;
  }

  submitForm() {
    console.log('deleted Analysis');
    this.analysisService.deleteAnalysis(this.name).subscribe();
    this.closeModal();
  }
}
