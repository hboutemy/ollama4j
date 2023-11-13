package io.github.amithkoujalgi.ollama4j;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import io.github.amithkoujalgi.ollama4j.core.types.OllamaModelType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class TestMockedAPIs {
    @Test
    public void testMockPullModel() {
        OllamaAPI ollamaAPI = Mockito.mock(OllamaAPI.class);
        String model = OllamaModelType.LLAMA2;
        try {
            doNothing().when(ollamaAPI).pullModel(model);
            ollamaAPI.pullModel(model);
            verify(ollamaAPI, times(1)).pullModel(model);
        } catch (IOException | OllamaBaseException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
