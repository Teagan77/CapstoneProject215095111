package org.randall.teagan.Domain.Membership;

public class Membership {

    private String membershipID = "00000";
    private MemberType memType;

    public Membership(){}

    private Membership(MembershipBuilder memBuilder){
        this.membershipID = memBuilder.membershipID;
        this.memType = memBuilder.memType;
    }

    public String getMembershipID(){
        return membershipID;
    }

    public MemberType getMemType() {
        return memType;
    }

    public static class MembershipBuilder{

        private String membershipID;
        private MemberType memType;

        public MembershipBuilder membershipID(String membershipID){
         this.membershipID = membershipID;
         return this;
        }

        public MembershipBuilder memType(MemberType memType){
            this.memType = memType;
            return this;
        }

        public Membership build() {
            return new Membership(this);
        }

        public Membership.MembershipBuilder copy(Membership membership) {
            this.membershipID = membership.membershipID;
            this.memType = membership.memType;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Membership{" +
                " memType ='" + getMemType() + '\'' +
                " membershipID ='" + getMembershipID() + '\'' +
                '}';
    }
}
