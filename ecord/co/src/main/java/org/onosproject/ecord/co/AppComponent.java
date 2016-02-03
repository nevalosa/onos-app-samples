/*
 * Copyright 2014 Open Networking Laboratory
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
package org.onosproject.ecord.co;

//import static com.google.common.base.Preconditions.checkNotNull;
import static org.slf4j.LoggerFactory.getLogger;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
//import org.apache.felix.scr.annotations.Reference;
//import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.slf4j.Logger;
/**
 * Skeletal ONOS application component.
 */
@Component(immediate = true)
public class AppComponent {

//    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
//    protected BigSwitchDeviceProvider bigSwitchDeviceProvider;
//    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
//    protected BigSwitchManager bigSwitchManager;

    private final Logger log = getLogger(getClass());
    @Activate
    protected void activate() {
       BigSwitchDeviceProvider  obj = new BigSwitchDeviceProvider();
       BigSwitchManager bigSwitchManager = new BigSwitchManager();
       bigSwitchManager.addEvent("TEST");
        log.info(" AppComponent STARTED");
    }

    @Deactivate
    protected void deactivate() {
        log.info("Stopped");
    }

}