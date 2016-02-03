/*
 * Copyright 2015 Open Networking Laboratory
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

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.osgi.service.component.ComponentContext;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Device provider which exposes a big switch abstraction of the underlying data path.
 */
@Component(immediate = true)
public class BigSwitchDeviceProvider  {

    private static final Logger LOG = getLogger(BigSwitchDeviceProvider.class);

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected BigSwitchService bigSwitchService;

    private BigSwitchListener alarmlistener = new InternalListener();
    @Activate
    public void activate(ComponentContext context) {
        LOG.info("BigSwitchDeviceProvider : ACTIVATE");
        bigSwitchService.addListener(alarmlistener);
        LOG.info("Started");
    }

    @Deactivate
    public void deactivate() {
      LOG.info("Stopped");
    }

    private class InternalListener implements BigSwitchListener {
        @Override
        public void event(BigSwitchEvent event) {
          LOG.info("RECEIEVD ALARM EVENT IN LISTENER");
       }
    }

    public void addEVENT(String r) {
        LOG.info("BIG SWITCH SERVICE " + bigSwitchService);
        bigSwitchService.addEvent("add");
    }

    /**
     * A big switch device provider implementation.
     */
    public BigSwitchDeviceProvider() {

    }
}
