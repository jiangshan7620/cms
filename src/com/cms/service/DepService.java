package com.cms.service;

import com.cms.dao.DepDao;
import com.cms.po.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 21:38
 * @bz:
 */

public class DepService {
    //从数组中取值形成map
    public Map getDepMap(){
        DepDao depDao = new DepDao();
        List<Department> allDep = depDao.getAllDep();
        Map depMap = new HashMap<Integer,String>();
        for(Department department:allDep){
            depMap.put(department.getId(),department.getDepName());
        }
        return depMap;
    }

    public int findDepByName(String depname) {
        DepDao depDao = new DepDao();
        return depDao.findDepByName(depname);

    }

    public int addDep(Department dep) {
        DepDao depDao = new DepDao();
        return depDao.addDep(dep);
    }

    public int getLastId() {
        DepDao depDao = new DepDao();
        return depDao.getLastId();
    }


    public List<Department> getAllDep() {
        DepDao depDao = new DepDao();
      return   depDao.getAllDep();
    }

    public int delDepById(int did) {
        DepDao depDao = new DepDao();
       return depDao.delDepById(did);
    }

    public int modDep(int did, String depName, int dsort) {
        DepDao depDao = new DepDao();
      return depDao.modDep(did,depName,dsort);
    }

    public int insertDep(String depName, int dsort,String time) {
        DepDao depDao = new DepDao();
      return depDao.insertDep(depName,dsort,time);
    }


    public int findDepByNameAndID(String depName, int did) {
        DepDao depDao = new DepDao();
        return depDao.findDepByNameAndID(depName,did);
    }

    public int findDepBySort(int dsort) {
        DepDao depDao = new DepDao();
        return depDao.findDepBySort(dsort);
    }

    public int findDepBySortAndID(int dsort, int did) {
        DepDao depDao = new DepDao();
        return depDao.findDepBySortAndID(dsort,did);
    }

    public int modPd(int dsort, String depName) {
        DepDao depDao = new DepDao();
        return depDao.modPd(dsort,depName);
    }
}
