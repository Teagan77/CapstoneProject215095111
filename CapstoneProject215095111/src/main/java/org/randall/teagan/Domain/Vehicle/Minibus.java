package org.randall.teagan.Domain.Vehicle;

public class Minibus {

    private String busTypeCode = "B002", busTypeName = "Minibus";

    public Minibus(){}

    public Minibus(MinibusBuilder minibusBuilder) {
        this.busTypeCode = minibusBuilder.busTypeCode;
        this.busTypeName = minibusBuilder.busTypeName;
    }

    public String getBusTypeCode() {
        return busTypeCode;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public static class MinibusBuilder{

        private String busTypeCode, busTypeName;

        public MinibusBuilder busTypeCode(String busTypeCode){
            this.busTypeCode = busTypeCode;
            return this;
        }

        public MinibusBuilder busTypeName(String busTypeName){
            this.busTypeName = busTypeName;
            return this;
        }

        public Minibus build() {
            return new Minibus(this);
        }
    }
    @Override
    public String toString() {
        return "Minibus{" +
                "busTypeCode ='" + getBusTypeCode() + '\'' +
                ", busTypeName ='" + getBusTypeName() + '\'' +
                '}';
    }
}
