package org.randall.teagan.Domain.Membership;

public class StudentMember extends MemberType{

    private String memCode = "S001";
    private String memTypeName = "Student Membership";
    private String studNo;

    public StudentMember(){}

    public StudentMember(StudentMemBuilder studentMemBuilder){
        this.memCode = studentMemBuilder.memCode;
        this.memTypeName = studentMemBuilder.memTypeName;
        this.studNo = studentMemBuilder.studNo;
    }

    public String getMemCode() {
        return memCode;
    }

    public String getMemTypeName() {
        return memTypeName;
    }

    public String getStudNo() {
        return studNo;
    }

    public static class StudentMemBuilder{

        private String memCode;
        private String memTypeName;
        private String studNo;

        public StudentMemBuilder memCode(String memCode){
            this.memCode = memCode;
            return this;
        }

        public StudentMemBuilder memType(String memTypeName){
            this.memTypeName = memTypeName;
            return this;
        }

        public StudentMemBuilder studNo(String studNo){
            this.studNo = studNo;
            return this;
        }

        public StudentMember build() {
            return new StudentMember(this);
        }
    }
    @Override
    public String toString() {
        return "Student Membership{" +
                " membershipCode ='" + getMemCode() + '\'' +
                " membershipTypeName ='" + getMemTypeName() + '\'' +
                " studentNo ='" + getStudNo() + '\'' +
                '}';
    }
}
