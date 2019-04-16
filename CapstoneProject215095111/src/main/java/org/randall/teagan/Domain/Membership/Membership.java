package org.randall.teagan.Domain.Membership;

public class Membership {

    private int membershipID = 00000;
    private MemberType memType;

    public Membership(){}

    private Membership(MembershipBuilder memBuilder){
        this.membershipID = memBuilder.membershipID;
        this.memType = memBuilder.memType;
    }

    public int getMembershipID(){
        return membershipID;
    }

    public MemberType getMemType() {
        return memType;
    }

    public static class MembershipBuilder{

        private int membershipID;
        private MemberType memType;

        public MembershipBuilder membershipID(int membershipID){
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
    }

    @Override
    public String toString() {
        return "Membership{" +
                " memType ='" + getMemType() + '\'' +
                " membershipID ='" + getMembershipID() + '\'' +
                '}';
    }
}
