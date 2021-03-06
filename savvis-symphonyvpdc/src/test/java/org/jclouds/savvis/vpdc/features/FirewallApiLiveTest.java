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
package org.jclouds.savvis.vpdc.features;

import org.jclouds.savvis.vpdc.domain.FirewallRule;
import org.jclouds.savvis.vpdc.domain.Resource;
import org.jclouds.savvis.vpdc.domain.Task;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FirewallApiLiveTest extends BaseVPDCApiLiveTest {

   private FirewallApi api;
   private String billingSiteId;
   private String vpdcId;

   @Override
   @BeforeGroups(groups = { "live" })
   public void setupContext() {
      super.setupContext();
      api = restContext.getApi().getFirewallApi();
   }
   
   @Test(groups = "live")
   public void testAddFirewallRule() throws Exception {
	  billingSiteId = restContext.getApi().getBrowsingApi().getOrg(null).getId();// default
	  vpdcId = Iterables.find(restContext.getApi().getBrowsingApi().getOrg(billingSiteId).getVDCs(),
	           new Predicate<Resource>() {
	
	              // try to find the first VDC owned by the current user
	              // check here for what the email property might be, or in
	              // the jclouds-wire.log
	              @Override
	              public boolean apply(Resource arg0) {
	                 String description = restContext.getApi().getBrowsingApi().getVDCInOrg(billingSiteId,
	                          arg0.getId()).getDescription();
	                 return description.indexOf(email) != -1;
	              }
	
	           }).getId();
	   
      String networkTierName = Iterables.get(
               restContext.getApi().getBrowsingApi().getVDCInOrg(billingSiteId, vpdcId).getAvailableNetworks(), 0)
               .getName();   
	      
	   FirewallRule firewallRule = FirewallRule.builder().firewallType("SERVER_TIER_FIREWALL").isEnabled(true).source("internet")
	  	.destination(networkTierName).port("10000").protocol("Tcp").policy("allow").description("Server Tier Firewall Rule").isLogged(false).build();
	   
	   System.out.printf("adding firewall rule:%s in vpdc %s %n", firewallRule.toString(), vpdcId);
	   
	   Task task = api.addFirewallRule(billingSiteId, vpdcId, firewallRule);
	   
	   // make sure there's no error
	   assert task.getId() != null && task.getError() == null : task;
	   
	   assert this.taskTester.apply(task.getId());
   }
   
   @Test(groups = "live", dependsOnMethods = {"testAddFirewallRule"})
   public void testDeleteFirewallRule() throws Exception {
	   billingSiteId = restContext.getApi().getBrowsingApi().getOrg(null).getId();// default
	   vpdcId = Iterables.find(restContext.getApi().getBrowsingApi().getOrg(billingSiteId).getVDCs(),
	               new Predicate<Resource>() {

	                  // try to find the first VDC owned by the current user
	                  // check here for what the email property might be, or in
	                  // the jclouds-wire.log
	                  @Override
	                  public boolean apply(Resource arg0) {
	                     String description = restContext.getApi().getBrowsingApi().getVDCInOrg(billingSiteId,
	                              arg0.getId()).getDescription();
	                     return description.indexOf(email) != -1;
	                  }

	               }).getId();
	      
      String networkTierName = Iterables.get(
               restContext.getApi().getBrowsingApi().getVDCInOrg(billingSiteId, vpdcId).getAvailableNetworks(), 0)
               .getName();
	      
	   FirewallRule firewallRule = FirewallRule.builder().firewallType("SERVER_TIER_FIREWALL").isEnabled(true).source("internet")
	  	.destination(networkTierName).port("10000").protocol("Tcp").policy("allow").description("Server Tier Firewall Rule").isLogged(false).build();

	   System.out.printf("deleting firewall rule:%s in vpdc %s %n", firewallRule.toString(), vpdcId);
	   
	   Task task = api.deleteFirewallRule(billingSiteId, vpdcId, firewallRule);
	   
	   // make sure there's no error
	   assert task.getId() != null && task.getError() == null : task;

	   assert this.taskTester.apply(task.getId());
   }
}
