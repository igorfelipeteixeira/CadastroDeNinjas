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
    public MissionModel listMissionById(Long id) {
        Optional<MissionModel> missionModel = missionRepository.findById(id);
        return missionModel.orElse(null);
    }

    // Create Missions
    public MissionModel createMission(MissionModel missionModel) {
        return missionRepository.save(missionModel);
    }

    // Delete Missions by ID
    public void deleteMission(Long id) {
        missionRepository.deleteById(id);
    }

    // Update Missions by ID
    public MissionModel updateMission(Long id, MissionModel missionModel) {
        if (missionRepository.existsById(id)) {
            missionModel.setId(id);
            return missionRepository.save(missionModel);
        }
        return null;
    }
}
