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
public abstract class Config {
   @Nullable public abstract String hostname();

   @Nullable public abstract String domainname();

   @Nullable public abstract String user();

   public abstract int memory();

   public abstract int memorySwap();

   public abstract int cpuShares();

   public abstract boolean attachStdin();

   public abstract boolean attachStdout();

   public abstract boolean attachStderr();

   public abstract boolean tty();

   public abstract boolean openStdin();

   public abstract boolean stdinOnce();

   @Nullable public abstract List<String> env();

   @Nullable public abstract List<String> cmd();

   @Nullable public abstract List<String> entrypoint();

   public abstract String image();

   @Nullable public abstract Map<String, ?> volumes();

   @Nullable public abstract String workingDir();

   public abstract boolean networkDisabled();

   public abstract Map<String, ?> exposedPorts();

   public abstract List<String> securityOpts();

   @Nullable public abstract HostConfig hostConfig();

   Config() {
   }

   @SerializedNames(
         {
                 "Hostname", "Domainname", "User", "Memory", "MemorySwap", "CpuShares", "AttachStdin", "AttachStdout",
                 "AttachStderr", "Tty", "OpenStdin", "StdinOnce", "Env", "Cmd", "Entrypoint", "Image", "Volumes",
                 "WorkingDir", "NetworkDisabled", "ExposedPorts", "SecurityOpts", "HostConfig"
         })
   public static Config create(String hostname, String domainname, String user, int memory, int memorySwap,
         int cpuShares, boolean attachStdin, boolean attachStdout, boolean attachStderr, boolean tty,
         boolean openStdin, boolean stdinOnce, List<String> env, List<String> cmd, List<String> entrypoint,
         String image, Map<String, ?> volumes, String workingDir, boolean networkDisabled,
         Map<String, ?> exposedPorts, List<String> securityOpts, HostConfig hostConfig) {
      return builder().hostname(hostname).domainname(domainname).user(user).memory(memory).memorySwap(memorySwap)
               .cpuShares(cpuShares).attachStdin(attachStdin).attachStdout(attachStdout).attachStderr(attachStderr)
               .tty(tty).openStdin(openStdin).stdinOnce(stdinOnce).env(copyWithNullOf(env)).cmd(copyWithNullOf(cmd))
               .entrypoint(copyWithNullOf(entrypoint)).image(image).volumes(copyWithNullOf(volumes))
               .workingDir(workingDir).networkDisabled(networkDisabled).exposedPorts(copyOf(exposedPorts))
               .securityOpts(copyOf(securityOpts)).hostConfig(hostConfig).build();
   }

   public Builder toBuilder() {
      return new AutoValue_Config.Builder(this);
   }

   public static Builder builder() {
      return new AutoValue_Config.Builder();
   }

   @AutoValue.Builder
   public abstract static class Builder {
      public abstract Builder hostname(String value);
      public abstract Builder domainname(String value);
      public abstract Builder user(String value);
      public abstract Builder memory(int value);
      public abstract Builder memorySwap(int value);
      public abstract Builder cpuShares(int value);
      public abstract Builder attachStdin(boolean value);
      public abstract Builder attachStdout(boolean value);
      public abstract Builder attachStderr(boolean value);
      public abstract Builder tty(boolean value);
      public abstract Builder openStdin(boolean value);
      public abstract Builder stdinOnce(boolean value);
      public abstract Builder env(List<String> value);
      public abstract Builder cmd(List<String> value);
      public abstract Builder entrypoint(List<String> value);
      public abstract Builder image(String value);
      public abstract Builder volumes(Map<String, ?> value);
      public abstract Builder workingDir(String value);
      public abstract Builder networkDisabled(boolean value);
      public abstract Builder exposedPorts(Map<String, ?> value);
      public abstract Builder securityOpts(List<String> value);
      public abstract Builder hostConfig(HostConfig value);

      public abstract Config build();
   }
}
