package com.projetoPC.dev.controllers;

import com.projetoPC.dev.services.MontagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/montagens")
public class MontagemController {

    @Autowired MontagemService montagemService;


}
