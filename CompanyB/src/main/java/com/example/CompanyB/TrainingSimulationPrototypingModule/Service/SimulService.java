package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulService {
    @Autowired
    private SimulationRepository simRepo;

    public String createSim(SimTestTO simTestTO) {
        try {
            SimTest sim = SimTest.builder()
                    .testID(simTestTO.getTestID())
                    .simulApproval(simTestTO.isSimulApproval())
                    .simulComments(simTestTO.getSimulComments())
                    .circuitSimulStatus(simTestTO.isCircuitSimulStatus())
                    .thermalSimulStatus(simTestTO.isThermalSimulStatus())
                    .manufacturabilityStatus(simTestTO.isManufacturabilityStatus()).build();
            simRepo.save(sim);
        } catch (Exception e) {
            //Write Exception
        }
        return "New Simulation added successfully.";
    }

    /* Create new simulation in the database*/
    public List<SimTest> getAllSims() {
        List<SimTest> simList = new ArrayList<>();
        try {
            simList = simRepo.findAll();
        } catch (Exception e) {
            //Write your exception
        }
        return simList;
    }
    /* Get all simulations as a list */

    public String deleteSimulation(@RequestParam String id) {
        try {
            simRepo.deleteById(id);
        } catch (Exception e) {
            //Write your exception
        }
        return "Simulation deleted successfully";
    }/* Delete a simulation */

    public String updateSim(SimTestTO sim) {
        try {
            SimTest simulation = SimTest.builder()
                    .testID(sim.getTestID())
                    .simulApproval(sim.isSimulApproval())
                    .simulComments(sim.getSimulComments())
                    .circuitSimulStatus(sim.isCircuitSimulStatus())
                    .thermalSimulStatus(sim.isThermalSimulStatus())
                    .manufacturabilityStatus(sim.isManufacturabilityStatus())
                    .build();
            simRepo.save(simulation);
        }
        catch(Exception e){
            //
        }
        return "Simulation updated successfully ";
    }/* Update simulation */
}