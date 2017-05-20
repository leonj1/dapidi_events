package com.dapidi.events.services;

import com.dapidi.events.models.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2017
 **/
public class CheckRules implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(CheckRules.class);

    private List<Rule> rules;

    public CheckRules(List<Rule> rules) {
        this.rules = rules;
    }


    @Override
    public void run() {
//        Thread.currentThread().setName("StartJobs");
//        log.info("Starting StartJobs thread");
//        for (UUID id : this.map.keySet()) {
//            StartJob startJob = new StartJob(
//                    id,
//                    this.map.get(id),
//                    map
//            );
//            Thread t1 = new Thread(startJob, id.toString());
//            t1.start();
//        }
//        log.info("Ending StartJobs thread");
    }
}
