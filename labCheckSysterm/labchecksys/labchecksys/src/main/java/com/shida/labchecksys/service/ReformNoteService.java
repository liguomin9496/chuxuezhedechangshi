package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.ReformNote;
import com.shida.labchecksys.pojo.SpotCheck;

import com.shida.labchecksys.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface ReformNoteService {
    JsonResponse addReformNote(User user, SpotCheck spotCheck);

    JsonResponse showAll();

    JsonResponse findLabReformNoteByCheckId(long checkId);

    JsonResponse deleteLabReformNoteByCheckId(long checkId);

    JsonResponse findById(long checkId);
}
