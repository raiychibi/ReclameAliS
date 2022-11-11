package br.com.gs.reclameali.mapper;

import br.com.gs.reclameali.dto.ProblemaDto;
import br.com.gs.reclameali.dto.ProblemaUsuariosDto;
import br.com.gs.reclameali.model.Problema;
import org.springframework.beans.factory.parsing.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemaMapper {

    public static Problema dtoParaProblema(ProblemaDto dto){
        return new Problema(null, dto.getName(), dto.getProblem(), dto.getType(),
                null, null, null);
    }

    public static ProblemaDto problemaParaDto (Problema problema){
        return new ProblemaDto(problema.getName(), problema.getProblem(), problema.getType());
    }

    public static List<ProblemaUsuariosDto> listProblemaParaProblemaDto (List<Problema> listProblema){
        List<ProblemaUsuariosDto> problemas = new ArrayList<>();
        listProblema.forEach(problema -> problemas.add(new ProblemaUsuariosDto(problema.getName(), problema.getProblem(),
                problema.getType(), UsuarioMapper.listaUsuarioParaUsuarioDto(problema.getUsuarios()))));
        return problemas;
    }

}
