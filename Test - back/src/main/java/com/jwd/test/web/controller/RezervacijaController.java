package com.jwd.test.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.test.model.Linija;
import com.jwd.test.model.Rezervacija;
import com.jwd.test.service.RezervacijaService;
import com.jwd.test.support.RezervacijaDtoToRezervacija;
import com.jwd.test.support.RezervacijaToRezervacijDto;
import com.jwd.test.web.dto.LinijaDTO;
import com.jwd.test.web.dto.RezervacijaDTO;

@RestController
@RequestMapping(value = "/api/rezervacije" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class RezervacijaController {
	
	@Autowired
	RezervacijaService rezervacijaService;
	@Autowired
	RezervacijaDtoToRezervacija toRezervacija;
	@Autowired
	RezervacijaToRezervacijDto toRezervacijDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> create( @Valid @RequestBody RezervacijaDTO rezervacijaDTO){
		
		Rezervacija rez=toRezervacija.convert(rezervacijaDTO);
		Rezervacija sacuvani =rezervacijaService.save(rez);
		
	return new ResponseEntity<RezervacijaDTO>(toRezervacijDto.convert(sacuvani),HttpStatus.OK);
		
	}

}
