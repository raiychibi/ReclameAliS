package br.com.gs.reclameali.dto;

import br.com.gs.reclameali.model.Problema;


import java.util.Date;

import java.util.List;
import java.util.Set;

public class ProcurarPorEmailDto {


    private Long id;


    private String name;


    private String surname;


    private String email;


    private String password;


    private Date birth;


    private Date create;


    private Date change;


    private List<Problema> problemas;



    public ProcurarPorEmailDto(Long id, String name, String surname, String email,
                               String password, Date birth, Date create, Date change, List<Problema> problemas) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.create = create;
        this.change = change;
        this.problemas = problemas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getChange() {
        return change;
    }

    public void setChange(Date change) {
        this.change = change;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }
}
