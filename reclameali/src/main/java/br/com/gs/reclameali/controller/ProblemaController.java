package br.com.gs.reclameali.controller;

import br.com.gs.reclameali.dto.ProblemaDto;
import br.com.gs.reclameali.mapper.ProblemaMapper;
import br.com.gs.reclameali.model.Problema;
import br.com.gs.reclameali.repository.ProblemaRepository;
import br.com.gs.reclameali.repository.UsuarioRepository;
import br.com.gs.reclameali.service.ProblemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/problema/")
public class ProblemaController {

    private  final ProblemaService problemaService;

    public ProblemaController(ProblemaService problemaService){this.problemaService = problemaService;}

    @PostMapping
    public ResponseEntity<ProblemaDto> notificarProblema(@RequestBody ProblemaDto response){
        try{
            problemaService.notificar(ProblemaMapper.dtoParaProblema(response));
            return new ResponseEntity<ProblemaDto>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }



    @DeleteMapping("{id}")
    public ResponseEntity<ProblemaDto> deletarProblema(@PathVariable(value = "id") Long id){
        try{
            problemaService.deletar(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ProblemaDto> buscarProblema(@PathVariable(value = "id") Long id){
        try{
            Problema problema = problemaService.buscar(id);
            return ResponseEntity.ok(ProblemaMapper.problemaParaDto(problema));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ProblemaDto> atualizarProblema(@PathVariable(value = "id") Long id,
                                                         @RequestBody ProblemaDto problemaDto){
        try {
            Problema problema = problemaService.atualizar(id, ProblemaMapper.dtoParaProblema(problemaDto));
            return ResponseEntity.ok(ProblemaMapper.problemaParaDto(problema));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
