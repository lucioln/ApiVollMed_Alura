package med.voll.api.dto;

import med.voll.api.models.Especialidade;

public record MedicoDTO(String nome,
                        String email,
                        String crm,
                        Especialidade especialidade,
                        EnderecoDTO endereco) {
}
