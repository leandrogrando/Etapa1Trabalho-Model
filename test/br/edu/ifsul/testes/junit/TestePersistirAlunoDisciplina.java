/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
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
public class TestePersistirAlunoDisciplina {
    
    EntityManager em;
    
    public TestePersistirAlunoDisciplina() {
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
            Disciplina obj = em.find(Disciplina.class, 9);
            Aluno a = em.find(Aluno.class, 6);
            obj.getInscritosDisciplina().add(a);
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
