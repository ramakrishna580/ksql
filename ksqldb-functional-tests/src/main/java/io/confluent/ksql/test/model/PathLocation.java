/*
 * Copyright 2020 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.test.model;

import static java.util.Objects.requireNonNull;

import com.google.common.base.Preconditions;
import java.nio.file.Path;

/**
 * Location of a file or directory.
 */
public class PathLocation implements TestLocation {

  private final Path testPath;

  public PathLocation(
      final Path testPath
  ) {
    this.testPath = requireNonNull(testPath, "testPath");
    Preconditions.checkArgument(testPath.isAbsolute(), "test path must be absolute");
  }

  @Override
  public Path getTestPath() {
    return testPath;
  }

  @Override
  public String toString() {
    return "file://" + testPath;
  }
}
