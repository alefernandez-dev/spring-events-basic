package alejandro.dev.events;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringEventsApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(SpringEventsApplication.class)
				.run(args);
	}

}
