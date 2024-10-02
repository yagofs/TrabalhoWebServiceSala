package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRep;

    public List<Disciplina> findAll() {
        return disciplinaRep.findAll();
    }

    public Disciplina findById(Integer id) {
        return disciplinaRep.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada")
        );
    }

    public Disciplina insert(Disciplina disciplina) {
        return disciplinaRep.save(disciplina);
    }

    public void delete(Integer id) {
        disciplinaRep.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada")
        );
        disciplinaRep.deleteById(id);
    }

    public Disciplina update(Integer id, Disciplina disciplinaAlt) {
        return disciplinaRep.findById(id).map(
            disciplinaDB -> {
                disciplinaDB.setNomedisciplina(disciplinaAlt.getNomedisciplina());
                disciplinaDB.setCargahoraria(disciplinaAlt.getCargahoraria());
                return disciplinaRep.save(disciplinaDB);
            }
        ).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada")
        );
    }
}
