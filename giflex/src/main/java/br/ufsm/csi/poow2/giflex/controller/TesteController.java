package br.ufsm.csi.poow2.giflex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
    @GetMapping("/teste")
    public String firstWS() {
        return "Working! 🎆 🎇 o((>ω< ))o (๑•̀ㅂ•́)و✧";
    }
}
