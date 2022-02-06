package br.ufsm.csi.poow2.giflex.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TesteController {
    @GetMapping("/teste")
    public String firstWS() {
        return "Working! o((>ω< ))o (๑•̀ㅂ•́)و✧";
    }
}
