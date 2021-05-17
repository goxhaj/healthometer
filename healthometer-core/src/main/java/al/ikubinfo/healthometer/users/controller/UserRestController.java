package al.ikubinfo.healthometer.users.controller;

import al.ikubinfo.healthometer.users.dto.PasswordDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserRestController {

  private UserService userService;

  @GetMapping(path = "/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
    return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<UserDto> editUser(
      @PathVariable("id") Long id, @RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.editUser(id, userDto), HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("User deleted", HttpStatus.OK);
  }

  @PutMapping(path = "/{id}/change-role/{newRole}")
  public ResponseEntity<UserDto> changeRole(
      @PathVariable("id") Long id, @PathVariable("newRole") String newRole) {
    return new ResponseEntity<>(userService.changeRole(id, newRole), HttpStatus.OK);
  }

  @PutMapping(path = "/{id}/change-password")
  public ResponseEntity<UserDto> changePassword(
      @PathVariable("id") Long id, @RequestBody PasswordDto passwordDto) {
    return new ResponseEntity<>(userService.changePassword(id, passwordDto), HttpStatus.OK);
  }
}
