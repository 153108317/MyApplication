package com.example.yh.myapplication.entities;


import com.example.yh.myapplication.base.BasicResult;

public class UserBean  extends BasicResult {




    private DataEntity data;

//    public DataEntity getData() {
//        return data;
//    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {

        private MemberEntity member;

        public MemberEntity getMember() {
            return member;
        }

        public void setMember(MemberEntity member) {
            this.member = member;
        }

        public static class MemberEntity {
            private long id;
            private long memberId;
            private String name;
            private String mobile;
            private String email;
            private String birthDay;
            private String nickname;
            private String sex;
            private boolean d2c;
            private String thirdPic;
            private String head;
            private String backgroud;
            private String loginCode;
            private String loginDate;
            private String userToken;
            private String recCode;
            private long recId;
            private int allowPartner;
            private long partnerId;
            private long bindPartnerId;
            private long designerId;
            private String designerName;
            private String designDescription;
            private String designerPic;
            private String nationCode;
            private String imToken;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public long getMemberId() {
                return memberId;
            }

            public void setMemberId(long memberId) {
                this.memberId = memberId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getBirthDay() {
                return birthDay;
            }

            public void setBirthDay(String birthDay) {
                this.birthDay = birthDay;
            }

            public String getNickname() {
                return( nickname==null||nickname=="") ? nickname : "匿名_" + id;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public boolean isD2c() {
                return d2c;
            }

            public void setD2c(boolean d2c) {
                this.d2c = d2c;
            }

            public String getThirdPic() {
                return thirdPic;
            }

            public void setThirdPic(String thirdPic) {
                this.thirdPic = thirdPic;
            }

            public String getHead() {
                return ! (head==null ||head=="") ? head : thirdPic;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public String getBackgroud() {
                return backgroud;
            }

            public void setBackgroud(String backgroud) {
                this.backgroud = backgroud;
            }

            public String getLoginCode() {
                return loginCode;
            }

            public void setLoginCode(String loginCode) {
                this.loginCode = loginCode;
            }

            public String getLoginDate() {
                return loginDate;
            }

            public void setLoginDate(String loginDate) {
                this.loginDate = loginDate;
            }

            public String getUserToken() {
                return userToken;
            }

            public void setUserToken(String userToken) {
                this.userToken = userToken;
            }

            public String getRecCode() {
                return recCode;
            }

            public void setRecCode(String recCode) {
                this.recCode = recCode;
            }

            public long getRecId() {
                return recId;
            }

            public void setRecId(long recId) {
                this.recId = recId;
            }

            public int getAllowPartner() {
                return allowPartner;
            }

            public void setAllowPartner(int allowPartner) {
                this.allowPartner = allowPartner;
            }

            public String getDesignerName() {
                return designerName;
            }

            public void setDesignerName(String designerName) {
                this.designerName = designerName;
            }

            public String getDesignDescription() {
                return designDescription;
            }

            public void setDesignDescription(String designDescription) {
                this.designDescription = designDescription;
            }

            public String getDesignerPic() {
                return designerPic;
            }

            public void setDesignerPic(String designerPic) {
                this.designerPic = designerPic;
            }

            public long getPartnerId() {
                return partnerId;
            }

            public void setPartnerId(long partnerId) {
                this.partnerId = partnerId;
            }

            public long getBindPartnerId() {
                return bindPartnerId;
            }

            public void setBindPartnerId(long bindPartnerId) {
                this.bindPartnerId = bindPartnerId;
            }

            public long getDesignerId() {
                return designerId;
            }

            public void setDesignerId(long designerId) {
                this.designerId = designerId;
            }

            public String getNationCode() {
                return nationCode;
            }

            public void setNationCode(String nationCode) {
                this.nationCode = nationCode;
            }

            public String getImToken() {
                return imToken;
            }

            public void setImToken(String imToken) {
                this.imToken = imToken;
            }
        }
    }
}
