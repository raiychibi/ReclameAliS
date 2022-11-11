package br.com.gs.reclameali.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
public class Endereco {

    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    private Long id;

    @Column(name = "ds_rua")
    private String street;

    @Column(name = "ds_cep")
    private String zipcode;

    @Column(name = "ds_cidade")
    private String city;

    @Column(name = "ds_estado")
    private String state;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "enderecos")
    private List<Usuario> usuarios;


    public Endereco() {
    }

    public Endereco(String street, String zipcode, String city, String state) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
