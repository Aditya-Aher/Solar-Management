import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Visitor } from '../../model/visitor';
import { VisitorService } from 'src/app/services/visitor.service';

@Component({
  selector: 'app-visitor-form',
  templateUrl: './visitor-form.component.html',
})
export class VisitorFormComponent implements OnInit {
  visitorForm!: FormGroup;
  isEditMode = false;
  visitorId!: number;

  constructor(
    private fb: FormBuilder,
    private visitorService: VisitorService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.visitorForm = this.fb.group({
      consumerName: ['', Validators.required],
      consumerNumber: ['', Validators.required],
      subcdStatus: ['', Validators.required],
      installationStatus: ['', Validators.required],
      reasonNotDone: [''],
      queries: ['']
    });

    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.visitorId = +id;
        this.loadVisitor(this.visitorId);
      }
    });
  }

  loadVisitor(id: number) {
    this.visitorService.getVisitors().subscribe(visitors => {
      const visitor = visitors.find(v => v.id === id);
      if (visitor) {
        this.visitorForm.patchValue(visitor);
      }
    });
  }

  onSubmit(): void {
    if (this.visitorForm.invalid) return;

    const visitor: Visitor = this.visitorForm.value;

    if (this.isEditMode) {
      this.visitorService.updateVisitor(this.visitorId, visitor.installationStatus).subscribe(() => {
        alert('Visitor updated!');
        this.router.navigate(['/']);
      });
    } else {
      this.visitorService.createVisitor(visitor).subscribe(() => {
        alert('Visitor added!');
        this.router.navigate(['/']);
      });
    }
  }
}
