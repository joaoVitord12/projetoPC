package com.projetoPC.dev.spec;

import com.projetoPC.dev.repositories.ComponentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentesSpec {

    @Autowired ComponentesRepository componentesRepository;

}
