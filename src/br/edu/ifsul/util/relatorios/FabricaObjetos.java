/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author leand
 */
public class FabricaObjetos {
    
    public static List<Curso> carregaCursos() {
        List<Curso> list = new ArrayList<>();
        Curso obj = new Curso();
        
        obj.setNome("Tecnologo em Sistemas de informação para a Internet");
        obj.setSigla("TSPI");
        
        Instituicao inst = new Instituicao();
        inst.setNome("IFSUL");
        inst.setAnoFundacao(2010);
        obj.setInstituicao(inst);
        obj.setInicioAtividades(Calendar.getInstance());
        obj.setId(1);
        obj.setAtivo(true);
        obj.setDescricao("Curso foda");
        
        Disciplina disc = new Disciplina();
        obj.adicionarDisciplina(disc);
        list.add(obj);
        return list;
    }
}
