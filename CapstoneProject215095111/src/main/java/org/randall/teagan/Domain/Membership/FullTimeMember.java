package org.randall.teagan.Domain.Membership;

import org.randall.teagan.Domain.Customer.Customer;

public class FullTimeMember extends MemberType{

    private String memCode = "F003";
    private String memTypeName = "Full-Time Membership";
    private String fullTimeMemCode = "0001";

    public FullTimeMember(){}

    public FullTimeMember(FullTimeMemberBuilder fullTimeMemberBuilder) {
        this.memTypeName = fullTimeMemberBuilder.memTypeName;
        this.memCode = fullTimeMemberBuilder.memCode;
        this.fullTimeMemCode = fullTimeMemberBuilder.fullTimeMemCode;
    }

    public String getMemCode(){
        return memCode;
    }

    public String getMemTypeName(){
        return memTypeName;
    }

    public String getFullTimeMemCode(){return fullTimeMemCode;}

    public static class FullTimeMemberBuilder{

        private String memCode;
        private String memTypeName;
        private String fullTimeMemCode;

        public FullTimeMemberBuilder memCode(String memCode){
            this.memCode = memCode;
            return this;
        }
        public FullTimeMemberBuilder memType(String memTypeName){
            this.memTypeName = memTypeName;
            return this;
        }
        public FullTimeMemberBuilder fullTimeMemberBuilder(String fullTimeMemCode){
            this.fullTimeMemCode = fullTimeMemCode;
            return this;
        }

        public FullTimeMember build() {
            return new FullTimeMember(this);
        }

        public FullTimeMember.FullTimeMemberBuilder copy(FullTimeMember fullTimeMember) {
            this.memCode = fullTimeMember.memCode;
            this.memTypeName = fullTimeMember.memTypeName;
            this.fullTimeMemCode = fullTimeMember.fullTimeMemCode;

            return this;
        }
    }
    @Override
    public String toString() {
        return "FullTimeMember{" +
                " memTypeName ='" + getMemTypeName() + '\'' +
                " membershipCode ='" + getMemCode() + '\'' +
                " membershipID ='" + getFullTimeMemCode() + '\'' +
                '}';
    }
}
