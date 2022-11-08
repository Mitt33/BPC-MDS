package mds.streamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication
@ServletComponentScan
public class StreamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingServerApplication.class, args);
	}

}
