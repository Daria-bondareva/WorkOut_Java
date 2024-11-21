package com.WorkOut.Catalog.workOut;

import com.WorkOut.Catalog.workOut.dto.WorkOutRequest;
import com.WorkOut.Catalog.workOut.dto.WorkOutResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkOutService {
    private final WorkRepository workRepository;
    public void createWorkOut(WorkOutRequest workOutRequest){
        WorkOut workOut = WorkOut.builder()
                .description(workOutRequest.description())
                .trainingDuration(workOutRequest.trainingDuration())
                .price(workOutRequest.price())
                .build();
        workRepository.save(workOut);
        log.info("Work Out with id {} is saved", workOut.getId());
    }

    public WorkOut getWorkOutById(String id){
        Optional<WorkOut> optionalWorkOut = workRepository.findById(id);

        if(optionalWorkOut.isPresent()){
            return optionalWorkOut.get();
        }else {
            log.warn("Work Out {} not found", id);
            throw new RuntimeException("Sorry, but work Out " + id + " not found :(");
        }
    }

    public List<WorkOutResponse> getAll(){
        List<WorkOut> workOuts = workRepository.findAll();
        return workOuts.stream().map(this::mapToWorkOutResponse).toList();
    }

    private WorkOutResponse mapToWorkOutResponse(WorkOut workOut){
        return new WorkOutResponse(workOut.getId(), workOut.getDescription(), workOut.getTrainingDuration(), workOut.getPrice());
    }
}
