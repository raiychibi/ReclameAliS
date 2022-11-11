package br.com.gs.reclameali.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Table(name= "TB_USUARIO")
@SequenceGenerator(name= "SQ_USUARIO", sequenceName = "SQ_USUARIO", initialValue = 1)
@Entity
public class Usuario implements UserDetails {

    @Id
    @Column(name= "cd_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    private Long id;

    @Column(name= "nm_primeiro")
    private String name;

    @Column(name= "nm_segundo")
    private String surname;

    @Column(name= "ds_email")
    private String email;

    @Column(name= "ds_senha")
    private String password;

    @Column(name= "dt_nascimento")
    private Date birth;

    @Column(name= "dt_criacao")
    private Date create;

    @Column(name= "dt_alteracao")
    private Date change;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Problema> problemas;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "TB_USUARIO_ENDERECO",
            joinColumns = @JoinColumn(name = "cd_usuario"),
            inverseJoinColumns = @JoinColumn(name = "cd_endereco"))
    private List<Endereco> enderecos;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            name = "TB_USUARIO_FUNCAO",
            joinColumns = @JoinColumn(name = "cd_usuario"),
            inverseJoinColumns = @JoinColumn(name = "cd_funcao"))
    private List<Role> roles = new ArrayList<>();

    public Usuario(){}


    public Usuario(Long id, String name, String surname, String email, String password, Date birth, Date create,
                   Date change, List<Problema> problemas, List<Endereco> enderecos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.create = create;
        this.change = change;
        this.problemas = problemas;
        this.enderecos = enderecos;
        this.roles.add(new Role(Roles.ROLE_USUARIO));
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
