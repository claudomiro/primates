package com.claudomiro.genome;

import com.claudomiro.genome.dto.SimianRequestDTO;
import com.claudomiro.genome.dto.SimianResponseDTO;
import com.claudomiro.genome.service.GenomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class GenomeApplication {

	private static Logger log = LoggerFactory.getLogger(GenomeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GenomeApplication.class, args);
	}

	@Autowired
	private GenomeService service;

	@PostMapping("/simian")
	public SimianResponseDTO isSimian(@RequestBody SimianRequestDTO request) {
		log.info("POST Method called: request="+request);
		return service.isSimiam(request);
	}

}
