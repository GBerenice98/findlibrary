import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  title = 'frontend';

  isExpanded = true;
  state = 'collapsed';

  @Output() sidenavToggled = new EventEmitter();

  menuItems = [
    {
      title: 'Home',
      icon: 'home',
      url: '/home'
    },
    {
      title: 'Graphes',
      icon: 'image',
      url: '/graphes'
    },
    {
      title: 'Historique',
      icon: 'timeline',
      url: '/historique'
    }
  ];

  constructor() {
  }

  ngOnInit() {
  }

  toggleSidenavHeader() {
    this.isExpanded = !this.isExpanded;
    this.sidenavToggled.emit(this.isExpanded);
  }

  toggleSidenavCollapsed() {
    this.isExpanded = !this.isExpanded;
    this.state = 'collapsed';
  }

  toggleSidenavHidden() {
    this.isExpanded = !this.isExpanded;
    this.state = 'hidden';
  }

  toggleSidenav(e : Event) {
    console.log(" event : ", e);
    this.isExpanded = true;
  }

  open() {
    this.isExpanded = true;
  }

  close() {
    this.isExpanded = false;
  }


}
