package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    // List Missions
    public List<MissionModel> listMissions() {
        return missionRepository.findAll();
    }

    // List Mission By ID
    public MissionModel listMissionsById(Long id) {
        Optional<MissionModel> missionModel = missionRepository.findById(id);
        return missionModel.orElse(null);
    }

    // Create Missions
    public MissionModel createMission(MissionModel missionModel) {
        return missionRepository.save(missionModel);
    }
}
