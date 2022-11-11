package br.com.gs.reclameali.dto;

import br.com.gs.reclameali.model.Endereco;

import java.util.Date;
import java.util.List;

public class UsuarioDto {

    private String name;

    private String surname;

    private String email;

    private String password;

    private Date birth;

    private List<Endereco> enderecos;

    public UsuarioDto(String name, String surname, String email, String password, Date birth, List<Endereco> enderecos) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.enderecos = enderecos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
