package org.randall.teagan.Domain.Membership;

public class InternationalMember {

    private String memCode = "I002";
    private String memTypeName = "International Membership";
    private String nationality;

    public InternationalMember(){}

    public InternationalMember(InternationalMemBuilder internationalMemBuilder){
        this.memCode = internationalMemBuilder.memCode;
        this.memTypeName = internationalMemBuilder.memTypeName;
        this.nationality = internationalMemBuilder.nationality;
    }

    public String getMemCode() {
        return memCode;
    }

    public String getMemTypeName() {
        return memTypeName;
    }

    public String getNationality() {
        return nationality;
    }

    public static class InternationalMemBuilder{

        private String memCode;
        private String memTypeName;
        private String nationality;

        public InternationalMemBuilder memCode(String memCode){
            this.memCode = memCode;
            return this;
        }

        public InternationalMemBuilder memType(String memTypeName){
            this.memTypeName = memTypeName;
            return this;
        }

        public InternationalMemBuilder nationality(String nationality){
            this.nationality = nationality;
            return this;
        }

        public InternationalMember build() {
            return new InternationalMember(this);
        }
    }
    @Override
    public String toString() {
        return "International Membership{" +
                " membershipCode ='" + getMemCode() + '\'' +
                " membershipTypeName ='" + getMemTypeName() + '\'' +
                " nationality ='" + getNationality() + '\'' +
                '}';
    }
}
