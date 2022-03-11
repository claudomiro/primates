package com.claudomiro.genome.rest;

import com.claudomiro.genome.dto.SimianRequestDTO;
import com.claudomiro.genome.dto.SimianResponseDTO;
import com.claudomiro.genome.service.GenomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimatesRestControler {
    private static Logger log = LoggerFactory.getLogger(PrimatesRestControler.class);

    @Autowired
    private GenomeService service;

    @PostMapping("/simian")
    public SimianResponseDTO isSimian(@RequestBody SimianRequestDTO request) {
        log.info("POST Method called: request="+request);
        return service.isSimiam(request);
    }

}
