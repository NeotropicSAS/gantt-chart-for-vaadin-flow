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

import com.neotropic.flow.component.gantt.util.GanttConstants;
import com.neotropic.flow.component.gantt.util.GanttToolbar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Gantt chart is a bar chart that shows time along a horizontal axis and
 * activities placed as bars along the time line. Each activity has a start time
 * and an end time. Gantt charts are often used to depict planning and
 * scheduling information and also in project management to represent work
 * breakdown structures.
 * 
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttChart {
    /**
     * The id used by the div that will contain the chart.
     */
    private final String divId = GanttConstants.GANTT;
    /**
     * Additional columns.
     */
    private final List<GanttColumn> columns;
    /**
     * GanttActivity list.
     */
    private final List<GanttActivity> activities;
    /**
     * GanttResource list.
     */
    private final List<GanttResource> resources;
    /**
     * GanttReservation list.
     */
    private final List<GanttReservation> reservations;
    /**
     * GanttConstraint list.
     */
    private final List<GanttConstraint> constraints;
    /**
     * GanttChart data.
     */
    private String data = "";
    /**
     * GanttChart data configuration.
     */
    private String configuration = "";
    /**
     * GanttChart toolbar.
     */
    private final GanttToolbar toolbar;
    private String aToolbar;

    /**
     * Build an Activity Chart, without toolbar.
     * Activity charts also show when things happen, but they are organized according to the activities rather than the resources.
     * Activities can be broken up into tasks and each task is represented as a horizontal bar along a time scale.
     * You might have some restrictions concerning when different activities start or end in relation to each other. 
     * These dependencies are depicted by arrows between activities and are called constraints.
     * 
     * @param activities Activities list. See the GanttActivity class {@link GanttActivity#GanttActivity}
     * @param columns Columns list. See the GanttColumn class {@link GanttColumn#GanttColumn}
     * @param constraints Constraints list. See the GanttConstraint {@link GanttConstraint#GanttConstraint} 
     */
    public GanttChart(List<GanttActivity> activities, List<GanttColumn> columns, List<GanttConstraint> constraints) {
        this.activities = activities;
        this.constraints = constraints;
        this.columns = columns;
        this.resources = null;
        this.reservations = null;
        this.toolbar = null;
    }

    /**
     * Build an Activity Chart with toolbar.
     * Activity charts also show when things happen, but they are organized according to the activities rather than the resources.
     * Activities can be broken up into tasks and each task is represented as a horizontal bar along a time scale.
     * You might have some restrictions concerning when different activities start or end in relation to each other. 
     * These dependencies are depicted by arrows between activities and are called constraints.
     * The toolbar contains options that allow you to fit content.
     * 
     * @param toolbar Chart toolbar. See the GanttToolbar class {@link GanttToolbar#GanttToolbar} 
     * @param activities Activities list. See the GanttActivity class {@link GanttActivity#GanttActivity}
     * @param columns Columns list. See the GanttColumn class {@link GanttColumn#GanttColumn}
     * @param constraints Constraints list. See the GanttConstraint {@link GanttConstraint#GanttConstraint} 
     */
    public GanttChart(GanttToolbar toolbar, List<GanttActivity> activities, List<GanttColumn> columns, List<GanttConstraint> constraints) {
        this.toolbar = toolbar;
        this.activities = activities;
        this.constraints = constraints;
        this.columns = columns;
        this.resources = null;
        this.reservations = null;
    }
    
    /**
     * Build a Scheduling chart, without toolbar.
     * Scheduling charts show who is doing what and when in your plan. 
     * They are used to track simultaneous activities and resources.
     * An activity is anything you want to plan, monitor or schedule over time.
     * It has a start and end time (and consequently a duration). 
     * A resource can be human, machine, equipment or anything you want to use for the activities.
     * A particular assignment of a resource to an activity is called a reservation.
     * 
     * @param resources Resources list. See the GanttRecourse class {@link GanttResource#GanttResource}
     * @param columns Columns list. See the GanttColumn class {@link GanttColumn#GanttColumn}
     * @param activities Activities list. See the GanttActivity class {@link GanttActivity#GanttActivity}
     * @param reservations Reservations list. See the GanttReservation class {@link GanttReservation#GanttReservation}
     */
    public GanttChart(List<GanttResource> resources, List<GanttColumn> columns, List<GanttActivity> activities, List<GanttReservation> reservations) {
        this.activities = activities;
        this.resources = resources;
        this.reservations = reservations;
        this.columns = columns;
        this.constraints = null;
        this.toolbar = null;
    }

    /**
     * Build a scheduling chart with toolbar.
     * Scheduling charts show who is doing what and when in your plan. 
     * They are used to track simultaneous activities and resources.
     * An activity is anything you want to plan, monitor or schedule over time.
     * It has a start and end time (and consequently a duration). 
     * A resource can be human, machine, equipment or anything you want to use for the activities.
     * A particular assignment of a resource to an activity is called a reservation.
     * The toolbar contains options that allow you to fit content.
     * 
     * @param toolbar Chart toolbar. See the GanttToolbar class {@link GanttToolbar#GanttToolbar} 
     * @param resources Resources list. See the GanttRecourse class {@link GanttResource#GanttResource}
     * @param columns Columns list. See the GanttColumn class {@link GanttColumn#GanttColumn}
     * @param activities Activities list. See the GanttActivity class {@link GanttActivity#GanttActivity}
     * @param reservations Reservation list. See the GanttReservation class {@link GanttReservation#GanttReservation}
     */
    public GanttChart(GanttToolbar toolbar, List<GanttResource> resources, List<GanttColumn> columns, List<GanttActivity> activities, List<GanttReservation> reservations) {
        this.toolbar = toolbar;
        this.activities = activities;
        this.resources = resources;
        this.reservations = reservations;
        this.columns = columns;
        this.constraints = null;
    }

    public List<GanttActivity> getActivities() {
        return activities;
    }

    public List<GanttResource> getResources() {
        return resources;
    }

    public List<GanttReservation> getReservations() {
        return reservations;
    }

    public List<GanttConstraint> getConstraints() {
        return constraints;
    }

    /**
     * The JavaScript block necessary to render the scheduling chart in the page.
     * @return The Scheduling Chart.
     */
    public String schedulingChart() {
        String getResources = resources.stream().map(resource -> {
            String aResource = "";

            aResource = "{\n"
                    + "\"" + GanttConstants.ID + "\"" + ":" + "\"" + resource.getId() + "\"" + ",\n"
                    + "\"" + GanttConstants.NAME + "\"" + ":" + "\"" + resource.getName() + "\""
                    + (resource.getParentId() == null ? "" : ",\n" + "\"" + GanttConstants.PARENT + "\"" + ":" + "\"" + resource.getParentId()) + "\"" + ",\n";

            if (resource.getProperties() != null && !resource.getProperties().isEmpty()) {
                for (String key : resource.getProperties().keySet())
                    aResource += "\"" + key + "\"" + ":" + "\"" + resource.getProperties().get(key) + "\",";
            }

            aResource += "}";

            return aResource;
        }).collect(Collectors.joining(",\n"));

        String getActivities = activities.stream().map(activity -> {
            String aActivity = "";

            aActivity = "{\n"
                    + "\"" + GanttConstants.ID + "\"" + ":" + "\"" + activity.getId() + "\"" + ",\n"
                    + "\"" + GanttConstants.NAME + "\"" + ":" + "\"" + activity.getName() + "\""
                    + (activity.getParentId() == null ? "" + "," : ",\n" + "\"" + GanttConstants.PARENT + "\"" + ":" + "\"" + activity.getParentId()) + "\"" + ",\n"
                    + "\"" + GanttConstants.START + "\"" + ":" + activity.getStart() + ",\n"
                    + "\"" + GanttConstants.END + "\"" + ":" + activity.getEnd() + ",\n";

            if (activity.getProperties() != null && !activity.getProperties().isEmpty()) {
                for (String key : activity.getProperties().keySet())
                    aActivity += "\"" + key + "\"" + ":" + "\"" + activity.getProperties().get(key) + "\",";
            }

            aActivity += "}";

            return aActivity;
        }).collect(Collectors.joining(",\n"));

        String getReservations = reservations.stream().map(reservation -> {
            return "{\n"
                    + GanttConstants.RESOURCE + ":" + "\"" + reservation.getResourceId() + "\"" + ",\n"
                    + GanttConstants.ACTIVITY + ":" + "\"" + reservation.getActivityId() + "\"" + "\n"
                    + "}";
        }).collect(Collectors.joining(",\n"));

        String resource = "{\n"
                + GanttConstants.DATA + ":[\n" + getResources + "\n],\n"
                + GanttConstants.PARENT + ":" + "\"" + GanttConstants.PARENT + "\"" + ",\n"
                + GanttConstants.NAME + ":" + "\"" + GanttConstants.NAME + "\"" + ",\n"
                + GanttConstants.ID + ":" + "\"" + GanttConstants.ID + "\"" + ",\n"
                + "}";

        String activity = "{\n"
                + GanttConstants.DATA + ":[\n" + getActivities + "\n],\n"
                + GanttConstants.PARENT + ":" + "\"" + GanttConstants.PARENT + "\"" + ",\n"
                + GanttConstants.START + ":" + "\"" + GanttConstants.START + "\"" + ",\n"
                + GanttConstants.END + ":" + "\"" + GanttConstants.END + "\"" + ",\n"
                + GanttConstants.NAME + ":" + "\"" + GanttConstants.NAME + "\"" + ",\n"
                + GanttConstants.ID + ":" + "\"" + GanttConstants.ID + "\"" + ",\n"
                + "}";

        String reservation = "{\n"
                + GanttConstants.DATA + ":[\n" + getReservations + "\n],\n"
                + GanttConstants.ACTIVITY + ":" + "\"" + GanttConstants.ACTIVITY + "\"" + ",\n"
                + GanttConstants.RESOURCE + ":" + "\"" + GanttConstants.RESOURCE + "\"" + ",\n"
                + "}";

        if (constraints != null && !constraints.isEmpty()) {
            String getConstraints = constraints.stream().map(constraint -> {
                return "{\n"
                        + GanttConstants.FROM + ":" + "\"" + constraint.getSourceActivityId() + "\"" + ",\n"
                        + GanttConstants.TO + ":" + "\"" + constraint.getTargetActivityId() + "\"" + ",\n"
                        + GanttConstants.TYPE + ":" + constraint.getType().getType() + "\n"
                        + "}";
            }).collect(Collectors.joining(",\n"));

            String constraint = "{\n"
                    + GanttConstants.DATA + ":[\n" + getConstraints + "\n],\n"
                    + GanttConstants.FROM + ":" + "\"" + GanttConstants.FROM + "\"" + ",\n"
                    + GanttConstants.TO + ":" + "\"" + GanttConstants.TO + "\"" + ",\n"
                    + GanttConstants.TYPE + ":" + "\"" + GanttConstants.TYPE + "\"" + ",\n"
                    + "}";

            data = "{\n"
                    + GanttConstants.RESOURCES + ":" + resource + ",\n"
                    + GanttConstants.ACTIVITIES + ":" + activity + ",\n"
                    + GanttConstants.CONSTRAINTS + ":" + constraint + ",\n"
                    + GanttConstants.RESERVATIONS + ":" + reservation + "\n"
                    + "}";
        } else 
            data = "{\n"
                    + GanttConstants.RESOURCES + ":" + resource + ",\n"
                    + GanttConstants.ACTIVITIES + ":" + activity + ",\n"
                    + GanttConstants.RESERVATIONS + ":" + reservation + "\n"
                    + "}";

        if (toolbar != null) {
            aToolbar = "[";
            if (toolbar.getTitle() != null) 
                aToolbar += "\"" + GanttConstants.TITLE + "\"" + ",\n";
            if (toolbar.isSeparator())
                aToolbar += "\"" + GanttConstants.SEPARATOR + "\"" + ",\n";
            if (toolbar.isFitToContent())
                aToolbar += "\"" + GanttConstants.FIT_TO_CONTENT + "\"" + ",\n";
            if (toolbar.isZoomIn())
                aToolbar += "\"" + GanttConstants.ZOOM_IN + "\"" + ",\n";
            if (toolbar.isZoomOut())
                aToolbar += "\"" + GanttConstants.ZOOM_OUT + "\"" + ",\n";
            if (toolbar.isMini())
                aToolbar += "\"" + GanttConstants.MINI + "\"" + ",\n";
            aToolbar += "]";
        }

        String timeTable = "{\n"
                + GanttConstants.RENDERER + ":"
                + "{\n"
                + "text(activity) {\n"
                + "return " + "activity.name" + ";\n"
                + "},\n"
                + "textOverflow:" + "\"" + "noDisplay" + "\"" + ",\n"
                + GanttConstants.BACKGROUND + ":"
                + "{\n"
                // uncomment if you want to add custom backgrounds
                /*+ "palette:"
                + "["
                + "\"" + "#5aa8f8" + "\","
                + "\"" + "#4178bc" + "\","
                + "\"" + "#8cd211" + "\","
                + "\"" + "#c8f08f" + "\","
                + "\"" + "#ba8ff7" + "\","
                + "\"" + "#a6266e" + "\","
                + "\"" + "#ff7832" + "\""
                + "],\n"*/
                + "getValue:" + "\"" + "name" + "\"" + "\n"
                + "},\n"
                + GanttConstants.COLOR + ":" + "\"" + "automatic" + "\"" + ",\n"
                + "tooltipProperties(activity) {\n"
                + "const props = ['Start', new Date(activity.start).format(), 'End', new Date(activity.end).format()];\n";
        if (activities != null && !activities.isEmpty()) {
            for (GanttActivity aActivity : activities) {
                if (aActivity.getProperties() != null && !aActivity.getProperties().isEmpty()) {
                    for (String key : aActivity.getProperties().keySet())
                        timeTable += "if(activity.id ===" + "\"" + aActivity.getId() + "\"" + ")"
                                + "{"
                                + "props.push(" + "\"" + key + "\"" + ");\n"
                                + "props.push(" + "\"" + aActivity.getProperties().get(key) + "\"" + ");\n"
                                + "}";
                }
            }
        }
        timeTable += "return props\n"
                + "},\n"
                + "},\n"
                + "}\n";

        if (columns != null && !columns.isEmpty()) {
            String getColumns = columns.stream().map(column -> {
                String aColumn = "";

                aColumn += "{\n"
                        + GanttConstants.TITLE + ":" + "\"" + column.getTitle() + "\"" + ",\n"
                        + GanttConstants.RENDERER + ":"
                        + "{\n"
                        + "text(object) {\n"
                        + "return " + (column.getText() == null || column.getText().isEmpty() ? "" : column.getText()) + ";\n"
                        + "},\n"
                        + "},\n"
                        + "}";
                return aColumn;
            }).collect(Collectors.joining(",\n"));

            String table = "{\n"
                    + GanttConstants.COLUMNS + ":[\n" + getColumns + "\n],\n"
                    + "}";

            configuration = "{\n"
                    + GanttConstants.DATA + ":" + data + ",\n"
                    + GanttConstants.TABLE + ":" + table + ",\n"
                    + GanttConstants.DATEFORMAT + ":" + "\"" + "yyyy-MM-dd" + "\"" + ",\n"
                    + GanttConstants.TIMETABLE + ":" + timeTable + ",\n";

            if (toolbar != null)
                configuration += GanttConstants.TOOLBAR + ":" + aToolbar + ",\n"
                        + GanttConstants.TITLE + ":" + "\"" + toolbar.getTitle() + "\"" + "\n";

            configuration += "}";
        } else {
            configuration = "{\n"
                    + GanttConstants.DATA + ":" + data + ",\n"
                    + GanttConstants.DATEFORMAT + ":" + "\"" + "yyyy-MM-dd" + "\"" + ",\n";
            if (toolbar != null)
                configuration += GanttConstants.TOOLBAR + ":" + aToolbar + ",\n"
                        + GanttConstants.TITLE + ":" + "\"" + toolbar.getTitle() + "\"" + "\n";

            configuration += "}";
        }

        return "new Gantt(" + divId + ", " + configuration + ");";
    }

    /**
     * The JavaScript block necessary to render the activity chart in the page.
     * @return The Activity Chart.
     */
    public String activityChart() {
        String getActivities = activities.stream().map(activity -> {
            String aActivity = "";

            aActivity = "{\n"
                    + "\"" + GanttConstants.ID + "\"" + ":" + "\"" + activity.getId() + "\"" + ",\n"
                    + "\"" + GanttConstants.NAME + "\"" + ":" + "\"" + activity.getName() + "\""
                    + (activity.getParentId() == null ? "" + "," : ",\n" + "\"" + GanttConstants.PARENT + "\"" + ":" + "\"" + activity.getParentId()) + "\"" + ",\n"
                    + "\"" + GanttConstants.START + "\"" + ":" + activity.getStart() + ",\n"
                    + "\"" + GanttConstants.END + "\"" + ":" + activity.getEnd() + ",\n"
                    ;

            if (activity.getProperties() != null && !activity.getProperties().isEmpty()) {
                for (String key : activity.getProperties().keySet())
                    aActivity += "\"" + key + "\"" + ":" + "\"" + activity.getProperties().get(key) + "\",";
            }

            aActivity += "}";

            return aActivity;
        }).collect(Collectors.joining(",\n"));

        String activity = "{\n"
                + GanttConstants.DATA + ":[\n" + getActivities + "\n],\n"
                + GanttConstants.PARENT + ":" + "\"" + GanttConstants.PARENT + "\"" + ",\n"
                + GanttConstants.START + ":" + "\"" + GanttConstants.START + "\"" + ",\n"
                + GanttConstants.END + ":" + "\"" + GanttConstants.END + "\"" + ",\n"
                + GanttConstants.NAME + ":" + "\"" + GanttConstants.NAME + "\"" + ",\n"
                + GanttConstants.ID + ":" + "\"" + GanttConstants.ID + "\"" + ",\n"
                + "}";

        if (constraints != null && !constraints.isEmpty()) {
            String getConstraints = constraints.stream().map(constraint -> {
                return "{\n"
                        + GanttConstants.FROM + ":" + "\"" + constraint.getSourceActivityId() + "\"" + ",\n"
                        + GanttConstants.TO + ":" + "\"" + constraint.getTargetActivityId() + "\"" + ",\n"
                        + GanttConstants.TYPE + ":" + constraint.getType().getType() + "\n"
                        + "}";
            }).collect(Collectors.joining(",\n"));

            String constraint = "{\n"
                    + GanttConstants.DATA + ":[\n" + getConstraints + "\n],\n"
                    + GanttConstants.FROM + ":" + "\"" + GanttConstants.FROM + "\"" + ",\n"
                    + GanttConstants.TO + ":" + "\"" + GanttConstants.TO + "\"" + ",\n"
                    + GanttConstants.TYPE + ":" + "\"" + GanttConstants.TYPE + "\"" + ",\n"
                    + "}";

            data = "{\n"
                    + GanttConstants.ACTIVITIES + ":" + activity + ",\n"
                    + GanttConstants.CONSTRAINTS + ":" + constraint + ",\n"
                    + "}";
        } else
            data = "{\n"
                    + GanttConstants.ACTIVITIES + ":" + activity + ",\n"
                    + "}";

        if (toolbar != null) {
            aToolbar = "[";
            if (toolbar.getTitle() != null)
                aToolbar += "\"" + GanttConstants.TITLE + "\"" + ",\n";
            if (toolbar.isSeparator())
                aToolbar += "\"" + GanttConstants.SEPARATOR + "\"" + ",\n";
            if (toolbar.isFitToContent())
                aToolbar += "\"" + GanttConstants.FIT_TO_CONTENT + "\"" + ",\n";
            if (toolbar.isZoomIn())
                aToolbar += "\"" + GanttConstants.ZOOM_IN + "\"" + ",\n";
            if (toolbar.isZoomOut())
                aToolbar += "\"" + GanttConstants.ZOOM_OUT + "\"" + ",\n";
            if (toolbar.isMini())
                aToolbar += "\"" + GanttConstants.MINI + "\"" + ",\n";
            aToolbar += "]";
        }

        String timeTable = "";

        timeTable += "{\n"
                + GanttConstants.RENDERER + ":"
                + "{\n"
                + "tooltipProperties(activity) {\n"
                + "const props = ['Start', new Date(activity.start).format(), 'End', new Date(activity.end).format()];\n";
        if (activities != null && !activities.isEmpty()) {
            for (GanttActivity aActivity : activities) {
                if (aActivity.getProperties() != null && !aActivity.getProperties().isEmpty()) {
                    for (String key : aActivity.getProperties().keySet()) {
                        timeTable += "if(activity.id ===" + "\"" + aActivity.getId() + "\"" + ")"
                                + "{"
                                + "props.push(" + "\"" + key + "\"" + ");\n"
                                + "props.push(" + "\"" + aActivity.getProperties().get(key) + "\"" + ");\n"
                                + "}";
                    }
                }
            }
        }
        timeTable += "return props\n"
                + "},\n"
                + "},\n"
                + "}\n";

        if (columns != null && !columns.isEmpty()) {
            String getColumns = columns.stream().map(column -> {
                String aColumn = "";
                
                String backgroundExpression = null;
                if (column.getBackgroundValueExpression() != null && column.getBackgroundValueExpression().startsWith("object.") && 
                    column.getBackgroundPalette() != null && !column.getBackgroundPalette().isEmpty()) {
                    
                    StringBuilder valuesBuilder = new StringBuilder();
                    StringBuilder paletteBuilder = new StringBuilder();
                    
                    valuesBuilder.append("[");
                    paletteBuilder.append("[");
                    
                    column.getBackgroundPalette().forEach((key, value) -> {
                        if (key != null)
                            valuesBuilder.append(String.format("'%s', ", key));
                        else
                            valuesBuilder.append("null,");
                        
                        if (value != null)
                            paletteBuilder.append(String.format("'%s', ", value));
                        else
                            paletteBuilder.append("null,");
                    });
                    valuesBuilder.deleteCharAt(valuesBuilder.length() - 1); //delete - -
                    valuesBuilder.deleteCharAt(valuesBuilder.length() - 1); //delete -,-
                    paletteBuilder.deleteCharAt(paletteBuilder.length() - 1); //delete - -
                    paletteBuilder.deleteCharAt(paletteBuilder.length() - 1); //delete -,-
                    
                    valuesBuilder.append("]");
                    paletteBuilder.append("]");
                    
                    StringBuilder expressionBuilder = new StringBuilder();
                    expressionBuilder.append(String.format("%s: {", GanttConstants.BACKGROUND)).append("\n");
                    expressionBuilder.append("getValue(object) {").append("\n");
                    expressionBuilder.append(String.format("return %s;", column.getBackgroundValueExpression())).append("\n");
                    expressionBuilder.append("},").append("\n");
                    expressionBuilder.append(String.format("values: %s,", valuesBuilder.toString())).append("\n");
                    expressionBuilder.append(String.format("palette: %s,", paletteBuilder.toString())).append("\n");
                    expressionBuilder.append("},").append("\n");
                    
                    backgroundExpression = expressionBuilder.toString();
                }
                aColumn += "{\n"
                        + GanttConstants.TITLE + ":" + "\"" + column.getTitle() + "\"" + ",\n"
                        + GanttConstants.RENDERER + ":"
                        + "{\n"
                        + "text(object) {\n"
                        + "return " + (column.getText() == null || column.getText().isEmpty() ? "" : column.getText()) + ";\n"
                        + "},\n"
                        + (backgroundExpression != null ? backgroundExpression : "")
                        + "},\n"
                        + "}";

                return aColumn;
            }).collect(Collectors.joining(",\n"));

            String table = "{\n"
                    + GanttConstants.COLUMNS + ":[\n" + getColumns + "\n],\n"
                    + "}";

            configuration = "{\n"
                    + GanttConstants.DATA + ":" + data + ",\n"
                    + GanttConstants.TYPE + ":" + "Gantt.type.ACTIVITY_CHART" + ",\n"
                    + GanttConstants.TABLE + ":" + table + ",\n"
                    + GanttConstants.DATEFORMAT + ":" + "\"" + "yyyy-MM-dd" + "\"" + ",\n"
                    + GanttConstants.TIMETABLE + ":" + timeTable + ",\n";

            if (toolbar != null)
                configuration += GanttConstants.TOOLBAR + ":" + aToolbar + ",\n"
                        + GanttConstants.TITLE + ":" + "\"" + toolbar.getTitle() + "\"" + "\n";

            configuration += "}";
        } else {
            configuration = "{\n"
                    + GanttConstants.DATA + ":" + data + ",\n"
                    + GanttConstants.TYPE + ":" + "Gantt.type.ACTIVITY_CHART" + ",\n"
                    + GanttConstants.DATEFORMAT + ":" + "\"" + "yyyy-MM-dd" + "\"" + ",\n"
                    + GanttConstants.TIMETABLE + ":" + timeTable + ",\n";

            if (toolbar != null)
                configuration += GanttConstants.TOOLBAR + ":" + aToolbar + ",\n"
                        + GanttConstants.TITLE + ":" + "\"" + toolbar.getTitle() + "\"" + "\n";

            configuration += "}";
        }

        return "new Gantt(" + divId + ", " + configuration + ");";
    }
}