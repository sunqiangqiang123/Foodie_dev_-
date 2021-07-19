import java.io.File;
import java.io.IOException;


public class Test {

    public static void main(String[] args) {
        File configFile = new File("fodie-mybatis-generator/generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());
        try {
            System.out.println(configFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
