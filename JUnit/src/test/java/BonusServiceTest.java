import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {


    @Test
    public void bonusDeveSerZeroParaSalarioAlto(){
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), BigDecimal.valueOf(25000.00));
        Assertions.assertEquals(new BigDecimal("0.00"),bonusService.calcularBonus(funcionario) );
    }




    @Test
    public void bonusDeveSerDe10Porcento(){
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), BigDecimal.valueOf(6000.00));
        Assertions.assertEquals(new BigDecimal("600.00"),bonusService.calcularBonus(funcionario) );
    }

    @Test
    public void bonusDeveSerDe10PorcentoMax(){
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Pedro", LocalDate.now(), BigDecimal.valueOf(10000.00));
        Assertions.assertEquals(new BigDecimal("1000.00"),bonusService.calcularBonus(funcionario) );
    }
}
