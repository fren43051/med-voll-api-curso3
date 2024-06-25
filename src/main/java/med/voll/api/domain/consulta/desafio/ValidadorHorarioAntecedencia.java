package med.voll.api.domain.consulta.desafio;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import med.voll.api.domain.consulta.MotivoCancelamiento;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamiento")
public class ValidadorHorarioAntecedencia  implements ValidadorCancelamientoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelamientoConsulta datos){
        var consulta = repository.getReferenceById(datos.getIdConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora,consulta.getFecha()).toHours();

        if(diferenciaEnHoras <24){
            throw new ValidacionDeIntegridad("la consulta no puede ser cancelada con menos de 24 horas de antecedencia");
        }
    }
    @Override
    public boolean podeCancelar(Consulta consulta) {
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();
        return diferenciaEnHoras >= 24;
    }

    @Override
    public String motivoCancelamentoInvalido(Consulta consulta) {
        return "La consulta no puede ser cancelada porque está programada para menos de 24 horas en el futuro.";
    }

    @Override
    public boolean validarMotivoCancelamento(MotivoCancelamiento motivo) {
        return motivo != null;
    }
}
