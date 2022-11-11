package br.com.gs.reclameali.mapper;

import br.com.gs.reclameali.dto.ProcurarPorEmailDto;
import br.com.gs.reclameali.dto.UsuarioDto;
import br.com.gs.reclameali.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static Usuario dtoParaUsuario(UsuarioDto dto){
        return new Usuario(null, dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword(),
                dto.getBirth(), null, null, null, dto.getEnderecos());
    }
    public static ProcurarPorEmailDto usuarioParaUsuarioEmail(Usuario usuario){
        return new ProcurarPorEmailDto(usuario.getId(), usuario.getName(), usuario.getSurname(),
                usuario.getEmail(), usuario.getPassword(), usuario.getBirth(), usuario.getCreate(),
                usuario.getChange(), usuario.getProblemas());
    }

    public static UsuarioDto usuarioParaDto (Usuario usuario){
        return new UsuarioDto(usuario.getName(), usuario.getSurname(), usuario.getEmail(), usuario.getPassword(),
                usuario.getBirth(), usuario.getEnderecos());
    }


    public static List<UsuarioDto> listaUsuarioParaUsuarioDto (List<Usuario> listUsuario){
        List<UsuarioDto> usuarios = new ArrayList<>();
        listUsuario.forEach(usuario -> usuarios.add(new UsuarioDto(usuario.getName(), usuario.getSurname(),
                usuario.getEmail(), usuario.getPassword(), usuario.getBirth(), usuario.getEnderecos())));
        return usuarios;
    }

}
