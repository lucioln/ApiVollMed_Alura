package med.voll.api.controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.GetPacienteDTO;
import med.voll.api.dto.PacienteDTO;
import med.voll.api.dto.PutPacienteDTO;
import med.voll.api.models.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private  PacienteRepository repository;

    @GetMapping
    public Page<GetPacienteDTO> listAll(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        return repository.findALlByAtivoTrue(paginacao)
                .map( p -> new GetPacienteDTO(p.getNome(), p.getEmail(), p.getCpf()));
    }

    @PostMapping @Transactional
    public void createPaciente(@RequestBody @Valid PacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @PutMapping
    @Transactional
    public void updatePaciente(@RequestBody @Valid PutPacienteDTO dados){
        var paciente  = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void inativaPaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.setInativo();
    }

}
