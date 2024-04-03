package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.api.model.Escola;
import com.example.demo.api.model.Professor;

@Service
public class DemoApplicationService {

    private List<Escola> escolas = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    public DemoApplicationService(){
        escolas = new ArrayList<>();

        Escola escola1 = new Escola(1,"Escola A", "A@mail.com");
        Escola escola2 = new Escola(2,"Escola B", "B@mail.com");
        Escola escola3 = new Escola(3,"Escola C", "C@mail.com");
        Escola escola4 = new Escola(4,"Escola D", "D@mail.com");

        professores = new ArrayList<>();

        Professor professor1 = new Professor("Miguel", escola1.getId());
        Professor professor2 = new Professor("Arthur", escola2.getId());
        Professor professor3 = new Professor("Gael", escola3.getId());
        Professor professor4 = new Professor("Heitor", escola4.getId());
        Professor professor5 = new Professor("Theo", escola1.getId());
        Professor professor6 = new Professor("Davi", escola3.getId());

        escolas.addAll(Arrays.asList(escola1,escola2,escola3,escola4));

        professores.addAll(Arrays.asList(professor1,professor2,professor3,professor4,professor5,professor6));
    }

    public Optional<Escola> getEscola(Integer id) {
        Optional<Escola> optional = Optional.empty();
        for (Escola escola: escolas) {
            if(id == escola.getId()){
                optional = Optional.of(escola);
                return optional;
            }
        }
        return optional;
    }

    public Optional<Professor> getProfessor(Integer id) {
        Optional<Professor> optional = Optional.empty();
        for (Professor professor: professores) {
            if(id == professor.getId()){
                optional = Optional.of(professor);
                return optional;
            }
        }
        return optional;
    }

    
    public List<Escola> getEscolas() {
        return escolas;
    }

    public void createEscola(@RequestBody Escola escola) {
        escolas.add(escola);
    }

    public void deleteEscola(@PathVariable int id) {
        escolas.removeIf(s -> s.getId() == id);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Professor> getProfessores(@PathVariable int escolaId) {
        List<Professor> professoresIDescola = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getIdEscola() == escolaId) {
                professoresIDescola.add(professor);
            }
        }
        return professoresIDescola;
    }

    public void createProfessores(@PathVariable int escolaId, @RequestBody Professor Professor) {
        Professor.setIdEscola(escolaId);
        professores.add(Professor);
    }

    @DeleteMapping("/escola/{escolaId}/professores/{professorId}")
    public void deleteProfessores(@PathVariable int escolaId, @PathVariable int professorId) {
        professores.removeIf(t -> t.getId() == professorId && t.getIdEscola() == escolaId);
    }

}
