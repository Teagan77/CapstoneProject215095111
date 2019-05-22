package org.randall.teagan.Domain.Vehicle;

public class Cityliner {

    private String busTypeCode = "B004", busTypeName = "Cityliner";

    public Cityliner(){}

    public Cityliner(CitylinerBuilder citylinerBuilder) {
        this.busTypeCode = citylinerBuilder.busTypeCode;
        this.busTypeName = citylinerBuilder.busTypeName;
    }

    public String getBusTypeCode() {
        return busTypeCode;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public static class CitylinerBuilder{

        private String busTypeCode, busTypeName;

        public CitylinerBuilder busTypeCode(String busTypeCode){
            this.busTypeCode = busTypeCode;
            return this;
        }

        public CitylinerBuilder busTypeName(String busTypeName){
            this.busTypeName = busTypeName;
            return this;
        }

        public Cityliner build() {
            return new Cityliner(this);
        }

        public CitylinerBuilder copy(Cityliner cityliner) {
            this.busTypeCode = cityliner.busTypeCode;
            this.busTypeName = cityliner.busTypeName;
            return this;
        }
    }
    @Override
    public String toString() {
        return "Cityliner{" +
                "busTypeCode ='" + getBusTypeCode() + '\'' +
                ", busTypeName ='" + getBusTypeName() + '\'' +
                '}';
    }
}
