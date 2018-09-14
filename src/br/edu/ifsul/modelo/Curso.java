/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro Grando
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Length(message = "O nome não pode ter mais que {max} caracteres.")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotNull(message = "A sigla não pode ser nulo.")
    @Length(message = "A sigla não pode ter mais que {max} caracteres.")
    @NotBlank(message = "A sigla não pode estar em branco.")
    @Column(name = "sigla", nullable = false, length = 5)
    private String sigla;
    
    @NotNull(message = "A descrição não pode ser nulo.")
    @Length(message = "A descrição pode ter mais que {max} caracteres.")
    @NotBlank(message = "A descrição não pode estar em branco.")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "O início de atividades deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio_atividades", nullable = false)
    private Calendar inicioAtividades;
    
    @NotNull(message = "A instituição deve ser informada")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_instituicao_curso")
    private Instituicao instituicao;

    public Curso() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    
    
    
}
