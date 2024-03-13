import {Component, OnInit} from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {Role} from "../enum/Role"

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent implements OnInit {
  public users: User[] = [];

  private readonly names: string[] = [
    'Anna',
    'Max',
    'Sophie',
    'Felix',
    'Lena',
    'Tim',
    'Laura',
    'Jonas',
    'Mia',
    'Paul'
  ];

  private readonly roles: Role[] = [
    Role.B,
    Role.R
  ]

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.userService.getUsers().subscribe((users) => {
      this.users = users;
    });
  }

  addUser() {
    let user: User = {
      name: this.names[Math.floor(Math.random() * 9)],
      role: this.roles[Math.floor(Math.random() * 2)],
      administrator: true
    }
    this.userService.addUser(user).subscribe();
  }

  deleteUser() {
    this.userService.deleteUser(Math.floor(Math.random() * this.users.length)).subscribe();
  }

}
