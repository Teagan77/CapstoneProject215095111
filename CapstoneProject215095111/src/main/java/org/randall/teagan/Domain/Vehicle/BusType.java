package org.randall.teagan.Domain.Vehicle;

public class BusType {

    private String busTypeCode = "B001", busTypeName = "Default Bus";

    public BusType(){}

    public BusType(BusTypeBuilder busTypeBuilder) {
        this.busTypeCode = busTypeBuilder.busTypeCode;
        this.busTypeName = busTypeBuilder.busTypeName;
    }

    public String getBusTypeCode() {
        return busTypeCode;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public static class BusTypeBuilder{

        private String busTypeCode, busTypeName;

        public BusTypeBuilder busTypeCode(String busTypeCode){
            this.busTypeCode = busTypeCode;
            return this;
        }

        public BusTypeBuilder busTypeName(String busTypeName){
            this.busTypeName = busTypeName;
            return this;
        }

        public BusType build() {
            return new BusType(this);
        }
    }
    @Override
    public String toString() {
        return "BusType{" +
                "busTypeCode ='" + getBusTypeCode() + '\'' +
                ", busTypeName ='" + getBusTypeName() + '\'' +
                '}';
    }
}
