package org.example;

import org.example.calcultator.domain.Calculator;
import org.example.calcultator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);

    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        /**
         * step1 - 사용자 요청을 메인 쓰레드가 처리하도록 한다.
         */

        logger.info("[ClientRequestHandler] new Client {} started", Thread.currentThread().getName());
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);


            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);

            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
