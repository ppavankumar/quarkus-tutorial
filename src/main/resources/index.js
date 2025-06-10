const ws = new WebSocket("ws://localhost:9090/chat");
ws.onmessage = (event) => console.log("Received:", event.data);
ws.send("Hello WebSocket!");
