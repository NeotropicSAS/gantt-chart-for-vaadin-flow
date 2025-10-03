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
 * This class provides information about the attributes that make up the constraints of activities.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttConstraint {
    /**
     * The id of the activity the constraints starts from. Property --> from. 
     */
    private String sourceActivityId;
    /**
     * The id of the activity the constraints goes to. Property --> to.
     */
    private String targetActivityId;
    /**
     * The type of the constraint.
     */
    private GanttConstraintType type;
    
    /**
     * Constructor of the constraint of activities. With a source activity id, target activity id and constraint type.
     * @param sourceActivityId The id of the activity the constraints starts from.
     * @param targetActivityId The id of the activity the constraints goes to.
     * @param type The type of the constraint. See the GanttConstraintType enum {@link GanttConstraintType}.
     */
    public GanttConstraint(String sourceActivityId, String targetActivityId, GanttConstraintType type) {
        this.sourceActivityId = sourceActivityId;
        this.targetActivityId = targetActivityId;
        this.type = type;
    }   

    public String getSourceActivityId() {
        return sourceActivityId;
    }

    public void setSourceActivityId(String sourceActivityId) {
        this.sourceActivityId = sourceActivityId;
    }

    public String getTargetActivityId() {
        return targetActivityId;
    }

    public void setTargetActivityId(String targetActivityId) {
        this.targetActivityId = targetActivityId;
    }

    public GanttConstraintType getType() {
        return type;
    }

    public void setType(GanttConstraintType type) {
        this.type = type;
    }
}