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
import static org.jclouds.docker.internal.NullSafeCopies.copyWithNullOf;

import java.util.List;
import java.util.Map;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class HostConfig {
   @Nullable public abstract String containerIDFile();

   @Nullable public abstract List<String> binds();

   public abstract List<Map<String, String>> lxcConf();

   public abstract boolean privileged();

   @Nullable public abstract List<String> dns();

   @Nullable public abstract List<String> dnsSearch();

   public abstract Map<String, List<Map<String, String>>> portBindings();

   @Nullable public abstract List<String> links();

   @Nullable public abstract List<String> extraHosts();

   public abstract boolean publishAllPorts();

   @Nullable public abstract List<String> volumesFrom();

   @Nullable public abstract String networkMode();

   @Nullable public abstract List<String> securityOpt();

   @Nullable public abstract List<String> capAdd();

   @Nullable public abstract List<String> capDrop();

   public abstract Map<String, String> restartPolicy();



   HostConfig() {
   }

   @SerializedNames({ "ContainerIDFile", "Binds", "LxcConf", "Privileged", "Dns", "DnsSearch", "PortBindings",
         "Links", "ExtraHosts", "PublishAllPorts", "VolumesFrom", "NetworkMode", "SecurityOpt",
         "CapAdd", "CapDrop", "RestartPolicy" })
   public static HostConfig create(String containerIDFile, List<String> binds, List<Map<String, String>> lxcConf,
         boolean privileged, List<String> dns, List<String> dnsSearch, Map<String, List<Map<String, String>>> portBindings,
         List<String> links, List<String> extraHosts, boolean publishAllPorts, List<String> volumesFrom, String networkMode, 
         List<String> securityOpt, List<String> capAdd, List<String> capDrop, Map<String, String> restartPolicy) {
      return builder().containerIDFile(containerIDFile).binds(copyWithNullOf(binds)).lxcConf(copyOf(lxcConf))
            .privileged(privileged).dns(copyWithNullOf(dns)).dnsSearch(copyWithNullOf(dnsSearch))
            .portBindings(copyOf(portBindings)).links(copyWithNullOf(links)).extraHosts(copyWithNullOf(extraHosts))
            .publishAllPorts(publishAllPorts).volumesFrom(copyWithNullOf(volumesFrom)).networkMode(networkMode)
            .securityOpt(copyOf(securityOpt)).capAdd(copyWithNullOf(capAdd)).capDrop(copyWithNullOf(capDrop))
            .restartPolicy(copyOf(restartPolicy)).build();
   }

   public Builder toBuilder() {
      return new AutoValue_HostConfig.Builder(this);
   }

   public static Builder builder() {
      return new AutoValue_HostConfig.Builder();
   }

   @AutoValue.Builder
   public abstract static class Builder {
      public abstract Builder containerIDFile(String value);
      public abstract Builder binds(List<String> value);
      public abstract Builder lxcConf(List<Map<String, String>> value);
      public abstract Builder privileged(boolean value);
      public abstract Builder dns(List<String> value);
      public abstract Builder dnsSearch(List<String> value);
      public abstract Builder portBindings(Map<String, List<Map<String, String>>> value);
      public abstract Builder links(List<String> value);
      public abstract Builder extraHosts(List<String> value);
      public abstract Builder publishAllPorts(boolean value);
      public abstract Builder volumesFrom(List<String> value);
      public abstract Builder networkMode(String value);
      public abstract Builder securityOpt(List<String> value);
      public abstract Builder capAdd(List<String> value);
      public abstract Builder capDrop(List<String> value);
      public abstract Builder restartPolicy(Map<String, String> value);
      
      public abstract HostConfig build();
   }
}
