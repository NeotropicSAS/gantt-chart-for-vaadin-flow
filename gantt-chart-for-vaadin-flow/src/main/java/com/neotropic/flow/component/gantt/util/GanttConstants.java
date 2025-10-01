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
package com.neotropic.flow.component.gantt.util;

/**
 * GanttConstants for Gantt chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttConstants {
    /**
     * THe id used by the div
     */
    public static final String GANTT = "gantt";
    /**
     * General properties. They apply to activities, resources
     */
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PARENT = "parent";
    /**
     * Properties for activities. They define start date and end date
     */
    public static final String DATEFORMAT = "dateFormat";
    public static final String START = "start";
    public static final String END = "end";
    /**
     * Properties for reservations. Resource id and activity id that are related 
     */
    public static final String RESOURCE = "resource";
    public static final String ACTIVITY = "activity";
    /**
     * Properties for constraints.
     */
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String TYPE = "type";
    /**
     * Properties for data
     */
    public static final String DATA = "data";
    public static final String RESOURCES = "resources";
    public static final String ACTIVITIES = "activities";
    public static final String RESERVATIONS = "reservations";
    public static final String CONSTRAINTS = "constraints";
    /**
     * Properties for toolbar
     */
    public static final String TOOLBAR = "toolbar";
    public static final String TITLE = "title";
    public static final String SEARCH = "search";
    public static final String SEPARATOR = "separator";
    public static final String MINI = "mini";
    public static final String FIT_TO_CONTENT = "fitToContent";
    public static final String ZOOM_IN = "zoomIn";
    public static final String ZOOM_OUT = "zoomOut";
    public static final String TOGGLE_LOAD_CHART = "toggleLoadChart";
    /**
     * Properties for customization
     */
    public static final String TABLE = "table";
    public static final String TIMETABLE = "timeTable";
    public static final String COLUMNS = "columns";
    public static final String RENDERER = "renderer";
    public static final String TEXT = "text";
    public static final String BACKGROUND = "background";
    public static final String VALUES = "values";
    public static final String PALETTE = "palette";
    public static final String COLOR = "color";
}