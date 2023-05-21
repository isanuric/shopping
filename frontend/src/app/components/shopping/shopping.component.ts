import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-shopping',
  templateUrl: './shopping.component.html',
  styleUrls: ['./shopping.component.scss']
})
export class ShoppingComponent implements OnInit {

  title = "Shopping";

  users: any[] = [];


  constructor(private usersService:UsersService) {}

  ngOnInit() {
    this.usersService.getUsers().subscribe(
      next => {
        this.users= next;
      }
    );
  }

}
