package com.liferay;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        this.scenarioContext = new HashMap<String, Object>();
    }

    public void setContext(Context key, Object value) {
        this.scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }
}
