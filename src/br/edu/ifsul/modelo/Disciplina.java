/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro Grando
 */
@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Length(message = "O nome não pode ter mais que {max} caracteres.")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotNull(message = "A descrição não pode ser nulo.")
    @NotBlank(message = "A descrição não pode estar em branco.")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "A carga horária deve ser informada.")
    @Column(name = "carga_horaria", nullable = false, columnDefinition = "decimal(10,2)")
    private Double cargaHorario;
    
    @NotNull(message = "O campo conhecimentos mínimos não pode ser nulo.")
    @NotBlank(message = "O campo conhecimentos mínimos não pode estar em branco.")
    @Column(name = "conhecimentos_minimos", nullable = false, columnDefinition = "text")
    private String conhecimentosMinimos;
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();
    
    @NotNull(message = "O curso deve ser informada")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_curso_disciplina")
    private Curso curso;
    
    @ManyToMany
    @JoinTable(name = "alunos_disciplina",
            joinColumns = 
            @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false), 
            uniqueConstraints = {@UniqueConstraint(columnNames = {"disciplina", "aluno"})})
   private List<Aluno> inscritosDisciplina = new ArrayList<>();

    public Disciplina() {
    }
    
    public void adicionarNota(Nota obj) {
        obj.setDisciplina(this);
        notas.add(obj);
    }
    
    public void removerNota(int index) {
        notas.remove(index);
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(Double cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getInscritosDisciplina() {
        return inscritosDisciplina;
    }

    public void setInscritosDisciplina(List<Aluno> inscritosDisciplina) {
        this.inscritosDisciplina = inscritosDisciplina;
    }
    
    
}
