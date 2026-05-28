
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        // Render portunu avtomatik oxuyuruq
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Səhifənin Haker stilində HTML və CSS dizaynı
                String response = "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "<title>Dead Shot Panel</title>" +
                        "<style>" +
                        "body { background-color: #0d1117; color: #00ff00; font-family: 'Courier New', monospace; text-align: center; padding: 30px; }" +
                        ".panel { border: 2px solid #ff0055; padding: 25px; display: inline-block; background: #161b22; border-radius: 12px; box-shadow: 0 0 20px #ff0055; max-width: 90%; }" +
                        "h1 { color: #ff0055; text-shadow: 0 0 15px #ff0055; font-size: 26px; margin-bottom: 5px; }" +
                        "p { color: #8b949e; font-size: 14px; }" +
                        ".stat { font-size: 18px; margin: 15px 0; text-align: left; color: #ffffff; border-bottom: 1px solid #21262d; padding-bottom: 8px; }" +
                        ".highlight { color: #00ff00; font-weight: bold; text-shadow: 0 0 5px #00ff00; }" +
                        ".gems { color: #00d2ff; font-weight: bold; text-shadow: 0 0 5px #00d2ff; }" +
                        "</style>" +
                        "</head>" +
                        "<body>" +
                        "<div class='panel'>" +
                        "<h1>🎯 DEAD SHOT HACKER PANEL 🎯</h1>" +
                        "<p>System Security: Override Successful</p>" +
                        "<hr style='border-color: #ff0055; margin: 20px 0;'>" +
                        "<div class='stat'>💻 Server Status: <span class='highlight'>ONLINE (24/7)</span></div>" +
                        "<div class='stat'>👤 Owner: <span class='highlight'>Umid (Dead Shot)</span></div>" +
                        "<div class='stat'>💎 Brawl Stars Elmas: <span class='gems'>20,000 GEMS (Simulated)</span></div>" +
                        "<div class='stat'>🚀 Engine: <span class='highlight'>Java HttpServer Cloud v1.2</span></div>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                
                // Kodun növünü brauzerə HTML olaraq tanıadırıq və Azərbaycan şriftlərini aktiv edirik
                byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(200, bytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            }
        });
        
        server.setExecutor(null);
        server.start();
        System.out.println("Dead Shot server " + port + " portunda aktiv edildi!");
    }
}
