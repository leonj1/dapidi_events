package com.dapidi.events;


import com.dapidi.events.configs.AppProperties;
import com.dapidi.events.configs.FindResourceFile;
import com.dapidi.events.configs.GetProperty;
import com.dapidi.events.models.AlertSubscriber;
import com.dapidi.events.models.EventRule;
import com.dapidi.events.models.Rule;
import com.dapidi.events.models.StringEventPattern;
import com.dapidi.events.models.Subscriber;
import com.dapidi.events.services.CheckRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final String APPLICATION_PROPERTIES = "application.properties";

    public static void main( String[] args ) {
        log.info("Some succeed because they are destined to. Most succeed because they are determined to. -- Unknown");

        // Starting here, we are going the job Spring would normally do
        AppProperties appProperties = null;
        try {
            appProperties = new AppProperties(
                    new GetProperty(
                            new FindResourceFile(APPLICATION_PROPERTIES)
                    )
            );
        } catch (Exception e) {
            log.error(String.format("Really bad problem trying to find resource %s", APPLICATION_PROPERTIES));
            System.exit(1);
        }

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(
                new CheckRules(new ArrayList<Rule>() {{
                    add(new EventRule(
                            new StringEventPattern(),
                            new ArrayList<Subscriber>() {{
                                add(new AlertSubscriber());
                                add(new AlertSubscriber());
                            }}
                    ));
                    add(new EventRule(
                            new StringEventPattern(),
                            new ArrayList<Subscriber>() {{
                                add(new AlertSubscriber());
                                add(new AlertSubscriber());
                            }}
                    ));
                }}),
                0,
                1,
                TimeUnit.MINUTES
        );

    }
}
