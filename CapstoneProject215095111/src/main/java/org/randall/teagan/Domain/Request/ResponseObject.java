package org.randall.teagan.Domain.Request;

public class ResponseObject {

        private String responseCode, responseDescription;
        private Object response;

        public ResponseObject(String responseCode, String responseDescription) {
            this.responseCode = responseCode;
            this.responseDescription = responseDescription;
        }

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseDescription() {
            return responseDescription;
        }

        public void setResponseDescription(String responseDescription) {
            this.responseDescription = responseDescription;
        }

        public Object getResponse() {
            return response;
        }

        public void setResponse(Object response) {
            this.response = response;
        }

        @Override
        public String toString() {
            return "ResponseObject{" +
                    "Response code: " + responseCode + '\n' +
                    "Response desc: " + responseDescription + '\n' +
                    "Response: " + response +
                    '}';
        }
}
