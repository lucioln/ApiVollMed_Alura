package med.voll.api.dto;

public record GetPacienteDTO(
        String nome,
        String email,
        String cpf
) {
}
