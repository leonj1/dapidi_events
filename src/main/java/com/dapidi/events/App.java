package com.dapidi.events;


import com.dapidi.events.configs.AppProperties;
import com.dapidi.events.configs.FindResourceFile;
import com.dapidi.events.configs.GetProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    }
}
