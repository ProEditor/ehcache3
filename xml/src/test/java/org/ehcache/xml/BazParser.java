/*
 * Copyright Terracotta, Inc.
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

package org.ehcache.xml;

import org.ehcache.config.ResourcePool;
import org.ehcache.config.ResourceType;
import org.w3c.dom.Element;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Set;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/**
 * Parser for the test resource {@code BazResource}
 */
public class BazParser implements CacheResourceConfigurationParser {

  private static final URI NAMESPACE = URI.create("http://www.example.com/baz");
  private static final URL XML_SCHEMA = FooParser.class.getResource("/configs/baz.xsd");

  @Override
  public Source getXmlSchema() throws IOException {
    return new StreamSource(XML_SCHEMA.openStream());
  }

  @Override
  public URI getNamespace() {
    return NAMESPACE;
  }


  @Override
  public ResourcePool parseResourceConfiguration(Element fragment) {
    return new BazResource();
  }

  @Override
  public Element unparseResourcePool(final ResourcePool resourcePool) {
    return null;
  }

  @Override
  public Set<ResourceType<?>> getResourceTypes() {
    return null;
  }
}
