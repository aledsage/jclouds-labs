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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;
import com.google.common.base.Optional;

@AutoValue
public abstract class Container {
   public abstract String id();

   @Nullable public abstract Date created();

   @Nullable public abstract String path();

   @Nullable public abstract String name();

   public abstract List<String> args();

   @Nullable public abstract Config config();

   @Nullable public abstract State state();

   @Nullable public abstract String image();

   @Nullable public abstract NetworkSettings networkSettings();

   @Nullable public abstract String sysInitPath();

   @Nullable public abstract String resolvConfPath();

   public abstract Map<String, String> volumes();

   @Nullable public abstract HostConfig hostConfig();

   @Nullable public abstract String driver();

   @Nullable public abstract String execDriver();

   public abstract Map<String, Boolean> volumesRW();

   @Nullable public abstract String command();

   @Nullable public abstract String status();

   public abstract List<Port> ports();

   @Nullable public abstract String hostnamePath();

   @Nullable public abstract String hostsPath();

   @Nullable public abstract String mountLabel();

   @Nullable public abstract String processLabel();

   public abstract Optional<Node> node();

   Container() {
   }

   @SerializedNames(
         {
                 "Id", "Created", "Path", "Name", "Args", "Config", "State", "Image", "NetworkSettings", "SysInitPath",
                 "ResolvConfPath", "Volumes", "HostConfig", "Driver", "ExecDriver", "VolumesRW", "Command", "Status",
                 "Ports", "HostnamePath", "HostsPath", "MountLabel", "ProcessLabel", "Node"
         })
   public static Container create(String id, Date created, String path, String name, List<String> args, Config config,
                                  State state, String image, NetworkSettings networkSettings, String sysInitPath,
                                  String resolvConfPath, Map<String, String> volumes, HostConfig hostConfig,
                                  String driver, String execDriver, Map<String, Boolean> volumesRW, String command,
                                  String status, List<Port> ports, String hostnamePath, String hostsPath,
                                  String mountLabel, String processLabel, Optional<Node> node) {
      return builder().id(id).created(created).path(path).name(name).args(copyOf(args)).config(config)
               .state(state).image(image).networkSettings(networkSettings).sysInitPath(sysInitPath)
               .resolvConfPath(resolvConfPath).volumes(copyOf(volumes)).hostConfig(hostConfig)
               .driver(driver).execDriver(execDriver).volumesRW(copyOf(volumesRW)).command(command)
               .status(status).ports(copyOf(ports)).hostnamePath(hostnamePath).hostsPath(hostsPath)
               .mountLabel(mountLabel).processLabel(processLabel).node(node).build();
   }

   public Builder toBuilder() {
      return new AutoValue_Container.Builder(this);
   }

   public static Builder builder() {
      return new AutoValue_Container.Builder();
   }

   @AutoValue.Builder
   public abstract static class Builder {
      public abstract Builder id(String value);
      public abstract Builder created(Date value);
      public abstract Builder path(String value);
      public abstract Builder name(String value);
      public abstract Builder args(List<String> value);
      public abstract Builder config(Config value);
      public abstract Builder state(State value);
      public abstract Builder image(String value);
      public abstract Builder networkSettings(NetworkSettings value);
      public abstract Builder sysInitPath(String value);
      public abstract Builder resolvConfPath(String value);
      public abstract Builder volumes(Map<String, String> value);
      public abstract Builder hostConfig(HostConfig value);
      public abstract Builder driver(String value);
      public abstract Builder execDriver(String value);
      public abstract Builder volumesRW(Map<String, Boolean> value);
      public abstract Builder command(String value);
      public abstract Builder status(String value);
      public abstract Builder ports(List<Port> value);
      public abstract Builder hostnamePath(String value);
      public abstract Builder hostsPath(String value);
      public abstract Builder mountLabel(String value);
      public abstract Builder processLabel(String value);
      public abstract Builder node(Optional<Node> value);

      public abstract Container build();
   }
}
