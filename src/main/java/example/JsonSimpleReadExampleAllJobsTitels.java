/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Iterator;

public class JsonSimpleReadExampleAllJobsTitels {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("D://test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

//            String name = (String) jsonObject.get("jobName");
//            System.out.println(name);
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("getAllJobTitels");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
