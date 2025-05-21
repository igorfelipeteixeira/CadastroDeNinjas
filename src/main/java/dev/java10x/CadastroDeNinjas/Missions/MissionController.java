package dev.java10x.CadastroDeNinjas.Missions;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }


    @PostMapping("/create")
    public MissionModel createMission(@RequestBody MissionModel missionModel) {
        return missionService.createMission(missionModel);
    }

    @GetMapping("/list")
    public List<MissionModel> listMissions() {
        return missionService.listMissions();
    }

    @GetMapping("/list-by-id/{id}")
    public MissionModel listMissionById(@PathVariable Long id) {
        return missionService.listMissionsById(id);
    }

    @PutMapping("/update--by-id")
    public String updateMissionById() {
        return "Mission updated";
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
    }


}
