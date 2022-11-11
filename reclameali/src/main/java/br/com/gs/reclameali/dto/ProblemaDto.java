package br.com.gs.reclameali.dto;

public class ProblemaDto {

    private String name;

    private String problem;

    private String type;



    public ProblemaDto(String name, String problem, String type) {
        this.name = name;
        this.problem = problem;
        this.type = type;
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
}
