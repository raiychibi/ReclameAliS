package br.com.gs.reclameali.controller;


import br.com.gs.reclameali.dto.ProcurarPorEmailDto;
import br.com.gs.reclameali.dto.RegistroEmailDto;
import br.com.gs.reclameali.dto.UsuarioDto;
import br.com.gs.reclameali.mapper.UsuarioMapper;
import br.com.gs.reclameali.model.Usuario;
import br.com.gs.reclameali.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){this.usuarioService = usuarioService;}

    @PostMapping
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioDto response){
        try{
            usuarioService.registrar(UsuarioMapper.dtoParaUsuario(response));
            return new ResponseEntity<UsuarioDto>(response, HttpStatus.CREATED);

        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UsuarioDto> deletarUsuario(@PathVariable(value = "id") Long id){
        try{
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDto> procurarUsuario(@PathVariable(value = "id") Long id){
        try{
            Usuario usuario = usuarioService.procurar(id);
            return ResponseEntity.ok(UsuarioMapper.usuarioParaDto(usuario));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ProcurarPorEmailDto> procurarPorEmailUsuario(@PathVariable (value = "email") String email){
        try {
            Usuario usuario = usuarioService.procurarPorEmail(email);
            return ResponseEntity.ok(UsuarioMapper.usuarioParaUsuarioEmail(usuario));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable(value = "id") Long id,
                                                       @RequestBody UsuarioDto usuarioDto){
        try {
            Usuario usuario = usuarioService.atualizar(id, UsuarioMapper.dtoParaUsuario(usuarioDto));
            return ResponseEntity.ok(UsuarioMapper.usuarioParaDto(usuario));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
