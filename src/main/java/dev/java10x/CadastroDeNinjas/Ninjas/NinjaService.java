package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // List Ninjas
    public List<NinjaModel> listNinjas() {
        return ninjaRepository.findAll();
    }

    // List Ninjas By ID
    public NinjaModel listNinjaById(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    // Create Ninjas
    public NinjaModel createNinja(NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }
}
