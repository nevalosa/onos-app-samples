package org.onosproject.ecord.co;
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



import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.onosproject.event.AbstractListenerManager;
import org.onosproject.event.EventDispatcher;
import org.onosproject.net.DeviceId;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Listens for edge and port changes in the underlying data path and
 * exposes a big switch abstraction.
 */
@Component(immediate = true)
@Service
public class BigSwitchManager
        extends AbstractListenerManager<BigSwitchEvent, BigSwitchListener>
        implements BigSwitchService {

    private static final Logger log = getLogger(BigSwitchManager.class);
    private EventDispatcher local = eventDispatcher;
    @Activate
    public void activate() {
        log.info("EVENT DISPACTHER" + eventDispatcher);
        log.info("Started");
    }

    @Deactivate
    public void deactivate() {
        log.info("Stopped");
    }

    @Override
    public void addEvent(String r) {

    log.info("INSIDE ADD EVENT");
    log.info("EVENT DISPATCHER + LOCAL" + local);
//    while (eventDispatcher == null) {
//        try {
//        Thread.sleep(2000);
//    } catch (Exception e) {
//           log.debug("EXCEPTION");
//     }
//    }
    BigSwitch a = new BigSwitch.Builder(AlarmId.valueOf(1),
    DeviceId.deviceId("dhgvfgsdfj"),
    "This is alarm for PRODUCER SERVICE",
    Alarm.SeverityLevel.CLEARED, 3L).build();
    post(new BigSwitchEvent(BigSwitchEvent.Type.RAISE, a));
    }
}
