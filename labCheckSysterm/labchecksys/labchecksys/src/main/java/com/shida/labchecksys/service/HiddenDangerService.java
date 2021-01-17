package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;

import com.shida.labchecksys.pojo.DayCheck;
import com.shida.labchecksys.pojo.HiddenDanger;
import com.shida.labchecksys.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface HiddenDangerService {

    JsonResponse showDanger();

    String getReformPrincipal(long id);

    JsonResponse updateDayCheckByLeader(User user, long id, String reformPrincipal);

    JsonResponse updateDayCheckByPrincipal(User user, long id, String reformMeasure, Date reform_time);

    JsonResponse updateDayCheckByAccepter(User user, long id, String accepter, String accResults, Date accTime);

    JsonResponse updateDayCheckBySchool(User user, long id, String schoolResult, Date schoolTime);

    JsonResponse insert(HiddenDanger hiddenDanger);

    JsonResponse showAllHidden();

    JsonResponse showAll(long roleId, User user);

    JsonResponse update(HiddenDanger hiddenDanger);

    JsonResponse delete(int id);

    JsonResponse synchronization();

    List<HiddenDanger> showAllByDepartment(String department);

    List<HiddenDanger> showAllByTestPerson(String testPerson);

    JsonResponse examineIsFinish(int id,String testPerson);

    List<DayCheck> selectByPrincipal(String principal);
}
