package br.com.gs.reclameali.dto;

public class RegistroEmailDto {

    private String email;

    public RegistroEmailDto(){}

    public RegistroEmailDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
