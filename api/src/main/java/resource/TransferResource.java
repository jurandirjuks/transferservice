package resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;

public class TransferResource {

    public static Route transfer = (Request request, Response response) -> {
        ObjectMapper objectMapper = new ObjectMapper();
        TransferVO transferVO = objectMapper.readValue(request.body(), TransferVO.class);
        return transferVO;
    };
}
