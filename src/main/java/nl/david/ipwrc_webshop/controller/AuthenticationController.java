package nl.david.ipwrc_webshop.controller;

import org.springframework.web.bind.annotation.RestController;

import nl.david.ipwrc_webshop.DTO.JwtAuthenticationDTO;
import nl.david.ipwrc_webshop.DTO.SignInRequest;
import nl.david.ipwrc_webshop.service.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationDTO> signIn(@RequestBody SignInRequest signInRequest) {
     return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
    
    
}
