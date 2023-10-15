package br.com.digitalhouse.clinica;

import br.com.digitalhouse.produto.api.dto.request.ClinicaRequest;
import com.github.javafaker.Faker;
import java.util.Locale;

public class Fixture {

    private static final Faker FAKER = new Faker(new Locale("pt", "BR"));

    public static class GameFake {
        public static ClinicaRequest anyGame() {
            ClinicaRequest clinicaRequest = new ClinicaRequest();
            clinicaRequest.setNome(FAKER.company().name());
            clinicaRequest.setCnpj("63.647.124/0001-83");
            clinicaRequest.setRazao_social(FAKER.company().name());
            clinicaRequest.setDescricao(FAKER.lorem().sentence());
            return clinicaRequest;
        }
    }
}
