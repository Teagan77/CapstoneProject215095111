package org.randall.teagan.Domain.Membership;

public class InternationalMember {

    private String memCode = "I002";
    private String memTypeName = "International Membership";
    private String nationality;
    private String internationalMemID = "45646";

    public InternationalMember(){}

    public InternationalMember(InternationalMemBuilder internationalMemBuilder){
        this.memCode = internationalMemBuilder.memCode;
        this.memTypeName = internationalMemBuilder.memTypeName;
        this.nationality = internationalMemBuilder.nationality;
        this.internationalMemID = internationalMemBuilder.internationalMemID;
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

    public String getInternationalMemID() {
        return internationalMemID;
    }

    public static class InternationalMemBuilder{

        private String memCode;
        private String memTypeName;
        private String nationality;
        private String internationalMemID;


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

        public InternationalMemBuilder internationalMemID(String internationalMemID){
            this.internationalMemID = internationalMemID;
            return this;
        }

        public InternationalMember build() {
            return new InternationalMember(this);
        }

        public InternationalMemBuilder copy(InternationalMember internationalMember) {
            this.memCode = internationalMember.memCode;
            this.memTypeName = internationalMember.memTypeName;
            this.nationality = internationalMember.nationality;
            this.internationalMemID = internationalMember.internationalMemID;

            return this;
        }
    }
    @Override
    public String toString() {
        return "International Membership{" +
                " membershipCode ='" + getMemCode() + '\'' +
                " membershipTypeName ='" + getMemTypeName() + '\'' +
                " nationality ='" + getNationality() + '\'' +
                " internationalMemID ='" + getInternationalMemID() + '\'' +
                '}';
    }
}
