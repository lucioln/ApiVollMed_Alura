package med.voll.api.dto;

import med.voll.api.models.Especialidade;

public record GetMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade

) {
}
