package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record PutMedicoDTO(
        @NotNull
        Long id,

        String nome,

        String telefone,

        @Valid
        EnderecoDTO endereco
) {
}
