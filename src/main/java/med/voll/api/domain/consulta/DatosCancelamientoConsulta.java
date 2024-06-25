package med.voll.api.domain.consulta;

public class DatosCancelamientoConsulta {

    private Long idConsulta;
    private MotivoCancelamiento motivo;

    public DatosCancelamientoConsulta(Long idConsulta, MotivoCancelamiento motivo) {
        this.idConsulta = idConsulta;
        this.motivo = motivo;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public MotivoCancelamiento getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoCancelamiento motivo) {
        this.motivo = motivo;
    }
}
