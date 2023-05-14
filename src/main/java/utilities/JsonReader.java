package utilities;

import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.IOException;

public class JsonReader {


    public static String getTestData(){
        String filePath = "./src/main/resources/TestData.json";
        File file = new File(filePath);
        String json = null;
        try {
            json = JsonPath.parse(file).jsonString();
        } catch ( IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return json;
    }

}
