package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.SpotCheckMapper;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.service.LabService;
import com.shida.labchecksys.service.SpotCheckService;
import com.shida.labchecksys.service.UserMessageService;
import com.shida.labchecksys.util.CurrentTime;
import com.shida.labchecksys.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SpotCheckServiceImpl implements SpotCheckService {

   @Autowired
   SpotCheckMapper spotCheckMapper;

   @Autowired
   LabService labService;

   @Autowired
   UserMessageService userMessageService;

    //实验室抽查
    @Override
    public JsonResponse addSpotCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type) {
        spotCheckMapper.addSpotCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
        return JsonResponse.toSuccess("实验室抽查填报成功");
    }

    //实验室专项检查
    @Override
    public JsonResponse addSpecialCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type) {
        spotCheckMapper.addSpotCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
        return JsonResponse.toSuccess("实验室专项检查填报成功");
    }

    @Override
    public JsonResponse addDepartmentCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type) {
        spotCheckMapper.addSpotCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
        return JsonResponse.toSuccess("单位检查填报成功");
    }

    @Override
    public SpotCheck findByCheckId(long checkId) {
        return spotCheckMapper.findById(checkId);
    }


}
