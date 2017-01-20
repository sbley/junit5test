package de.sbley.junit5.engine;

import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine;

public class CoffeeTestEngine extends HierarchicalTestEngine<CoffeeEngineExecutionContext> {

    public static final String ENGINE_ID = "sbley-coffee";

    @Override
    public String getId() {
        return ENGINE_ID;
    }

    @Override
    public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId) {
        EngineDescriptor engineDescriptor = new EngineDescriptor(uniqueId, "☕ The Coffee Engine ☕");
        resolveDiscoveryRequest(discoveryRequest, engineDescriptor);
        return engineDescriptor;
    }

    private void resolveDiscoveryRequest(EngineDiscoveryRequest discoveryRequest, EngineDescriptor engineDescriptor) {

    }

    @Override
    protected CoffeeEngineExecutionContext createExecutionContext(ExecutionRequest request) {
        return new CoffeeEngineExecutionContext();
    }
}
