package med.voll.api.domain.consulta.desafio;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import med.voll.api.domain.consulta.MotivoCancelamiento;

public interface ValidadorCancelamientoDeConsulta {

    void validar(DatosCancelamientoConsulta datos);

    boolean podeCancelar(Consulta consulta);

    String motivoCancelamentoInvalido(Consulta consulta);

    // New method to validate cancellation reason
    boolean validarMotivoCancelamento(MotivoCancelamiento motivo);
}