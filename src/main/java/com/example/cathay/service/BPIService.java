package com.example.cathay.service;

import com.example.cathay.model.BPIDto;
import com.example.cathay.model.Result;

public interface BPIService {

    Result insertBPI(BPIDto entity);

    Result updateBPI(BPIDto entity);

    Result deleteBPI(BPIDto entity);

    Result showBPI();
}
