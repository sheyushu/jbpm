/**
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
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

package org.jbpm.workflow.core.node;

import org.kie.api.definition.process.Node;


public class DynamicNode extends CompositeContextNode {

	private static final long serialVersionUID = 510l;
	
	private boolean autoComplete = false;
	private String completionExpression;
		
	public boolean isAutoComplete() {
		return autoComplete;
	}

	public void setAutoComplete(boolean autoComplete) {
		this.autoComplete = autoComplete;
	}

	public boolean acceptsEvent(String type, Object event) {
		for (Node node: getNodes()) {
			if (type.equals(node.getName()) && node.getIncomingConnections().isEmpty()) {
				return true;
			}
		}
		return super.acceptsEvent(type, event);
	}
	
    public Node internalGetNode(long id) {
    	try {
    		return getNode(id);
    	} catch (IllegalArgumentException e) {
    		return null;
    	}
    }

	public String getCompletionExpression() {
		return completionExpression;
	}

	public void setCompletionExpression(String expression) {
		this.completionExpression = expression;
	}
}
