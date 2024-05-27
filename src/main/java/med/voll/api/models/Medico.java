package med.voll.api.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.dto.PutMedicoDTO;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(MedicoDTO json){
        this.ativo = true;
        this.nome = json.nome();
        this.email = json.email();
        this.telefone = json.telefone();
        this.crm = json.crm();
        this.especialidade = json.especialidade();
        this.endereco = new Endereco(json.endereco());
    }

    public void atualizarInformacoes(PutMedicoDTO dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
