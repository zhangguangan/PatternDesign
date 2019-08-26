package com.patternDesign.treeTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class treeTest {

    private static int number = 0;
    public static List buildList() {
        List<OrgModel> orgs = new ArrayList();

        OrgModel rootModel = new OrgModel();
        rootModel.setCode("123400");
        rootModel.setName("root");
        rootModel.setParentCode("");

        // 父节点1
        OrgModel parentModel1 = new OrgModel();
        parentModel1.setCode("123401");
        parentModel1.setName("parentModel1");
        parentModel1.setParentCode("123400");
        // 子节点1
        OrgModel childModel1 = new OrgModel();
        childModel1.setCode("12340101");
        childModel1.setName("childModel1");
        childModel1.setParentCode("123401");
        // 子节点2
        OrgModel childModel2 = new OrgModel();
        childModel2.setCode("12340102");
        childModel2.setName("childModel2");
        childModel2.setParentCode("123401");


        // 父节点2
        OrgModel parentModel2 = new OrgModel();
        parentModel2.setCode("123402");
        parentModel2.setName("parentModel2");
        parentModel2.setParentCode("123400");

        // 子节点1
        OrgModel childModel3 = new OrgModel();
        childModel3.setCode("12340201");
        childModel3.setName("childModel3");
        childModel3.setParentCode("123402");

        // 子节点2
        OrgModel childModel4 = new OrgModel();
        childModel4.setCode("12340202");
        childModel4.setName("childModel4");
        childModel4.setParentCode("123402");

        orgs.add(rootModel);
        orgs.add(parentModel1);
        orgs.add(parentModel2);
        orgs.add(childModel1);
        orgs.add(childModel2);
        orgs.add(childModel3);
        orgs.add(childModel4);
        return orgs;
    }

    public static OrgModel List2Tree(List<OrgModel> orgs) {
        OrgModel rootModel = null;
        for (OrgModel parentModel : orgs) {
            if (parentModel.getName().equals("root")) {
                rootModel = parentModel;
            }
            for (OrgModel childModel: orgs) {
                if (childModel.getParentCode().equals(parentModel.getCode())) {
                    parentModel.addChild(childModel);
                }
            }
        }
        return rootModel;
    }

    public static void initGroupInfo (OrgModel rootModel) {
        System.out.println(rootModel.getName());
        number ++ ;
        if (rootModel.getOrgModels() == null) {
            return;
        }
        for (OrgModel orgModel : rootModel.getOrgModels()) {
            rootModel.setGroupPersonNumber(rootModel.getOrgModels().size() + 1);
            initGroupInfo(orgModel);
        }
    }

    public static void treeTest() {
        List<OrgModel> orgs = buildList();
        OrgModel rootModel = List2Tree(orgs);
        initGroupInfo(rootModel);
        System.out.println(rootModel.getGroupPersonNumber());

        System.out.println(number);
    }

    public static void containsSubstrNumbers(String parentStr, String childStr) {
        int childNumber = 0;
        int childStrLength = childStr.length();
        while(parentStr.indexOf(childStr) != -1) {
            childNumber++;
            parentStr = parentStr.substring(parentStr.indexOf(childStr)+ childStrLength, parentStr.length());
        }
        System.out.println(childNumber);
    }

    public static boolean isHKPhoneLegal(String str) {
        String regExp = "^(5|6|8|9)\\d{7}$";
//        String regExp = "^((((0?)|((00)?))(((\\s){0,2})|([-_－—\\s]?)))|([+]?))(853)?([]?)))|([+]?))(853)?([]?)([-_－—\\s]?)(28[0-9]{2}|((6|8)[0-9]{3}))[-_－—\\s]?[0-9]{4}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private  static void getMobile(String mobile) {
        String areaString = "+86";
        String m = mobile.substring(mobile.indexOf(areaString) + areaString.length(), mobile.length());
        System.out.println(m);
    }
    private static void testTimestamp() {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String timeString = sdf.format(createTime);
        System.out.println(timeString);

        StringBuffer sb = new StringBuffer();
        sb.append(createTime);
        System.out.println(sb.toString());

    }


    private static void testSendSms() {

    }

    private static  void testException() {
        try {
            System.out.println(1);
            throw  new RuntimeException("123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    public static void main(String[] args) throws Exception {
        Long TIME_INTERVAL = 30 * 60 * 1000L;
        Date now = new Date();
        Long scannerTime = now.getTime() + TIME_INTERVAL;
        Date scnnerDate = new Date(scannerTime);
        System.out.println(scnnerDate);

    }



}
