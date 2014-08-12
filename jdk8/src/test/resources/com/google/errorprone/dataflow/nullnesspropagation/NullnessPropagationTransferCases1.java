/*
 * Copyright 2014 Google Inc. All Rights Reserved.
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

package com.google.errorprone.dataflow.nullnesspropagation;

/**
 * Dataflow analysis cases for testing transfer functions in nullness propagation
 */
public class NullnessPropagationTransferCases1 {

  // visitEqualTo Test Cases
  
  public void equalToNull(String nullableParam) {
    String str = nullableParam;
    if (str == null) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str);
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void equalToConvergesToNonNull() {
    String str = null;
    if (str == "anything") {
      str = "non-null";
    } else {
      str = "non-null";
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void equalToConvergesToNullable() {
    String str = "non-null";
    if (str == "anything") {
      str = null;
    } else {
      str = null;
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void equalToDiverges() {
    String str = "non-null";
    if (str == "anything") {
      str = null;
    } else {
      str = "something else";
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
    
  // Note: While it is correct to type str as a Nullable value using the least upper bound, we do
  // know beforehand that str is Non-null and can deduce that the if-body is unreachable/dead code
  public void equalToNullDiverges() {
    String str = "non-null";
    if (str == null) {
      str = "non-null";
    } else {
      str = null;
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  // visitNotEqual Test Cases
  
  public void notEqual(String nullableParam) {
    String str = nullableParam;
    if (str != "rhs") {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str);
    }
    
    if ("lhs" != str) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str);
    }
    
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void notEqualToNull(String nullableParam) {
    String str = nullableParam;
    if (str != null) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str);
    }
    
    if (null != str) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str);
    }
    
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void notEqualToLocalVariable(String nullableParam) {
    String str1 = nullableParam;
    String str2 = "local variable";
    if (str1 != str2) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str1);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str1);
    }
    
    if (str2 != str1) {
      // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
      NullnessPropagationTest.triggerNullnessChecker(str1);
    } else {
      // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
      NullnessPropagationTest.triggerNullnessChecker(str1);
    }
    
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str1);
  }
  
  public void notEqualToConvergesToNonNull() {
    String str = null;
    if (str != "anything") {
      str = "non-null";
    } else {
      str = "non-null";
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Non-null)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void notEqualToConvergesToNullable() {
    String str = "non-null";
    if (str != "something else") {
      str = null;
    } else {
      str = null;
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
  
  public void notEqualToDiverges() {
    String str = "non-null";
    if (str != "anything") {
      str = "something else";
    } else {
      str = null;
    }
    // BUG: Diagnostic contains: triggerNullnessChecker(Nullable)
    NullnessPropagationTest.triggerNullnessChecker(str);
  }
}