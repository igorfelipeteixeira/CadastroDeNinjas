package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Meu primeiro programa no SpringBoot";
    }

    @PostMapping("/create")
    public String createNinja() {
        return "Ninja criado";
    }

    @GetMapping("/all")
    public String showNinjas() {
        return "Mostrar Ninjas";
    }

    @GetMapping("/ninjaID")
    public String showNinjaById() {
        return "Mostrar Ninja por ID";
    }

    @PutMapping("/updateID")
    public String updateNinjaById() {
        return "Mostrar Ninja por ID";
    }

    @DeleteMapping("/deleteID")
    public String deleteNinjaById() {
        return "Ninja deletado por ID";
    }

}
