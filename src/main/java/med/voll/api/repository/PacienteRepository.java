package med.voll.api.repository;

import aj.org.objectweb.asm.commons.Remapper;
import med.voll.api.models.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    Page<Paciente> findALlByAtivoTrue(Pageable paginacao);

}
