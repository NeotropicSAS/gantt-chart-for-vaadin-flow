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

import java.util.HashMap;

/**
 * This class provides information about the attributes that make up the column of the chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttColumn {
    /**
     * The title of the column.
     */
    private String title;
    /**
     * The text of the column.
     */
    private String text;
    
    /**
     * Expression to get the value. Example '<b>object.</b>propertyX', the possible values given by the expression must be in the backgroundPalette.keys
     */
    private String backgroundValueExpression;
    /**
     * List of possible colors. Example [null : '#FFFFFF', red : '#FF0000', green : '#008000', blue : '#0000FF']
     */
    private HashMap<String, String> backgroundPalette;

    /**
     * Constructor of the chart column. With a title and text.
     * @param title The title of the column.
     * @param text The text of the column,
     * this must match the key of the recourse property, 
     * with the prefix defined in the configuration data of the Gantt (object).
     * Example "object.propertyX".
     */
    public GanttColumn(String title, String text) {
        this.title = title;
        this.text = text;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    /**
     * Set the cell background. Using the value expression
     * <pre>
     * Example:
     * backgroundValueExpression = 'object.propertyX' = 'green' <b>and</b>
     * backgroundPalette = [
     *    null : '#FFFFFF',
     *    red : '#FF0000', 
     *    green : '#008000', 
     *    blue : '#0000FF'
     * ] <b>then</b>
     * background = palette['green'] = '#008000'
     * </pre>
     * @param backgroundValueExpression Expression to get the value. Example '<b>object.</b>propertyX', the possible values given by the expression must be in the palette keys
     * @param backgroundPalette List of possible colors. Example [null : '#FFFFFF', red : '#FF0000', green : '#008000', blue : '#0000FF']
     */
    public void setBackground(String backgroundValueExpression, HashMap<String, String> backgroundPalette) {
        this.backgroundValueExpression = backgroundValueExpression;
        this.backgroundPalette = backgroundPalette;
    }
    
    public String getBackgroundValueExpression() {
        return backgroundValueExpression;
    }
    
    public HashMap<String, String> getBackgroundPalette() {
        return backgroundPalette;
    }
}