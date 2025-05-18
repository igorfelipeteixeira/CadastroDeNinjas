package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Meu primeiro programa no SpringBoot";
    }

    @PostMapping("/create")
    public String createNinja() {
        return "Ninja criado";
    }

    @GetMapping("/all")
    public List<NinjaModel> showNinjas() {
        return ninjaService.showNinjas();
    }

    @GetMapping("/ninja/{id}")
    public NinjaModel showNinjaById(@PathVariable Long id) {
        return ninjaService.showNinjaById(id);
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
