package nl.david.ipwrc_webshop.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationDTO {
    private String JwtToken;

    public JwtAuthenticationDTO(String jwtToken) {
        JwtToken = jwtToken;
    }
}
