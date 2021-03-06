package io.tracee.binding.jaxrs2;

import io.tracee.testhelper.SimpleTraceeBackend;
import io.tracee.TraceeBackend;
import io.tracee.TraceeConstants;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TraceeClientFilterResponseTest {

    private final TraceeBackend backend = SimpleTraceeBackend.createNonLoggingAllPermittingBackend();
    private final TraceeClientFilter unit = new TraceeClientFilter(backend);
    private final ClientResponseContext clientResponseContext = mock(ClientResponseContext.class);
    private final MultivaluedMap<String, String> headers = new MultivaluedHashMap<String, String>();

    @Before
    public void setUp() {
        when(clientResponseContext.getHeaders()).thenReturn(headers);
        backend.clear();
    }

    @Test
    public void testFilterParsesContextFromHeaderToBackend() throws IOException {
        headers.putSingle(TraceeConstants.TPIC_HEADER, "foo=bar");
        unit.filter(null, clientResponseContext);
        assertThat(backend.get("foo"), equalTo("bar"));
    }
}
