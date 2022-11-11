package br.com.gs.reclameali.model;





import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Table(name= "TB_PROBLEMA")
@SequenceGenerator(name= "SQ_PROBLEMA", sequenceName= "SQ_PROBLEMA", initialValue= 1)
@Entity
public class Problema {

    @Id
    @Column(name = "cd_problema")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROBLEMA")
    private Long id;

    @Column(name = "nm_problema")
    private String name;

    @Column(name = "ds_problema")
    private String problem;

    @Column(name = "ds_tipo")
    private String type;

    @Column(name = "dt_criacao")
    private Date create;

    @Column(name = "dt_alteracao")
    private Date change;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_PROBLEMA", joinColumns = @JoinColumn(name = "cd_problema"),
    inverseJoinColumns = @JoinColumn(name = "cd_usuario"))
    private List<Usuario> usuarios;

    public Problema() {
    }

    public Problema(Long id, String name, String problem, String type, Date create, Date change, List<Usuario> usuarios) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.type = type;
        this.create = create;
        this.change = change;
        this.usuarios = usuarios;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
