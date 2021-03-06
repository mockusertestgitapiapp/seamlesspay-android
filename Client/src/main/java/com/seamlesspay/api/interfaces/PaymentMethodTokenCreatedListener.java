/**
 * Copyright (c) Seamless Payments, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.seamlesspay.api.interfaces;

import com.seamlesspay.api.models.PaymentMethodToken;

/**
 * Interface that defines callbacks to be called when {@link PaymentMethodToken}s are created.
 */
public interface PaymentMethodTokenCreatedListener extends SeamlesspayListener {
  /**
   * {@link #onPaymentMethodTokenCreated} will be called when a new {@link PaymentMethodToken} has been
   * created.
   *
   * @param paymentMethodToken the {@link PaymentMethodToken}.
   */
  void onPaymentMethodTokenCreated(PaymentMethodToken paymentMethodToken);
}
