/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leandro Grando
 */
public class TestePersistirProfessor {
    
    EntityManager em;
    
    public TestePersistirProfessor() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste() {
        boolean erro = false;
        try {
            Professor obj = new Professor();
            obj.setNome("Leandro José Grando");
            obj.setEmail("leandro-grando@hotmail.com");
            Calendar data = new GregorianCalendar(1995, 01, 11);
            obj.setNascimento(data);
            obj.setTitulacao("Doutor");
            obj.setTopicosInteresse("Programação web");
            obj.setEspecialidade(em.find(Especialidade.class, 1));
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            erro = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, erro);
    }
    
}
