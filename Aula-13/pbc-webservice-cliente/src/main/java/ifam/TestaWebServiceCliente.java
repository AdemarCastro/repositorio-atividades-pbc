package ifam;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestaWebServiceCliente {
    public static void main(String[] args) {

//        Chamada de uma service que acabamos de criar
//        Estamos consumindo uma web service
        Client cliente = ClientBuilder.newClient();

        String baseUrl = "http://localhost:8080/api/validation/name/";

        String input = "Ademar15";

        Response response = cliente.target(baseUrl + input).request(MediaType.APPLICATION_JSON).get();

        if(response.getStatus() == Response.Status.OK.getStatusCode()){
            System.out.println(response.readEntity(String.class));
        }else{
            System.out.println("Erro ao chamar o serviço! "+response.getStatus());
        }

    }
}