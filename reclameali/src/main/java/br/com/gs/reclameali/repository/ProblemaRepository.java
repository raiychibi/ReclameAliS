package br.com.gs.reclameali.repository;

import br.com.gs.reclameali.model.Problema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Long> {
}
