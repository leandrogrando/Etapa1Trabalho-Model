/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirDisciplina {
    
    EntityManager em;
    
    public TestePersistirDisciplina() {
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
    public void teste(){
        boolean exception = false;
        try {
            Disciplina d = new Disciplina();
            d.setCargaHorario(80.0);
            d.setConhecimentosMinimos("Teste");
            d.setDescricao("Descrição teste");
            d.setNome("Desenvolvumento de Aplicações Web");
            
            Curso c = em.find(Curso.class, 8);
            
            d.setCurso(c);
            
            Nota n = new Nota();
            n.setNota01(10.0);
            n.setNota02(9.0);
            n.calcularMedia();
            n.setAluno(em.find(Aluno.class, 2));
            
            d.adicionarNota(n);
            
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        /*
        O método abaixo verifica se o valor esperado (false) é
        igual ao valor do atributo exception, que vai indicar se ocorreu ou não erro.
        Se não ocorrer erro o teste passa. 
        */
        Assert.assertEquals(false, exception);
    }
    
}