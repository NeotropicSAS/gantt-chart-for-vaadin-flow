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

class ganttApiLoader {
    load() {
        if (!this.promise) {
            this.promise = new Promise(resolve => {
                this.resolve = resolve;
                
                /*const link = document.createElement('link');
                link.href = 'https://www.unpkg.com/ibm-gantt-chart@0.5.22/dist/ibm-gantt-chart.css';
                link.rel = 'stylesheet';*/
                
                const script = document.createElement('script');
                //script.src= './gantt/ibm-gantt-chart.js';
                script.src = 'https://www.unpkg.com/ibm-gantt-chart@0.5.3/dist/ibm-gantt-chart.js';
                script.type= 'text/javascript';
                script.async = true;
                script.addEventListener('load', () => {
                    this.ready();
                });
                
                document.body.append(script);
            });  
        }
        return this.promise;
    }
    
    ready() {
        if (this.resolve) {
            this.resolve();
        }
    }
}

export {ganttApiLoader};