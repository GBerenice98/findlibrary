import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-info-modal',
  templateUrl: './info-modal.component.html',
  styleUrls: ['./info-modal.component.scss']
})
export class InfoModalComponent implements OnInit {

  @Input() message: string='';
  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit(): void {
  }

  goToAnotherPage()
  {
    this.activeModal.close('Close click')
  }

}
