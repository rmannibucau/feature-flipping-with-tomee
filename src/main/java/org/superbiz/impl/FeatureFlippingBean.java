package org.superbiz.impl;

import org.superbiz.api.DateService;
import org.superbiz.api.Instant;

import javax.ejb.Singleton;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

@Singleton
public abstract class FeatureFlippingBean implements DateService, InvocationHandler {
    @Override
    public Response zero() {
        return Response.ok(new Instant(new Date(0))).build();
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
