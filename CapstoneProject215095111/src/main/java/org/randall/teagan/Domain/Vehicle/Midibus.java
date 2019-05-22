package org.randall.teagan.Domain.Vehicle;

public class Midibus {

    private String busTypeCode = "B003", busTypeName = "Midibus";

    public Midibus(){}

    public Midibus(MidibusBuilder midibusBuilder) {
        this.busTypeCode = midibusBuilder.busTypeCode;
        this.busTypeName = midibusBuilder.busTypeName;
    }

    public String getBusTypeCode() {
        return busTypeCode;
    }

    public String getBusTypeName() {
        return busTypeName;
    }

    public static class MidibusBuilder{

        private String busTypeCode, busTypeName;

        public MidibusBuilder busTypeCode(String busTypeCode){
            this.busTypeCode = busTypeCode;
            return this;
        }

        public MidibusBuilder busTypeName(String busTypeName){
            this.busTypeName = busTypeName;
            return this;
        }

        public Midibus build() {
            return new Midibus(this);
        }

        public MidibusBuilder copy(Midibus midibus) {
            this.busTypeCode = midibus.busTypeCode;
            this.busTypeName = midibus.busTypeName;

            return this;
        }
    }
    @Override
    public String toString() {
        return "Midibus{" +
                "busTypeCode ='" + getBusTypeCode() + '\'' +
                ", busTypeName ='" + getBusTypeName() + '\'' +
                '}';
    }
}
