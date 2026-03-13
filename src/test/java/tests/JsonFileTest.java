package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.model.Car;
import tests.model.Cars;

import java.io.InputStreamReader;
import java.io.Reader;

public class JsonFileTest {

    private ClassLoader cl = JsonFileTest.class.getClassLoader();
    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    void jsonFileTest() throws Exception{
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("cars.json")
        )) {
            Cars actual = mapper.readValue(reader, Cars.class);

            Car car = actual.getCars().get(5);

            Assertions.assertEquals("Mercedes", car.getBrand());
            Assertions.assertEquals("C-Class", car.getModel());
            Assertions.assertEquals(2020, car.getYear());
            Assertions.assertEquals(48000, car.getPrice());
        }
    }




    }

