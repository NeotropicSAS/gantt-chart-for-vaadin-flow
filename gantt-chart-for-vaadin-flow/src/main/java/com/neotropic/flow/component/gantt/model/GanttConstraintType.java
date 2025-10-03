/*
 * Copyright 2010-2022 Neotropic SAS <contact@neotropic.co>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neotropic.flow.component.gantt.model;

/**
 * Each mapping tells the dependencies (drawn as arrows in the chart).
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public enum GanttConstraintType {
    /**
     * The target task can't start until the source task starts (but it may start later).
     */
    START_TO_START("START_TO_START"),
    /**
     * The target task can't start before the source task ends (but it may start later).
     */
    END_TO_START("END_TO_START"),
    /**
     * The target task can't end before the source task starts (but it may end later).
     */
    START_TO_END("START_TO_END"),
    /**
     * The target task can't end before the source task ends (but it may end later).
     */
    END_TO_END("END_TO_END");

    private final String displayName;
    private final int type;

    private GanttConstraintType(String displayName) {
        this.displayName = displayName;

        switch (displayName) {
            case "START_TO_START":
                this.type = 0;
                break;
            case "END_TO_START": 
                this.type = 1;
                break;
            case "START_TO_END": 
                this.type = 2;
                break;
            default:
                this.type = 3;

        }
    }

    public int getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return displayName;
    }   
}