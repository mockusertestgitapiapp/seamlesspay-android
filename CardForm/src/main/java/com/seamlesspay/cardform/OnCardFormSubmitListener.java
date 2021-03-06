/**
 * Copyright (c) Seamless Payments, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.seamlesspay.cardform;

/**
 * Listener to receive a callback when the card form should be submitted.
 * This is triggered from a keyboard by a
 * {@link android.view.inputmethod.EditorInfo#IME_ACTION_GO} event
 */
public interface OnCardFormSubmitListener {
  /**
   * Called when the card form requests that it be submitted. Triggered from a
   * keyboard by a {@link android.view.inputmethod.EditorInfo#IME_ACTION_GO} event
   */
  void onCardFormSubmit();
}
