package example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivanna
 */
import com.lamark.kantoonewsite.entity.Job;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.ArrayList;
import java.util.List;

public class Hello implements RequestHandler<Job, List<Job>> {

    @Override
    public List<Job> handleRequest(Job i, Context cntxt) {
        List<Job> x = new ArrayList<>();
        x.add(new Job(i.getId(), "Ivana" + i.getId(), "Ivana" + i.getId()));
        x.add(new Job(i.getId(), "Ivana" + i.getId() + 1, "Ivana" + i.getId() + 1));
        x.add(new Job(i.getId(), "Ivana" + i.getId() + 2, "Ivana" + i.getId() + 2));
        return x;
    }

}