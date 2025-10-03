/*
 *  Copyright 2010-2022 Neotropic SAS <contact@neotropic.co>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://apache.org/licenses/LICENSE-2.0.txt
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.neotropic.flow.component.gantt;

import com.neotropic.flow.component.gantt.services.ProjectsService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The view that will display the actual Gantt Chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
@NpmPackage(value = "ibm-gantt-chart", version = "^0.5.22")
@CssImport("ibm-gantt-chart/dist/ibm-gantt-chart.css")
@JavaScript("ibm-gantt-chart/dist/ibm-gantt-chart.js")
public class Gantt extends Div implements HasComponents, HasStyle, HasSize { 

    private final ProjectsService service;
    
    public Gantt(ProjectsService service) {
        setHeightFull();
        setWidthFull();
        setId("gantt");
        this.service = service;
    }
    
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent); 
        
        try {
            attachEvent.getUI().getPage().executeJs(service.createProject());
        } catch (Exception ex) {
            Logger.getLogger(Gantt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}