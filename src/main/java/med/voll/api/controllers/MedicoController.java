package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.GetMedicoDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.dto.PutMedicoDTO;
import med.voll.api.models.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO json){
        repository.save(new Medico(json));
    }

    @GetMapping
    public Page<GetMedicoDTO> getMedicos(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map( m -> new GetMedicoDTO(m.getId(), m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade()));
    }

    @PutMapping
    @Transactional
    public void updateMedico(@RequestBody @Valid PutMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
