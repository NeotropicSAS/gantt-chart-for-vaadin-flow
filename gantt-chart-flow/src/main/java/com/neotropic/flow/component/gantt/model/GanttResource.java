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

import java.util.LinkedHashMap;

/**
 * This class provides information about the attributes that make up the resource of the chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttResource {
    /**
     * A unique identifier for the resource.
     */
    private String id;
    /**
     * The name of the resource, displayed in the table row representing the resource in a Schedule chart.
     */
    private String name;
    /**
     * The id of the resource parent of this resource. This property is optional if no parent.
     */
    private String parentId;
    /**
     * Additional properties if they exist.
     */
    private LinkedHashMap<String, Object> properties;
    
    /**
     * Constructor of the chart resource. With a unique id, name and parent id.
     * @param id A unique identifier for the resource.
     * @param name The name of the resource.
     * @param parentId The id of the resource parent of this resource. It can be an empty string, it cannot be null.
     */
    public GanttResource(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
        
    /**
     * Constructor of the chart resource. With a unique id, name, parent id and additional property set.
     * @param id A unique identifier for the resource.
     * @param name The name of the resource.
     * @param parentId The id of the resource parent of this resource. It can be an empty string, it cannot be null.
     * @param properties Additional property set. The key of each property cannot be null or empty, the values can be empty but not null.
     */
    public GanttResource(String id, String name, String parentId, LinkedHashMap<String, Object> properties) {
        this.id = id;
        this.name = name;
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

    public LinkedHashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(LinkedHashMap<String, Object> properties) {
        this.properties = properties;
    }
}