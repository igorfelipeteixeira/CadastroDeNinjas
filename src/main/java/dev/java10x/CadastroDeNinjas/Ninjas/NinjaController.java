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

    @GetMapping("/welcome")
    public String welcome() {
        return "Meu primeiro programa no SpringBoot";
    }

    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.createNinja(ninjaModel);
    }

    @GetMapping("/list-ninjas")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    @GetMapping("/list-ninjas-by-id/{id}")
    public NinjaModel listNinjaById(@PathVariable Long id) {
        return ninjaService.listNinjaById(id);
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
