package org.randall.teagan.Domain.Membership;

public class MemberType {

    private String memCode = "X000";
    private String memTypeName = "Default Membership";

    public MemberType(){}

    public MemberType(MemberTypeBuilder memberTypeBuilder) {
        this.memTypeName = memberTypeBuilder.memTypeName;
        this.memCode = memberTypeBuilder.memCode;
    }

    public String getMemCode(){
        return memCode;
    }

    public String getMemTypeName(){
        return memTypeName;
    }

    public static class MemberTypeBuilder{

        private String memCode;
        private String memTypeName;

        public MemberTypeBuilder memCode(String memCode){
            this.memCode = memCode;
            return this;
        }
        public MemberTypeBuilder memType(String memTypeName){
            this.memTypeName = memTypeName;
            return this;
        }

        public MemberType build() {
            return new MemberType(this);
        }
    }
    @Override
    public String toString() {
        return "Membership{" +
                " memTypeName ='" + getMemTypeName() + '\'' +
                " membershipCode ='" + getMemCode() + '\'' +
                '}';
    }
}
