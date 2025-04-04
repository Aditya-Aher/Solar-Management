import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VisitorService } from 'src/app/services/visitor.service';
import { Visitor } from '../../model/visitor';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  visitors: Visitor[] = [];

  constructor(private visitorService: VisitorService, private router: Router) {}

  ngOnInit(): void {
    this.getAllVisitors();
  }

  getAllVisitors(): void {
    this.visitorService.getVisitors().subscribe({
      next: (data) => this.visitors = data,
      error: (err) => console.error(err)
    });
  }

  addVisitor(): void {
    this.router.navigate(['/visitor']);
  }

  viewVisitor(visitor: Visitor): void {
    alert(`View Visitor: ${JSON.stringify(visitor, null, 2)}`);
  }

  editVisitor(visitor: Visitor): void {
    this.router.navigate(['/visitor', visitor.id]);
  }

  deleteVisitor(id: number): void {
    if (confirm('Are you sure to delete this visitor?')) {
      this.visitorService.deleteVisitor(id).subscribe({
        next: () => this.getAllVisitors(),
        error: (err) => console.error(err)
      });
    }
  }
} 
