package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface SpotCheckService {
    //实验室抽查
    JsonResponse addSpotCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type);

    //实验室专项检查
    JsonResponse addSpecialCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type);

    //单位检查
    JsonResponse addDepartmentCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, String reformPrincipal, String reformMeasure, Date reformTime, int isDanger, int type);


    SpotCheck findByCheckId(long checkId);
}
