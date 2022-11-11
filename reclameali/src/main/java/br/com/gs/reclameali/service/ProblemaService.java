package br.com.gs.reclameali.service;

import br.com.gs.reclameali.model.Problema;
import br.com.gs.reclameali.repository.ProblemaRepository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProblemaService {

    private final ProblemaRepository repository;

    public ProblemaService(ProblemaRepository repository) {this.repository = repository;}

    public Problema notificar(Problema problema) {
        return repository.save(problema);
    }




    public void deletar(Long id){
        Problema problema = repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));
        repository.delete(problema);
    }

    public Problema buscar(Long id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));

    }

    public List<Problema> buscarTodos(){
        return repository.findAll();
    }

    public Problema atualizar(Long id, Problema problemaAtualizado){
        Problema problema = this.buscar(id);
        problemaAtualizado.setId(problema.getId());
        return repository.save(problemaAtualizado);
    }

}
