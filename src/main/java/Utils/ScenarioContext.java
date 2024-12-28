package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(String key){
        return scenarioContext.get(key.toString());
    }

    public Optional<String> getOptionalContext(String key) {
        Object value = scenarioContext.get(key);
        if (value == null) {
            return Optional.empty();
        }
        return Optional.of(value.toString());
    }
    public Map<String, Object> getAllContext() {
        return new HashMap<>(scenarioContext); // Return a copy to ensure immutability
    }
}
