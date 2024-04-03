package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.Escola;
import com.example.demo.api.model.Professor;
import com.example.demo.service.DemoApplicationService;

@RestController
public class DemoApplicationController {

	private DemoApplicationService demoApplicationService;

    public DemoApplicationController(DemoApplicationService demoApplicationService){
        this.demoApplicationService = demoApplicationService;
    }

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/escola")
    public Escola getEscola(@RequestParam Integer id) {
        Optional<Escola> escola = demoApplicationService.getEscola(id);
        return (Escola) escola.orElse(null);
    }

    @GetMapping("/escola/GetTodas")
    public List<Escola> getEscolas(){
        return demoApplicationService.getEscolas();
    }

    @PostMapping("/escola/Create")
    public String createEscola(@RequestBody Escola escola){
        demoApplicationService.createEscola(escola);
        return "Escola criada com sucesso";
    }

    @DeleteMapping("/escola")
    public String deleteEscola(@RequestParam Integer id) {
        demoApplicationService.deleteEscola(id);
        return "Escola deletada com sucesso";
    }

    @GetMapping("/escola/professores")
    public List<Professor> getProfessores(){
        return demoApplicationService.getProfessores();
    }

    @GetMapping("/escola/{escolaId}/professores")
    public List<Professor> getProfessores(@PathVariable int escolaId){
        return demoApplicationService.getProfessores(escolaId);
    }

    @PostMapping("/escola/{escolaId}/professores")
    public String createProfessores(@PathVariable int escolaId, @RequestBody Professor Professor){
        demoApplicationService.createProfessores(escolaId, Professor);
        return "Alterado/Criado Com sucesso";
    }

    @DeleteMapping("/escola/{escolaId}/professores/{professorId}")
    public String deleteProfessores(@PathVariable int escolaId, @PathVariable int professorId) {
        demoApplicationService.deleteProfessores(escolaId, professorId);
        return "Deletado Com sucesso";
    }

}
 