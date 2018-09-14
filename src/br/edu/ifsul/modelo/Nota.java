/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Leandro Grando
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A nota um deve ser informada.")
    @Column(name = "nota_um", nullable = false, columnDefinition = "decimal(10,2)")
    private Double nota01;
    
    @NotNull(message = "A nota dois deve ser informada.")
    @Column(name = "nota_dois", nullable = false, columnDefinition = "decimal(10,2)")
    private Double nota02;
    
    @NotNull(message = "A média não foi calculada.")
    @Column(name = "media", nullable = false, columnDefinition = "decimal(10,2)")
    private Double media;
    
    @NotNull(message = "O aluno deve ser informada.")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_aluno_nota")
    private Aluno aluno;

    public Nota() {
    }
    
    public void calcularMedia() {
        this.media = (nota01 + nota02) / 2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
