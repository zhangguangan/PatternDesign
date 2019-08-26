package com.patternDesign.treeTest;

import java.util.ArrayList;
import java.util.List;

public class OrgModel {
    private String code;
    private String name;
    private String parentCode;
    private List orgModels;
    private int groupPersonNumber;

    public int getGroupPersonNumber() {
        return groupPersonNumber;
    }

    public void setGroupPersonNumber(int groupPersonNumber) {
        this.groupPersonNumber = groupPersonNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<OrgModel> getOrgModels() {
        return orgModels;
    }

    public void setOrgModels(List orgModels) {
        this.orgModels = orgModels;
    }

    public void addChild(OrgModel orgModel) {
        if (getOrgModels() == null) {
            orgModels = new ArrayList();
        }
        orgModels.add(orgModel);
    }
}
