/**
 * Copyright (c) Seamless Payments, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.seamlesspay.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.InputType;
import android.util.AttributeSet;
import com.seamlesspay.cardform.R;

/**
 * Input for cardholder name. Validated for presence only.
 */
public class CardholderNameEditText extends ErrorEditText {

  public CardholderNameEditText(Context context) {
    super(context);
    init();
  }

  public CardholderNameEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CardholderNameEditText(
    Context context,
    AttributeSet attrs,
    int defStyle
  ) {
    super(context, attrs, defStyle);
    init();
  }

  private void init() {
    setInputType(InputType.TYPE_CLASS_TEXT);

    InputFilter[] filters = { new LengthFilter(255) };

    setFilters(filters);
  }

  @Override
  public boolean isValid() {
    return isOptional() || !getText().toString().trim().isEmpty();
  }

  @Override
  public String getErrorMessage() {
    return "Cardholder name is required";
  }
}
