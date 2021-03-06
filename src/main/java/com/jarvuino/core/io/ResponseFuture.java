package com.jarvuino.core.io;

import com.google.common.util.concurrent.AbstractFuture;
import com.jarvuino.core.io.handler.ResponseChannelHandler;

public class ResponseFuture extends AbstractFuture<String> implements ResponseListener<String> {

    public final int callbackId;

    public ResponseFuture(ResponseChannelHandler handler) {
        callbackId = handler.addListener(this);
    }

    @Override
    public void onMessage(String msg) {
        this.set(msg);
    }
}
