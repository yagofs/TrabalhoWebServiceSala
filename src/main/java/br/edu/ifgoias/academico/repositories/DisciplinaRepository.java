package br.edu.ifgoias.academico.repositories;

import br.edu.ifgoias.academico.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
