package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sesion2b.Empleado;

class EmpleadoTest {
	
	private Empleado empleado;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		empleado = new Empleado();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Test calculoNominaBruta 

    @Test
    public void testCalculoNominaBruta_VentasJustoBajo1000() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 999.99f, 0f);
        assertEquals(2000.0f, resultado);
    }

    @Test
    public void testCalculoNominaBruta_VentasEn1000() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1000.00f, 0f);
        assertEquals(2100.0f, resultado);
    }

    @Test
    public void testCalculoNominaBruta_VentasJustoBajo1500() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1499.99f, 0f);
        assertEquals(2100.0f, resultado);
    }

    @Test
    public void testCalculoNominaBruta_VentasEn1500() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, 1500.00f, 0f);
        assertEquals(2200.0f, resultado);
    }

    @Test
    public void testCalculoNominaBruta_EncargadoSinVentas() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 0.00f, 0f);
        assertEquals(2500.0f, resultado);
    }

    @Test
    public void testCalculoNominaBruta_ConHorasExtra() {
        float resultado = empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1000.00f, 1.0f);
        assertEquals(2630.0f, resultado);
    }

    // Test calculoNominaNeta

    @Test
    public void testCalculoNominaNeta_Limite2100Exacto() {
        float resultado = empleado.calculoNominaNeta(2100.00f);
        assertEquals(2100.00f, resultado);
    }

    @Test
    public void testCalculoNominaNeta_Limite2100PorEncima() {
        float resultado = empleado.calculoNominaNeta(2100.01f);
        assertEquals(1785.0085f, resultado);
    }

    @Test
    public void testCalculoNominaNeta_Limite2500PorDebajo() {
        float resultado = empleado.calculoNominaNeta(2499.99f);
        assertEquals(2124.9915f, resultado);
    }

    @Test
    public void testCalculoNominaNeta_Limite2500Exacto() {
        float resultado = empleado.calculoNominaNeta(2500.00f);
        assertEquals(2500.00f, resultado);
    }

    @Test
    public void testCalculoNominaNeta_Limite2500PorEncima() {
        float resultado = empleado.calculoNominaNeta(2500.01f);
        assertEquals(2050.0082f, resultado);
    }

}
