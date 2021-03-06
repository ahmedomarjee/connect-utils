/**
 * Copyright © 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.connect.utils.config.validators;

import com.google.common.base.Preconditions;
import org.apache.kafka.common.config.ConfigDef.Validator;

public class Validators {
  private Validators() {

  }

  /**
   * Method will return a validator that will accept a blank string. Any other value will be passed
   * on to the supplied validator.
   * @param validator Validator to test non blank values with.
   * @return
   */
  public static Validator blankOr(Validator validator) {
    Preconditions.checkNotNull(validator, "validator cannot be null.");
    return BlankOrValidator.of(validator);
  }

  /**
   * Method will return a validator that will ensure that a String or List contains a URI with the
   * proper systax
   * @param schemes The uri schemes that are valid. If empty anything can be accepted.
   * @return
   */
  public static Validator validURI(String... schemes) {
    return new ValidURI(schemes);
  }
}
