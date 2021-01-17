package com.shida.labchecksys.service.Impl;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.LabMapper;
import com.shida.labchecksys.mapper.LabRelationMapper;
import com.shida.labchecksys.pojo.Lab;
import com.shida.labchecksys.service.LabService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LabServiceImpl implements LabService {
    @Resource
    private LabMapper labMapper;


    //新增实验室
    @Override
    public JsonResponse addLab(Lab lab) {
        if (labMapper.getByLabId(lab.getLabId()).size() != 0) {
            return JsonResponse.toFailed("失败");
        } else {
            Lab insert = new Lab(lab.getLabId(), lab.getLabName(), lab.getLabDepartment(), lab.getLabSaferId(), lab.getLabUserId(), lab.getLabArea());
            labMapper.add(insert);
            return JsonResponse.toSuccess("新增实验室成功");
        }
    }

    //根据id删除实验室
    @Override
    public JsonResponse deleteLab(long labId) {
        labMapper.delete(labId);
        if (labMapper.getByLabId(labId).size() == 0) {
            return JsonResponse.toSuccess("删除实验室成功");
        }
        return JsonResponse.toFailed("删除实验室失败");
    }

    @Override
    public JsonResponse updateLab(Lab lab) {
        Lab update = new Lab(lab.getLabId(), lab.getLabName(), lab.getLabDepartment(), lab.getLabSaferId(), lab.getLabUserId(), lab.getLabArea());
        labMapper.update(update);
        return JsonResponse.toSuccess("成功更新实验室信息");
    }

    @Override
    public JsonResponse selectLab(long labId) {
        return JsonResponse.toSuccess(labMapper.getByLabId(labId), "查找实验室成功");
    }

    @Override
    public String findLabNameByLabSaferId(long labSaferId) {
        return labMapper.findLabNameByLabSaferId(labSaferId);
    }


    @Override
    public long findLabSaferIdByLabName(String labName) {
        return labMapper.findLabSaferIdByLabName(labName);
    }

    @Resource
    private LabRelationMapper labRelationMapper;

    @Override
    public long findLeadrIdByLabName(String labName) {
        return labRelationMapper.findLeaderId(labMapper.findLabIdByLabName(labName));
    }

    @Override
    public long findSysIdByLabName(String labName) {
        return labRelationMapper.findSysId(labMapper.findLabIdByLabName(labName));
    }

    //2021/1/6修改
    //查找实验室的使用人员id
    @Override
    public List<Long> findLabUserIdByLabName(String labName) {
        List<Long> a=new ArrayList<>();
        String labUser=labMapper.findLabUserIdByLabName(labName);
        Long i;
        for(String userId:labUser.split(" ")){
            i=Long.parseLong(userId);
            a.add(i);
        }
        return a;
    }

    //申请实验室
    @Override
    public JsonResponse labApply(long labSaferId, String labUserId,long labId) {
        String result=labMapper.findLabSaferIdByLabId(labId);
        if(result==null){
            labMapper.updateByLabId(labSaferId,labUserId,labId);
            return JsonResponse.toSuccess("实验室申请成功");
        }else
            return JsonResponse.toSuccess("实验室申请失败");

    }

    @Override
    public boolean examineLabUser(String labName, long userId) {
        List<Long> a=new ArrayList<>();
        String labUser=labMapper.findLabUserIdByLabName(labName);
        Long i;
        for(String id:labUser.split(" ")){
            i=Long.parseLong(id);
            if(i==userId){
                return true;
            }
        }
        return false;

    }
}
