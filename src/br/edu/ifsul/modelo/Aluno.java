/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro Grando
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
public class Aluno implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Length(message = "O nome não pode ter mais que {max} caracteres.")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Email(message = "O e-mail deve ser válido.")
    @NotNull(message = "O e-mail não pode ser nulo.")
    @Length(message = "O e-mail não pode ter mais que {max} caracteres.")
    @NotBlank(message = "O e-mail não pode estar em branco.")
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @NotNull(message = "A data de nascimento deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @ManyToMany
    @JoinTable(name = "alunos_disciplina",
            joinColumns = 
            @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"disciplina", "aluno"})})   
    private List<Disciplina> inscritoDiscplinas = new ArrayList<>();

    public Aluno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Disciplina> getInscritoDiscplinas() {
        return inscritoDiscplinas;
    }

    public void setInscritoDiscplinas(List<Disciplina> inscritoDiscplinas) {
        this.inscritoDiscplinas = inscritoDiscplinas;
    }
    
    
}
