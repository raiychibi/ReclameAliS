package br.com.gs.reclameali.dto;

import java.util.List;

public class ProblemaUsuariosDto {

    private String name;

    private String problem;

    private String type;

    private List<UsuarioDto> usuarios;


    public ProblemaUsuariosDto(String name, String problem, String type, List<UsuarioDto> usuarios) {
        this.name = name;
        this.problem = problem;
        this.type = type;
        this.usuarios = usuarios;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDto> usuarios) {
        this.usuarios = usuarios;
    }
}

