package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaMapper().map(ninjaDTO);
        ninjaModel =  ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    // Delete Ninjas By ID
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Update Ninjas By ID
    public NinjaModel updateNinja(Long id, NinjaModel ninjaModel) {
        if (ninjaRepository.existsById(id)) {
            ninjaModel.setId(id);
            return ninjaRepository.save(ninjaModel);
        }
        return null;
    }

}


