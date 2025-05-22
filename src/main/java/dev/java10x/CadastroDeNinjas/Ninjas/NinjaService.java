package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List Ninjas
    public List<NinjaDTO> listNinjas() {
        List<NinjaModel> ninjaModels = ninjaRepository.findAll();
        return ninjaModels.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // List Ninjas By ID
    public NinjaDTO listNinjaById(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if (ninjaModel.isPresent()) {
            NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
            ninjaUpdated.setId(id);
            NinjaModel ninjaSave = ninjaRepository.save(ninjaUpdated);
            return ninjaMapper.map(ninjaSave);
        }
            return null;
    }
}


