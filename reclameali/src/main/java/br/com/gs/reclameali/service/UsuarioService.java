package br.com.gs.reclameali.service;

import br.com.gs.reclameali.model.Usuario;
import br.com.gs.reclameali.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository repository;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    public void deletar(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));
        repository.delete(usuario);
    }

    public Usuario procurar(Long id){
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));
    }

    public List<Usuario> procurarTodos(){
        return repository.findAll();
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado){
        Usuario usuario = this.procurar(id);
        usuarioAtualizado.setId(usuario.getId());
        return repository.save(usuarioAtualizado);
    }

    public Usuario procurarPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User Not Found!"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User " +
                "Not Found with email: " + username));
        return new User(user.getUsername(), user.getPassword(), true, true,
                true, true, user.getAuthorities());
    }



}
