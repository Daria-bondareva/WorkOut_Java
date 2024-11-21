package com.WorkOut.Catalog.workOut;

import com.WorkOut.Catalog.workOut.dto.WorkOutRequest;
import com.WorkOut.Catalog.workOut.dto.WorkOutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class WorkOutController {
    private final WorkOutService workOutService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkOut(@RequestBody WorkOutRequest workOutRequest){
        workOutService.createWorkOut(workOutRequest);
    }

    @GetMapping("/{id}")
    public WorkOut getWorkOutById(@PathVariable("id") String id){
        return workOutService.getWorkOutById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkOutResponse> getAllWorkOut(){
        return workOutService.getAll();
    }
}
