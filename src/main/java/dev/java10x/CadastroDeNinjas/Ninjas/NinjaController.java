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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.createNinja(ninjaDTO);
    }

    @GetMapping("/list")
    public List<NinjaDTO> listNinjas() {
        return ninjaService.listNinjas();
    }

    @GetMapping("/list-by-id/{id}")
    public NinjaDTO listNinjaById(@PathVariable Long id) {
        return ninjaService.listNinjaById(id);
    }

    @PutMapping("/update/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.updateNinja(id, ninjaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }

}
