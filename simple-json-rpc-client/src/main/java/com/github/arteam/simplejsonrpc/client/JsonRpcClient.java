package com.github.arteam.simplejsonrpc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

/**
 * Date: 8/9/14
 * Time: 8:58 PM
 * <p/>
 * JSON-RPC client. Represents a factory for a fluent client API {@link RequestBuilder}.
 * It's parametrized by {@link Transport} and Jackson {@link ObjectMapper}
 *
 * @author Artem Prigoda
 */
public class JsonRpcClient {

    /**
     * Transport for performing JSON-RPC requests and returning responses
     */
    @NotNull
    private Transport transport;

    /**
     * JSON mapper for conversion between JSON and Java types
     */
    @NotNull
    private ObjectMapper mapper;

    /**
     * Constructs a new JSON-RPC client with a specified transport
     *
     * @param transport transport implementation
     */
    public JsonRpcClient(@NotNull Transport transport) {
        this(transport, new ObjectMapper());
    }

    /**
     * Constructs a new JSON-RPC client with a specified transport and user-definder JSON mapper
     *
     * @param transport transport implementation
     * @param mapper    JSON mapper
     */
    public JsonRpcClient(@NotNull Transport transport, @NotNull ObjectMapper mapper) {
        this.transport = transport;
        this.mapper = mapper;
    }

    /**
     * Creates a builder of a JSON-RPC request in initial state
     *
     * @return request builder
     */
    @NotNull
    public RequestBuilder<Object> createRequest() {
        return new RequestBuilder<Object>(transport, mapper);
    }

}
