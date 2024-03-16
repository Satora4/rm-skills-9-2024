import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RenameComponent } from './rename.component';

describe('ModalComponent', () => {
  let component: RenameComponent;
  let fixture: ComponentFixture<RenameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RenameComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RenameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
