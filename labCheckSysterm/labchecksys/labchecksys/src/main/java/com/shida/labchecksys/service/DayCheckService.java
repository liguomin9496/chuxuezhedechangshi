package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public interface DayCheckService {

    JsonResponse showSelf(long checkerId);

    JsonResponse selectByCheckTime(String checkObject, Date checkTime);

    JsonResponse selectById(long id);

    JsonResponse addDayCheck(User user, long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, int isDanger);

    JsonResponse safeSave(User user,long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, int isDanger);

}
