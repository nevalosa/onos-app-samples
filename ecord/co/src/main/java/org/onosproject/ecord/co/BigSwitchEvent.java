package org.onosproject.ecord.co;
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

import org.onosproject.event.AbstractEvent;

/**
 * Entity that represents Alarm events.
 */
public class BigSwitchEvent extends AbstractEvent<BigSwitchEvent.Type, Alarm> {


    /**
     * Creates an event of a given type and for the specified alarm and the
     * current time.
     *
     * @param type  topology event type
     * @param alarm the alarm
     */
    public BigSwitchEvent(Type type, Alarm alarm) {
        super(type, alarm);
    }

    /**
     * Creates an event of a given type and for the specified alarm and time.
     *
     * @param type  link event type
     * @param alarm the alarm
     * @param time  occurrence time
     */
    public BigSwitchEvent(Type type, Alarm alarm,
                      long time) {
        super(type, alarm, time);
    }

    /**
     * Type of alarm events.
     */
    public enum Type {
        /**
         * A Raised Alarm.
         */
        RAISE,

        /**
         * A Cleared Alarm.
         */
        CLEAR
    }


}