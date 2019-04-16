package org.randall.teagan.Domain.Membership;

public class FullTimeMember extends MemberType{

    private String memCode = "F003";
    private String memTypeName = "Full-Time Membership";

    public FullTimeMember(){}

    public FullTimeMember(FullTimeMemberBuilder fullTimeMemberBuilder) {
        this.memTypeName = fullTimeMemberBuilder.memTypeName;
        this.memCode = fullTimeMemberBuilder.memCode;
    }

    public String getMemCode(){
        return memCode;
    }

    public String getMemTypeName(){
        return memTypeName;
    }

    public static class FullTimeMemberBuilder{

        private String memCode;
        private String memTypeName;

        public FullTimeMemberBuilder memCode(String memCode){
            this.memCode = memCode;
            return this;
        }
        public FullTimeMemberBuilder memType(String memTypeName){
            this.memTypeName = memTypeName;
            return this;
        }

        public FullTimeMember build() {
            return new FullTimeMember(this);
        }
    }
    @Override
    public String toString() {
        return "FullTimeMember{" +
                " memTypeName ='" + getMemTypeName() + '\'' +
                " membershipCode ='" + getMemCode() + '\'' +
                '}';
    }
}
