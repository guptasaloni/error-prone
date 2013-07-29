/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Bill Pugh (bill.pugh@gmail.com)
 */
public class BadShiftAmountTest extends BugPatternUnitTest {

  // TODO(eaftan): Convert this to be like the other tests.
  @Before
  public void setUp() {
   setScanner(new BadShiftAmount.Scanner());
  }

  @Test
  public void testPositiveCase() throws Exception {
    super.testPositiveCase();
  }

  @Test
  public void testNegativeCase() throws Exception {
      super.testNegativeCase();
  }

}