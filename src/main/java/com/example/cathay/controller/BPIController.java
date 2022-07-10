package com.example.cathay.controller;

import com.example.cathay.model.BPIDto;
import com.example.cathay.model.Result;
import com.example.cathay.service.BPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/bpi")
public class BPIController {
    @Autowired
    private BPIService bpiService;

    @PostMapping("/create")
    public Result insertBPI(@RequestBody BPIDto input) {
        return bpiService.insertBPI(input);
    }

    @PutMapping("/update")
    public Result updateBPI(@RequestBody BPIDto input) {
        return bpiService.updateBPI(input);
    }

    @DeleteMapping("/delete")
    public Result deleteBPI(@RequestBody BPIDto input) {
        return bpiService.deleteBPI(input);
    }

    @PostMapping("/show")
    public Result showBPI() {
        return bpiService.showBPI();
    }
}
