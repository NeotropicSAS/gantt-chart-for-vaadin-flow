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
 * This class provides information about the types of Gantt chart.
 * There are two types of Gantt chart: the Scheduling chart and the Activity Chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public enum GanttType {
    /**
     * An Activity Chart. Property --> type.
     */
    ACTIVITY_CHART("ACTIVITY_CHART"),
    /**
     * A Schedule Chart. Property --> type.
     */
    SCHEDULE_CHART("SCHEDULE_CHART");

    private final String value;

    private GanttType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }   
}