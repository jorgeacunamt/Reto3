package co.edu.usa.fincaapp.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false,length = 50)
    private String name;
    @Column(name="description")
    private String description; 
    
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "categoria")
    
    private List<Finca> fincas;

    public List<Finca> getFincas(){
        return fincas;
    }
    public void setFincas(List<Finca> fincas){
        this.fincas = fincas;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
