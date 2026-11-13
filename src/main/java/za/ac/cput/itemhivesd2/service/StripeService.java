package za.ac.cput.transactionentity.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.ac.cput.transactionentity.domain.PaymentRequest;
import za.ac.cput.transactionentity.domain.PaymentResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class StripeService {

    @Value("${app.frontend-url}")
    private String frontendUrl;

    private final ProductCatalog catalog;

    public StripeService(ProductCatalog catalog) {
        this.catalog = catalog;
        Stripe.apiKey = "sk_test_51U8TD3En2qtYkKLq0IaanS886tDBcqFTAbFE4836IvVpuXZTZKTWlGpVRxUGMuLqytUf8w4Yr8RaEokvi22ArGno0072l2yfcq";
    }

    public PaymentResponse createCheckoutSession(PaymentRequest request) throws StripeException {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        BigDecimal subTotal = BigDecimal.ZERO;
        StringBuilder description = new StringBuilder();

        for (PaymentRequest.Item item : request.getItems()) {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Invalid quantity");
            }
            ProductCatalog.ProductInfo product = catalog.find(item.getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Unknown product " + item.getProductId());
            }
            subTotal = subTotal.add(product.price().multiply(BigDecimal.valueOf(item.getQuantity())));
            if (description.length() > 0) description.append(", ");
            description.append(item.getQuantity()).append(" x ").append(product.name());
        }

        // Same rules as CartSummary.jsx: 20% discount, R15 delivery
        BigDecimal discount = subTotal.multiply(new BigDecimal("0.20"));
        BigDecimal total = subTotal.subtract(discount)
                .add(new BigDecimal("15.00"))
                .setScale(2, RoundingMode.HALF_UP);
        long amountInCents = total.movePointRight(2).longValueExact();

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(frontendUrl + "/payment-success?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(frontendUrl + "/payment-cancel")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(1L)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("zar")
                                                .setUnitAmount(amountInCents)
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName("Itemhive Store Order")
                                                                .setDescription(description.toString())
                                                                .build())
                                                .build())
                                .build())
                .build();

        Session session = Session.create(params);
        return new PaymentResponse(session.getUrl(), session.getId());
    }

    public String checkPaymentStatus(String sessionId) throws StripeException {
        return Session.retrieve(sessionId).getPaymentStatus();
    }
}