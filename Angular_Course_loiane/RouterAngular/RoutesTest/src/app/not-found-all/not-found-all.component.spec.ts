import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotFoundAllComponent } from './not-found-all.component';

describe('NotFoundAllComponent', () => {
  let component: NotFoundAllComponent;
  let fixture: ComponentFixture<NotFoundAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotFoundAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotFoundAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
