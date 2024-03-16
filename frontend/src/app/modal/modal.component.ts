import { Component } from '@angular/core';
import {AnalysisService} from "../analysis/analysis.service";

@Component({
  selector: 'create-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent {
  modalOpen: boolean = false;
  analysis: any = {
    phoneName: '',
    price: null,
    manufacture: '',
    lookAndFeel: '',
    ram: null,
    os: '',
    osVersion: null,
    storage: null,
    cam: null
  };

  constructor(private analysisService: AnalysisService) {
  }

  openModal() {
    this.modalOpen = true;
  }

  closeModal() {
    this.modalOpen = false;
  }

  submitForm() {
    console.log('Submitted Analysis:', this.analysis);
    this.analysisService.createAnalysis(this.analysis).subscribe();
    this.closeModal();
  }
}
