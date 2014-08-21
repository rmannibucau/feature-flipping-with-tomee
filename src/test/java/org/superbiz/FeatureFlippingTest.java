package org.superbiz;

import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.superbiz.api.DateService;
import org.superbiz.impl.FeatureFlippingBean;

import javax.ejb.EJB;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@EnableServices("jax-rs")
@RunWith(ApplicationComposer.class)
public class FeatureFlippingTest {
    @Module
    @Classes(FeatureFlippingBean.class)
    public WebApp war() {
        return new WebApp().contextRoot("demo");
    }

    @EJB
    private DateService bean;

    @Test
    public void nowLocal() {
        assertEquals(501, bean.now().getStatus());
    }

    @Test
    public void nowFromRest() throws Exception {
        final Response response = ClientBuilder.newClient().target("http://127.0.0.1:4204/demo/date/now").request().get();
        assertEquals(501, response.getStatus());
    }
}
