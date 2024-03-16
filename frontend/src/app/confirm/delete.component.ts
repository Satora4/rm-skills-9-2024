import { Component } from '@angular/core';
import {AnalysisService} from "../analysis/analysis.service";

@Component({
  selector: 'delete-modal',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.scss']
})
export class DeleteComponent {
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
