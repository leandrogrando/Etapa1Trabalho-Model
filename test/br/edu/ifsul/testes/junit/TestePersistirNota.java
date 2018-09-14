/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Nota;
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
public class TestePersistirNota {
    
    EntityManager em;
    
    public TestePersistirNota() {
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
            
            Nota obj = new Nota();
            Aluno a = em.find(Aluno.class, 2);
            
            obj.setAluno(a);
            obj.setNota01(9.00);
            obj.setNota02(10.00);
            obj.calcularMedia();
            
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
