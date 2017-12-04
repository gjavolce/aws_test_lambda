/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class JsonSimpleReadExampleGetJobByTitelName {

    public String myHandler(String jobName, Context context) {

        LambdaLogger logger = context.getLogger();
        StringBuilder result = new StringBuilder("");
        result.append("Input Parameter " + jobName + " is ");

        if (getJobByName(jobName) != null) {
            result.append("Find job");
        } else {
            result.append("not fined job");
        }
        logger.log(result.toString());
        return result.toString();
    }

//    public static void main(String[] args) {
    public String getJobByName(String jobName) {
        JSONParser parser = new JSONParser();
        String name = "";
        try {

            //TODO: file in project
            Object obj = parser.parse(new FileReader("D://test2.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            name = (String) jsonObject.get(jobName);
            System.out.println(jobName + name);
//            String jobDescription = (String) jsonObject.get("jobName2");
//            System.out.println("jobName2" + jobDescription);
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("getAllJobTitels");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return name;

    }

}
