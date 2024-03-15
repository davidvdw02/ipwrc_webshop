package nl.david.ipwrc_webshop.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import nl.david.ipwrc_webshop.DTO.JwtAuthenticationDTO;
import nl.david.ipwrc_webshop.DTO.SignInRequest;
import nl.david.ipwrc_webshop.model.Account;

@Service
public class AuthenticationService {

    private final AccountService accountService;;
     private final JwtService jwtService;

    public AuthenticationService(AccountService accountService, JwtService jwtService) {
        this.accountService = accountService;
        this.jwtService = jwtService;

    }
    
    public JwtAuthenticationDTO signIn(SignInRequest signInRequest) {
        Account account = accountService.findByUsername(signInRequest.getUsername()).orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"User not found with username: " + signInRequest.getUsername()));
        if(!account.getPassword().equals(signInRequest.getPassword())) { throw new ResponseStatusException(HttpStatus.UNAUTHORIZED); }
        return new JwtAuthenticationDTO(jwtService.generateToken(account.getUsername()));

    }
}
