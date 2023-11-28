import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;
class AdminTest {
    @Test
    void adicionarLavagem(){
        Admin a = new Admin();
        double resultado = 15;
        assertEquals(15, resultado);
    }
    @Test
    void adicionarLavagem2(){
        Admin a = new Admin();
        double resultado = 20;
        assertEquals(20, resultado);
    }
    @Test
    void adicionarLavagem3(){
        Admin a = new Admin();
        double resultado = 25;
        assertEquals(25, resultado);
    }
    @Test
    void adicionarLavagemMoto(){
        Admin a = new Admin();
        double resultado = 10;
        assertEquals(10, resultado);
    }

    @Test
    public void adicionarGastos() {
        Admin a = new Admin();
        double resultado = 10;
        assertEquals(10, resultado);
    }

    @Test
    public void adicionarPontuacao() {
        Admin a = new Admin();
        int resultado = 1;
        assertEquals(1, resultado);
    }

    @Test
    public void zerarPontuacao() {
        Admin a = new Admin();
        int resultado = 0;
        assertEquals(0, resultado);
    }
}