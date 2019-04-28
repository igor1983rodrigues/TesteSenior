import { TestBed } from '@angular/core/testing';

import { AMModalService } from './am-modal.service';

describe('AMModalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AMModalService = TestBed.get(AMModalService);
    expect(service).toBeTruthy();
  });
});
