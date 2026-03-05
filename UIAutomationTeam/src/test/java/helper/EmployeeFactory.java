package helper;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import apps.orangeHRM.flows.models.Employee;

public class EmployeeFactory {

    private static final String DEFAULT_PASSWORD = "QAAutomation@01";
    private static final String LAST_NAME = "Automacao";

    private static final String[] FIRST_NAMES = {
        "Lucas", "Carlos", "Ana", "Maria", "Joao",
        "Pedro", "Julia", "Fernanda", "Bruno", "Ricardo",
        "Patricia", "Rafael", "Camila", "Daniel", "Gabriel",
        "Mariana", "Thiago", "Renata", "Eduardo", "Larissa"
    };

    private static final String[] MIDDLE_NAMES = {
        "Silva", "Santos", "Oliveira", "Souza", "Costa",
        "Pereira", "Rodrigues", "Almeida", "Nascimento",
        "Lima", "Araujo", "Fernandes", "Carvalho",
        "Gomes", "Martins", "Rocha", "Dias",
        "Teixeira", "Barbosa", "Freitas"
    };

    private static final Random random = new Random();

    public static Employee createRandomEmployee() {
        String firstName = getRandom(FIRST_NAMES);
        String middleName = getRandom(MIDDLE_NAMES);
        String uniqueId = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
        String username = (firstName + "." + middleName +"." + LAST_NAME + "." + uniqueId).toLowerCase();
        return new Employee(
            uniqueId,
            null,
            firstName,
            middleName,
            LAST_NAME,
            username,
            DEFAULT_PASSWORD
        );
    }

    private static String getRandom(String[] values) {
        return values[random.nextInt(values.length)];
    }
}