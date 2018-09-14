/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Leandro Grando
 */
public class Disciplina implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    Integer id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Length(message = "O nome não pode ter mais que {max} caracteres.")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Column(name = "nome", nullable = false, length = 50)
    String nome;
    
    @NotNull(message = "A descrição não pode ser nulo.")
    @NotBlank(message = "A descrição não pode estar em branco.")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    String descricao;
    
    @NotNull(message = "A carga horária deve ser informada.")
    @Column(name = "carga_horaria", nullable = false, columnDefinition = "decimal(10,2)")
    Double cargaHorario;
    
    @NotNull(message = "O campo conhecimentos mínimos não pode ser nulo.")
    @NotBlank(message = "O campo conhecimentos mínimos não pode estar em branco.")
    @Column(name = "conhecimentos_minimos", nullable = false, columnDefinition = "text")
    String conhecimentosMinimos;
}
