import {Role} from "../enum/Role";

export interface User {
  name: string;
  role: Role;
  administrator: boolean;
}
