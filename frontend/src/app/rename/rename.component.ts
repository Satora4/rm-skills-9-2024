import { Component } from '@angular/core';
import {AnalysisService} from "../analysis/analysis.service";
import {RenameAnalysis} from "../analysis/renameAnalysis";

@Component({
  selector: 'rename-modal',
  templateUrl: './rename.component.html',
  styleUrls: ['./rename.component.scss']
})
export class RenameComponent {
  modalOpen: boolean = false;
  names: RenameAnalysis = {
    oldName: '',
    newName: ''
  };

  constructor(private analysisService: AnalysisService) {
  }

  public openModal() {
    this.modalOpen = true;
  }

  closeModal() {
    this.modalOpen = false;
  }

  submitForm() {
    console.log('Submitted Analysis:', this.names);
    this.analysisService.renameAnalysis(this.names).subscribe();
    this.closeModal();
  }
}
