package com.seamlesspay.api;

import com.seamlesspay.api.exceptions.ErrorWithResponse;
import com.seamlesspay.api.interfaces.HttpResponseCallback;
import com.seamlesspay.api.interfaces.PaymentMethodNonceCallback;
import com.seamlesspay.api.models.PaymentMethodBuilder;
import com.seamlesspay.api.models.PaymentMethodNonce;
import com.seamlesspay.api.interfaces.SeamlesspayErrorListener;

import org.json.JSONException;

import static com.seamlesspay.api.models.PaymentMethodNonce.parsePaymentMethodNonces;

class TokenizationClient {

    static final String PAYMENT_METHOD_ENDPOINT = "tokens";

    /**
     * Create a {@link PaymentMethodNonce} in the Seamlesspay Gateway.
     * <p>
     * On completion, returns the {@link PaymentMethodNonce} to {@link PaymentMethodNonceCallback}.
     * <p>
     * If creation fails validation, {@link SeamlesspayErrorListener#onError(Exception)}
     * will be called with the resulting {@link ErrorWithResponse}.
     * <p>
     * If an error not due to validation (server error, network issue, etc.) occurs, {@link
     * SeamlesspayErrorListener#onError(Exception)} (Throwable)}
     * will be called with the {@link Exception} that occurred.
     *
     * @param paymentMethodBuilder {@link PaymentMethodBuilder} for the {@link PaymentMethodNonce}
     *        to be created.
     */
    static void tokenize(final SeamlesspayFragment fragment, final PaymentMethodBuilder paymentMethodBuilder,
            final PaymentMethodNonceCallback callback) {

            tokenizeRest(fragment, paymentMethodBuilder, callback);
    }

    private static void tokenizeRest(final SeamlesspayFragment fragment, final PaymentMethodBuilder paymentMethodBuilder,
            final PaymentMethodNonceCallback callback) {

        fragment.getPanVaulHttpClient().post(TokenizationClient.PAYMENT_METHOD_ENDPOINT,
                paymentMethodBuilder.build(), new HttpResponseCallback() {
                    @Override
                    public void success(String responseBody) {
                        try {
                            callback.success(parsePaymentMethodNonces(responseBody,
                                    paymentMethodBuilder.getResponsePaymentMethodType()));
                        } catch (JSONException e) {
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void failure(Exception exception) {
                        callback.failure(exception);
                    }
                });
    }
}
