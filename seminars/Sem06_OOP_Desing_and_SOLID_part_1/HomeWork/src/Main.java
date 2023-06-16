import Application.Model.Entities.Generators.SimpleIdGenerator;
import Application.Model.Generator;

public class Main {
    public static void main(String[] args) {

        // ### GENERATOR & ID_GENERATOR ###
        generatorTest(false);


    }

    private static void generatorTest(boolean output) {
        Generator<Long> generator = new SimpleIdGenerator();
        System.out.println(generator.generate());
        System.out.println(generator.generate());
        System.out.println(generator.generate());
        System.out.println(generator.generate());
    }
}