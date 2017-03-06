/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.browse.internal;

import org.sonatype.goodies.testsupport.TestSupport;
import org.sonatype.nexus.repository.browse.QueryOptions;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class BrowseComponentsSqlBuilderTest
    extends TestSupport
{
  private BrowseComponentsSqlBuilder underTest;

  @Before
  public void setUp() {
    underTest = new BrowseComponentsSqlBuilder("repo", true, emptyList(), mock(QueryOptions.class));
  }

  @Test
  public void buildQueryToReturnNothingWhenBucketsIsEmpty() throws Exception {
    assertThat(underTest.buildBrowseSql(), is(""));
  }

  @Test
  public void buildQueryToReturnZeroCountWhenBucketsIsEmpty() throws Exception {
    assertThat(underTest.buildCountSql(), is("SELECT COUNT(0)"));
  }
}
