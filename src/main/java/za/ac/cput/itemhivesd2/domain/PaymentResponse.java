package za.ac.cput.transactionentity.domain;

public class PaymentResponse {

    private String url;
    private String sessionId;

    public PaymentResponse(String url, String sessionId) {
        this.url = url;
        this.sessionId = sessionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
