import { TestBed } from '@angular/core/testing';

import { SecondTestService } from './second-test.service';

describe('SecondTestService', () => {
  let service: SecondTestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecondTestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
