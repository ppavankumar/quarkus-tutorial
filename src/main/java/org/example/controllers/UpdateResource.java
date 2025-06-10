package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.config.ws.ChatWebSocket;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateResource {
    private final ChatWebSocket chatWebSocket;

    public UpdateResource(ChatWebSocket chatWebSocket) {
        this.chatWebSocket = chatWebSocket;
    }

    @POST
    @Path("/send-update")
    public void sendUpdate(String message) {
        chatWebSocket.onMessage(message);
    }
}
