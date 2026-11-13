package za.ac.cput.transactionentity.controller;

import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.transactionentity.domain.PaymentRequest;

import za.ac.cput.transactionentity.service.StripeService;
import za.ac.cput.transactionentity.service.TransactionService;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<?> createCheckoutSession(@RequestBody PaymentRequest request) {
        try {
            return ResponseEntity.ok(stripeService.createCheckoutSession(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/status/{sessionId}")
    public ResponseEntity<String> checkPaymentStatus(@PathVariable String sessionId) {
        try {
            return ResponseEntity.ok(stripeService.checkPaymentStatus(sessionId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("error");
        }
    }
}