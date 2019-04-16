package org.randall.teagan.Domain.Employee;

public class EmpAddress {

    private String physicalAddr;
    private int postalAddr;
    private int postalCode;

    private EmpAddress(){}

    private EmpAddress(AddrBuilder addrBuilder ){
        this.physicalAddr = addrBuilder.physicalAddr;
        this.postalAddr = addrBuilder.postalAddr;
        this.postalCode = addrBuilder.postalCode;
    }

    public String getPhysicalAddr() {
        return physicalAddr;
    }

    public int getPostalAddr() {
        return postalAddr;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public static class AddrBuilder{

        private String physicalAddr;
        private int postalAddr;
        private int postalCode;

        public AddrBuilder physicalAddr(String physicalAddr) {
            this.physicalAddr = physicalAddr;
            return this;
        }

        public AddrBuilder postalAddr(int postalAddr) {
            this.postalAddr = postalAddr;
            return this;
        }

        public AddrBuilder postalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public EmpAddress build() {
            return new EmpAddress(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                " physicalAddr ='" + physicalAddr + '\'' +
                ", postalAddr ='" + postalAddr + '\'' +
                ", postalCode ='" + postalCode + '\'' +
                '}';
    }
}
