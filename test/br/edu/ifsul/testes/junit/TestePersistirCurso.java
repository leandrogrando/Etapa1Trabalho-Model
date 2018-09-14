/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Instituicao;
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
public class TestePersistirCurso {
    
    EntityManager em;
    
    public TestePersistirCurso() {
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
            Curso obj = new Curso();
            obj.setAtivo(true);
            
            Calendar data = new GregorianCalendar(2010,10,10);
            obj.setInicioAtividades(data);
            obj.setNome("Desenvolvimento de aplicações Web");
            obj.setSigla("DAW");
            obj.setDescricao("Teste");
            obj.setInstituicao(em.find(Instituicao.class, 1));
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
