package Proceso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Objetos.Carrera;
import Objetos.Horario;
import Objetos.RegistroAcademico;

public class SergioFernandoOtzoyGonzalez {
    @InjectMocks
    private AsignarHorario asignarHorario;
    @Mock
    private Carrera carrera;
    @Mock
    private RegistroAcademico registroAcademico;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkCodigoHorario() {
        // Carné 201602782
        when(registroAcademico.getAnio()).thenReturn(2016);
        when(registroAcademico.cheequearCarnet()).thenReturn(true);
        try {
            // Carrera 9 (sistemas) => 3
            when(carrera.procesarCarrera()).thenReturn(3);
            Horario horario = asignarHorario.generarHorario(carrera, registroAcademico);
            // 6 + 3 = 9 => 369
            assertEquals(369, horario.getCodigoHorario());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkDescription() {
        // Carné 201602782
        when(registroAcademico.getAnio()).thenReturn(2016);
        when(registroAcademico.cheequearCarnet()).thenReturn(true);
        try {
            // Carrera 9 (sistemas) => 3
            when(carrera.procesarCarrera()).thenReturn(3);
            Horario horario = asignarHorario.generarHorario(carrera, registroAcademico);
            // 3 => Matutino
            assertEquals("Matutino", horario.getDescripcion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
