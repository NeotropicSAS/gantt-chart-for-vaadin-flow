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
 * This class provides information about the attributes that make up the reservation of the chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttReservation {
    /**
     * The id of the resource to associate with an activity. Property --> resource. 
     */
    private String resourceId;
    /**
     * The id of the activity to associate with a resource. Property --> activity.
     */
    private String activityId;
    
    /**
     * Constructor of the chart reservation. With a resource id and activity id.
     * @param resourceId The id of the resource to associate with an activity.
     * @param activityId The id of the activity to associate with a resource.
     */
    public GanttReservation(String resourceId, String activityId) {
        this.resourceId = resourceId;
        this.activityId = activityId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }   
}