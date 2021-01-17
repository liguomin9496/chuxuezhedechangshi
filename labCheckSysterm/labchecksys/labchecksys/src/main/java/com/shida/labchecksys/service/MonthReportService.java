package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MonthReportService {

    public JsonResponse showAllByPermission(User user);

    public void extract();

    public JsonResponse suggestion(String suggestion, User user, int id);

    public JsonResponse isExamine(User user, int id);

    public JsonResponse isSubmit(User user,int id,String labName);

    public JsonResponse submitAll(User user);
}
