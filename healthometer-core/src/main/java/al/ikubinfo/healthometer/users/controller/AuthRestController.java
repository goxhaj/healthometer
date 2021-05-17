package al.ikubinfo.healthometer.users.controller;

import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.security.JWTFilter;
import al.ikubinfo.healthometer.users.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@AllArgsConstructor
public class AuthRestController {

  @Autowired private AuthService authService;

  @PostMapping(value = "")
  public ResponseEntity<AuthDto> authorize(@RequestBody AuthDto authDto) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + authService.getToken(authDto));
    return new ResponseEntity<>(authDto, httpHeaders, HttpStatus.OK);
  }
}
