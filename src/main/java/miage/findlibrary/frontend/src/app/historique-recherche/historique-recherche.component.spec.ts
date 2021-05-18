import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriqueRechercheComponent } from './historique-recherche.component';

describe('HistoriqueRechercheComponent', () => {
  let component: HistoriqueRechercheComponent;
  let fixture: ComponentFixture<HistoriqueRechercheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoriqueRechercheComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoriqueRechercheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
