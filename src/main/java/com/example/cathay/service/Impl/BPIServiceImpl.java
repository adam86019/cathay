package com.example.cathay.service.Impl;

import com.example.cathay.entity.BPI;
import com.example.cathay.model.BPIDto;
import com.example.cathay.model.Result;
import com.example.cathay.repository.BPIRepository;
import com.example.cathay.service.BPIService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPIServiceImpl implements BPIService {

    @Autowired
    private BPIRepository bpiRepository;

    @Override
    public Result insertBPI(BPIDto body) {
        BPI retVal = new BPI();
        Result result = new Result();
        try {
            retVal.setCode(body.getCode());
            retVal.setSymbol(body.getSymbol());
            retVal.setRate(body.getRate());
            retVal.setDescription(body.getDescription());
            retVal.setRate_float(body.getRate_float());
            bpiRepository.save(retVal);
            result.setReturnCode("00");
            result.setMessage("Success Insert");
        } catch (Exception e) {
            result.setReturnCode("99");
            result.setMessage("Failed to Insert"+e);
        }


        return result;
    }

    @Override
    public Result updateBPI(BPIDto entity) {
        Result result = new Result();
        try {
            BPI target = bpiRepository.findByCode(entity.getCode());
            if (target == null) {
                result.setReturnCode("99");
                result.setMessage("Fail to Update, Cannot be found.");
                return result;
            }
            target.setSymbol(entity.getSymbol());
            target.setRate(entity.getRate());
            target.setDescription(entity.getDescription());
            target.setRate_float(entity.getRate_float());
            target = bpiRepository.save(target);
            result.setReturnCode("00");
            result.setMessage(target.toString());
            return result;
        } catch (Exception e) {
            result.setReturnCode("99");
            result.setMessage("Fail to Update:"+e);
        }
        return result;
    }

    @Override
    public Result deleteBPI(BPIDto entity) {
        Result result = new Result();
        try {
            BPI target = bpiRepository.findByCode(entity.getCode());
            if (target == null) {
                result.setReturnCode("99");
                result.setMessage("Fail to Delete");
            }
            bpiRepository.delete(target);
            result.setReturnCode("00");
            result.setMessage("Success Delete");
            return result;
        } catch (Exception e) {
            result.setReturnCode("99");
            result.setMessage("Fail to Update:"+e);
        }
        return result;
    }

    @Override
    public Result showBPI() {
        Result result = new Result();
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://api.coindesk.com/v1/bpi/currentprice.json");
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result.setReturnCode("00");
            result.setMessage(EntityUtils.toString(entity));
        } catch (Exception e) {
            result.setReturnCode("99");
            result.setMessage("Call API Error"+e);
        }
        return result;
    }
}
