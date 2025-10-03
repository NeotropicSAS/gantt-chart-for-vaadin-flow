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

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

/**
 * This class provides information about the attributes that make up the activity of the chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttActivity {
    /**
     * A unique string identifier for the activity.
     */
    private String id;
    /**
     * The name of the activity, displayed in the time table row representing the resource in a Schedule chart.
     */
    private String name;
    /**
     * The id of the resource parent of this resource. This property is optional if no parent.
     */
    private String parentId;
    /**
     * Start date of the activity, date given as the number of milliseconds since Unix Epoch (January 1, 1970}.
     */
    private long start;
    /**
     * End date of the activity, date given as the number of milliseconds since Unix Epoch (January 1, 1970}.
     */
    private long end;
    /**
     * Additional properties if they exist.
     */
    private LinkedHashMap<String, Object> properties;
    
    /**
     * Constructor of the chart activity. With a unique id, name, start date, end date and parent id.
     * @param id A unique string identifier for the activity.
     * @param name The name of the activity.
     * @param start Start date of the activity.
     * @param end End date of the activity.
     * @param parentId The id of the resource parent of this resource. It can be an empty string, it cannot be null.
     */
    public GanttActivity(String id, String name, long start, long end, String parentId) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.parentId = parentId;
    }
    
    /**
     * Constructor of the chart activity. With an unique id, name, start date, end date, parent id and additional property set.
     * @param id A unique string identifier for the activity.
     * @param name The name of the activity.
     * @param start Start date of the activity.
     * @param end End date of the activity.
     * @param parentId The id of the resource parent of this resource. It can be an empty string, it cannot be null.
     * @param properties Additional property set. The key of each property cannot be null or empty, the values can be empty but not null.
     */
    public GanttActivity(String id, String name, long start, long end, String parentId, LinkedHashMap<String, Object> properties) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.parentId = parentId;
        this.properties = properties;
    }
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public LinkedHashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(LinkedHashMap<String, Object> properties) {
        this.properties = properties;
    }

    public String getFormattedStartDate() {
        LocalDate date = Instant.ofEpochMilli(start).atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public String getFormattedEndDate() {
        LocalDate date = Instant.ofEpochMilli(end).atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}