package br.com.gs.reclameali.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_FUNCAO")
@SequenceGenerator(name = "SQ_FUNCAO", sequenceName = "SQ_FUNCAO", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "cd_funcao", length = 3, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCAO")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nm_funcao", length = 30, unique = true)
    private Roles name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH)
    private List<Usuario> users;

    public Role() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role(Roles roles) {
        this.name = roles;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public void setUsers(List<Usuario>users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }

}
