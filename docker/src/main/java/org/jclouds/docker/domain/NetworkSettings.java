/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.docker.domain;

import static org.jclouds.docker.internal.NullSafeCopies.copyOf;

import java.util.List;
import java.util.Map;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NetworkSettings {

   @AutoValue
   public abstract static class Details {

      Details() {} // For AutoValue only!

      public abstract String endpoint();

      public abstract String gateway();

      public abstract String ipAddress();

      public abstract int ipPrefixLen();

      public abstract String ipv6Gateway();

      public abstract String globalIPv6Address();

      public abstract int globalIPv6PrefixLen();

      public abstract String macAddress();

      @SerializedNames({ "EndpointID", "Gateway", "IPAddress", "IPPrefixLen", "IPv6Gateway", "GlobalIPv6Address", "GlobalIPv6PrefixLen", "MacAddress" })
      public static Details create(String endpointId, String gateway, String ipAddress, int ipPrefixLen, String ipv6Gateway, String globalIPv6Address,
                                   int globalIPv6PrefixLen, String macAddress) {
         return new AutoValue_NetworkSettings_Details(endpointId, gateway, ipAddress, ipPrefixLen, ipv6Gateway, globalIPv6Address, globalIPv6PrefixLen,
                 macAddress);
      }
   }

   public abstract String bridge();

   @Nullable public abstract String sandboxId();

   public abstract boolean hairpinMode();

   @Nullable public abstract String linkLocalIPv6Address();

   public abstract int linkLocalIPv6PrefixLen();

   @Nullable public abstract Map<String, List<Map<String, String>>> ports();

   @Nullable public abstract String sandboxKey();

   public abstract List<String> secondaryIPAddresses();

   public abstract List<String> secondaryIPv6Addresses();

   @Nullable public abstract String endpointId();

   public abstract String gateway();

   @Nullable public abstract String globalIPv6Address();

   public abstract int globalIPv6PrefixLen();

   public abstract String ipAddress();

   public abstract int ipPrefixLen();

   @Nullable public abstract String ipv6Gateway();

   @Nullable public abstract String macAddress();

   public abstract Map<String, Details> networks();

   @Nullable public abstract String portMapping();

   NetworkSettings() {
   }

   @SerializedNames({ "Bridge", "SandboxID", "HairpinMode", "LinkLocalIPv6Address",
           "LinkLocalIPv6PrefixLen", "Ports", "SandboxKey", "SecondaryIPAddresses",
           "SecondaryIPv6Addresses", "EndpointID", "Gateway", "GlobalIPv6Address",
           "GlobalIPv6PrefixLen", "IPAddress", "IPPrefixLen", "IPv6Gateway",
           "MacAddress", "Networks", "PortMapping" })
   public static NetworkSettings create(String bridge, String sandboxId, boolean hairpinMode, String linkLocalIPv6Address,
                                        int linkLocalIPv6PrefixLen, Map<String, List<Map<String, String>>> ports, String sandboxKey, List<String> secondaryIPAddresses,
                                        List<String> secondaryIPv6Addresses, String endpointId, String gateway, String globalIPv6Address,
                                        int globalIPv6PrefixLen, String ipAddress, int ipPrefixLen, String ipv6Gateway,
                                        String macAddress, Map<String, Details> networks, String portMapping) {
      return builder().bridge(bridge).sandboxId(sandboxId).hairpinMode(hairpinMode).linkLocalIPv6Address(linkLocalIPv6Address)
              .linkLocalIPv6PrefixLen(linkLocalIPv6PrefixLen).ports(ports).sandboxKey(sandboxKey)
              .secondaryIPAddresses(copyOf(secondaryIPAddresses)).secondaryIPv6Addresses(copyOf(secondaryIPv6Addresses))
              .endpointId(endpointId).gateway(gateway).globalIPv6Address(globalIPv6Address).globalIPv6PrefixLen(globalIPv6PrefixLen)
              .ipAddress(ipAddress).ipPrefixLen(ipPrefixLen).ipv6Gateway(ipv6Gateway)
              .macAddress(macAddress).networks(copyOf(networks)).portMapping(portMapping)
              .build();
   }

   public Builder toBuilder() {
      return new AutoValue_NetworkSettings.Builder(this);
   }

   public static Builder builder() {
      return new AutoValue_NetworkSettings.Builder();
   }

   @AutoValue.Builder
   public abstract static class Builder {
      public abstract Builder bridge(String value);
      public abstract Builder sandboxId(String value);
      public abstract Builder hairpinMode(boolean value);
      public abstract Builder linkLocalIPv6Address(String value);
      public abstract Builder linkLocalIPv6PrefixLen(int value);
      public abstract Builder ports(Map<String, List<Map<String, String>>> value);
      public abstract Builder sandboxKey(String value);
      public abstract Builder secondaryIPAddresses(List<String> value);
      public abstract Builder secondaryIPv6Addresses(List<String> value);
      public abstract Builder endpointId(String value);
      public abstract Builder gateway(String value);
      public abstract Builder globalIPv6Address(String value);
      public abstract Builder globalIPv6PrefixLen(int value);
      public abstract Builder ipAddress(String value);
      public abstract Builder ipPrefixLen(int value);
      public abstract Builder ipv6Gateway(String value);
      public abstract Builder macAddress(String value);
      public abstract Builder networks(Map<String, Details> value);
      public abstract Builder portMapping(String value);
      
      public abstract NetworkSettings build();
   }
}
